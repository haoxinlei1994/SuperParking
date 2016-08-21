package com.example.Fragment;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.MarkerOptions.MarkerAnimateType;
import com.baidu.mapapi.model.LatLng;
import com.example.Bmob.Bean;
import com.example.DJstlia.MGraph;
import com.example.DJstlia.Point_Flag;
import com.example.supermap.LoginActivity;
import com.example.supermap.R;
import com.example.supermap.SecondA;
import com.example.supermap.SecondB;
import com.example.supermap.SecondD;
import com.example.supermap.SecondE;
import com.example.supermap.SecondF;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeFragment extends Fragment {

	// 地图控件
	MapView mapView = null;
	// 地图的管理员
	BaiduMap baiduMap = null;

	boolean isFirstLoc = true;// 是否首次定位
	public static final String TAG = "NaviSDkDemo";
	private static final String APP_FOLDER_NAME = "BNSDKDemo";
	private String mSDCardPath = null;
	public static final String ROUTE_PLAN_NODE = "routePlanNode";

	// 定义覆盖物
	public Marker markerA, markerB, markerC, markerD, markerE, markerF;
	private BitmapDescriptor bitmapDescriptor = null;
	private LatLng latLngA, latLngB, latLngC, latLngD, latLngE, latLngF;
	MarkerOptions markerOptions = null;

	// 定位功能
	LocationClient client = null;
	LocationClientOption clientOption = null;
	myBdLocationListener bdLocationListener;
	static LatLng latLngStart = null;

	// 迪杰斯特拉算法需要的数据
	int MAX_V = 30;
	int UNDEFINE = 32767;
	int have[] = new int[30];
	int p[][] = new int[MAX_V][MAX_V];
	int d[] = new int[MAX_V];
	int v0; // 用于计算出表示离定位点最近的点
	Point_Flag point_Flag = new Point_Flag();
	MGraph g = new MGraph();

	// 定义一个标志变量 用来判断导航是不是第一次导航
	int IsFirstNavi = 0; // 0:代表第一次导航 1：代表不是第一次导航

	public Intent intent = new Intent();

	private Overlay overlayLine, overlayStart, overlayEnd;

	// 登陆图标
	private ImageView user_area;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		SDKInitializer.initialize(getActivity().getApplicationContext());

		return inflater.inflate(R.layout.home_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		// 初始化bmob
		Bmob.initialize(getActivity().getApplicationContext(),
				"3dd366acdf71089a6a3d65985df857f6");
		mapView = (MapView) getActivity().findViewById(R.id.bmapView);
		baiduMap = mapView.getMap();
		bdLocationListener = new myBdLocationListener();
		// 地图状态初始化
		mapStatueInit();
		// 初始化控件user_area
		initView();
		// 初始化定位
		initLocationView();
		// 初始化覆盖物控件
		initMarkerview();
		// 为覆盖点添加监听信息
		setMarkerListener();

	}

	private void initView() {
		user_area = (ImageView) getActivity().findViewById(R.id.user_area);
		user_area.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (checkLogin()) {

					SettingFragment settingFragment = new SettingFragment();
					getFragmentManager().beginTransaction()
							.replace(R.id.frameContent, settingFragment)
							.commit();
				} else {
					Intent intent = new Intent(getActivity(),
							LoginActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	// 检查是否登陆
	private boolean checkLogin() {
		BmobUser bmobUser = new BmobUser();
		if (BmobUser.getCurrentUser(getActivity()) == null
				|| BmobUser.getCurrentUser(getActivity()).getUsername() == null) {
			return false;
		}
		return true;
	}

	// 为覆盖点添加监听信息
	private void setMarkerListener() {
		baiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {

			@Override
			public boolean onMarkerClick(Marker arg0) {
				if (arg0 == markerA)
					showDialogue(markerA, 1);

				if (arg0 == markerB) {
					showDialogue(markerB, 2);
				}
				if (arg0 == markerD) {
					showDialogue(markerD, 3);
				}
				if (arg0 == markerE) {
					showDialogue(markerE, 4);
				}
				if (arg0 == markerF) {
					showDialogue(markerF, 5);
				}

				return false;
			}
		});
	}

	/**
	 * 
	 * @param marker
	 * @param flag
	 *            1:SecondA 2:SecondB 3:SecondD 4:SecondE 5:SecondF
	 */
	public void showDialogue(final Marker marker, int flag) {

		if (flag == 1)
			intent.setClass(getActivity(), SecondA.class);
		if (flag == 2)
			intent.setClass(getActivity(), SecondB.class);
		if (flag == 3)
			intent.setClass(getActivity(), SecondD.class);
		if (flag == 4)
			intent.setClass(getActivity(), SecondE.class);
		if (flag == 5)
			intent.setClass(getActivity(), SecondF.class);
		AlertDialog dialog;
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage("是否查看具体停车情况？")
				.setPositiveButton("查看", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						// 用于显示二级界面的代码实现
						startActivity(intent);
					}
				})
				.setNegativeButton("直接导航",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								if (IsFirstNavi == 1) {
									if (overlayEnd != null
											&& overlayLine != null
											&& overlayStart != null) {
										overlayEnd.remove();
										overlayLine.remove();
										overlayStart.remove();
									}
								}
								MyLocationData locationData = baiduMap
										.getLocationData();
								// 1、计算出距离定位点最近的节点

								LatLng latLng = new LatLng(
										locationData.latitude,
										locationData.longitude);
								v0 = getDistance(latLng) + 1;
								// 2、利用算法算出最短的路径,,并返回最短路径列表
								List<LatLng> list = shortPath(g, v0, p, d,
										Integer.parseInt(marker.getTitle()
												.toString()));
								// 3、重新定义一个新的list列表 将定位点的坐标也添加进去
								List<LatLng> list2 = new ArrayList<LatLng>();
								list2.add(latLng);
								for (int i = 0; i < list.size(); i++) {
									LatLng lng = list.get(i);
									list2.add(lng);
								}
								// 4、利用list列表描绘折线
								initLine(list2);
								BitmapDescriptor descriptorEnd = new BitmapDescriptorFactory()
										.fromResource(R.drawable.zhong);
								markerOptions = new MarkerOptions()
										.position(marker.getPosition())
										.icon(descriptorEnd)
										.animateType(MarkerAnimateType.none);
								overlayEnd = baiduMap.addOverlay(markerOptions);
								((Marker) overlayEnd).setToTop(); // 设置起点
								BitmapDescriptor descriptorStart = new BitmapDescriptorFactory()
										.fromResource(R.drawable.qi);
								markerOptions = new MarkerOptions()
										.position(latLng).icon(descriptorStart)
										.animateType(MarkerAnimateType.none);
								overlayStart = baiduMap
										.addOverlay(markerOptions);
								IsFirstNavi = 1; // 导航后 将是否第一次导航信息改变
								Toast.makeText(getActivity(), "路线导航成功！",
										Toast.LENGTH_SHORT).show();
							}
						});

		dialog = builder.create();
		dialog.show();

	}

	// 初始化折线
	private void initLine(List<LatLng> list) {
		// TODO Auto-generated method stub
		PolylineOptions options = new PolylineOptions();
		options.width(13);
		options.color(Color.BLUE);
		options.points(list);
		overlayLine = baiduMap.addOverlay(options);
	}

	// 计算出距离定位点最近的坐标点
	public int getDistance(LatLng latLng) {

		double pk = 180 / 3.14169;
		double minDistance = 32767;
		double a1, a2, b1, b2, t1, t2, t3, tt;
		int flag = 0;
		for (int i = 0; i < 17; i++) {
			a1 = latLng.latitude / pk; // 纬度
			a2 = latLng.longitude / pk; // 经度
			b1 = point_Flag.getY()[i] / pk;
			b2 = point_Flag.getX()[i] / pk;
			t1 = Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2);
			t2 = Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2);
			t3 = Math.sin(a1) * Math.sin(b1);
			tt = Math.acos(t1 + t2 + t3);
			if (tt < minDistance) {
				minDistance = tt;
				flag = i;
			}
		}
		return flag;
	}

	// 迪杰斯特拉算法选出两点之间最短的距离q
	public List<LatLng> shortPath(MGraph g, int v0, int p[][], int d[], int end) {
		int v, w, i, j, min;
		int finall[] = new int[MAX_V];
		int k = 1;
		for (v = 0; v < g.getVexnum(); ++v) {
			// 初始化
			finall[v] = 0;
			d[v] = g.getArcs()[v0 - 1][v];
			for (w = 0; w < g.getVexnum(); ++w) {
				p[v][w] = 0;
			}
			if (d[v] < UNDEFINE) {
				p[v][v0 - 1] = 1;
				p[v][v] = 1;
			}
		}

		d[v0 - 1] = 0;
		finall[v0 - 1] = 1;
		have[0] = v0 - 1;

		for (i = 1; i < g.getVexnum(); ++i) {// 其余的vexnum-1个顶点
			min = UNDEFINE;
			for (w = 0; w < g.getVexnum(); ++w)
				if (finall[w] == 0)
					if (d[w] < min) {
						v = w;
						min = d[w];
					}
			finall[v] = 1;
			have[k] = v;
			k++;
			for (w = 0; w < g.getVexnum(); ++w) {
				if (finall[w] == 0 && (min + g.getArcs()[v][w]) < d[w]) {
					d[w] = min + g.getArcs()[v][w];
					for (j = 0; j < g.getVexnum(); j++)
						p[w][j] = p[v][j];
					p[w][w] = 1;

				}
			}
		}
		List<LatLng> list = new ArrayList<LatLng>();

		for (i = 0; i < g.getVexnum(); i++) {
			if (p[end - 1][have[i]] == 1) {
				/*
				 * num[flag] = g.vexs[have[i]]; flag++;
				 */

				LatLng latLng = new LatLng(
						point_Flag.getY()[g.getVexs()[have[i]] - 1],
						point_Flag.getX()[g.getVexs()[have[i]] - 1]);
				list.add(latLng);

			}
		}

		return list;

	}

	// 初始化地图覆盖物
	private void initMarkerview() {
		// TODO Auto-generated method stub

		BmobQuery<Bean> bmobQuery = new BmobQuery<Bean>();
		bmobQuery.findObjects(getActivity().getApplicationContext(),
				new FindListener<Bean>() {

					@Override
					public void onSuccess(List<Bean> arg0) {
						// TODO Auto-generated method stub
						int A = 0, B = 0, D = 0, E = 0, F = 0;
						for (int i = 0; i < arg0.size(); i++) {
							if (arg0.get(i).getPartNum().charAt(0) == 'A')
								A++;
							if (arg0.get(i).getPartNum().charAt(0) == 'B')
								B++;
							if (arg0.get(i).getPartNum().charAt(0) == 'C') {
							}
							if (arg0.get(i).getPartNum().charAt(0) == 'D')
								D++;
							if (arg0.get(i).getPartNum().charAt(0) == 'E')
								E++;
							if (arg0.get(i).getPartNum().charAt(0) == 'F')
								F++;
						}

						if (A == 18) {
							bitmapDescriptor = new BitmapDescriptorFactory()
									.fromResource(R.drawable.man);
							latLngA = new LatLng(39.535028, 116.746023);
							markerOptions = new MarkerOptions()
									.position(latLngA).icon(bitmapDescriptor)
									.animateType(MarkerAnimateType.grow)
									.title("3");
							markerA = (Marker) baiduMap
									.addOverlay(markerOptions);

						} else {
							bitmapDescriptor = BitmapDescriptorFactory
									.fromResource(R.drawable.kong);
							latLngA = new LatLng(39.535028, 116.746023);
							markerOptions = new MarkerOptions()
									.position(latLngA).icon(bitmapDescriptor)
									.animateType(MarkerAnimateType.grow)
									.title("3");
							markerA = (Marker) baiduMap
									.addOverlay(markerOptions);

						}

						if (B == 18) {
							bitmapDescriptor = BitmapDescriptorFactory
									.fromResource(R.drawable.man);
							latLngB = new LatLng(39.533995, 116.745902);
							markerOptions = new MarkerOptions()
									.position(latLngB).icon(bitmapDescriptor)
									.animateType(MarkerAnimateType.grow)
									.title("6");
							markerB = (Marker) baiduMap
									.addOverlay(markerOptions);

						} else {
							bitmapDescriptor = BitmapDescriptorFactory
									.fromResource(R.drawable.kong);

							latLngB = new LatLng(39.533995, 116.745902);
							markerOptions = new MarkerOptions()
									.position(latLngB).icon(bitmapDescriptor)
									.animateType(MarkerAnimateType.grow)
									.title("6");
							markerB = (Marker) baiduMap
									.addOverlay(markerOptions);

						}

						if (D == 20) {
							bitmapDescriptor = BitmapDescriptorFactory
									.fromResource(R.drawable.man);
							latLngD = new LatLng(39.531547, 116.747869);
							markerOptions = new MarkerOptions()
									.position(latLngD).icon(bitmapDescriptor)
									.animateType(MarkerAnimateType.grow)
									.title("15");
							markerD = (Marker) baiduMap
									.addOverlay(markerOptions);

						} else {
							bitmapDescriptor = BitmapDescriptorFactory
									.fromResource(R.drawable.kong);
							latLngD = new LatLng(39.531547, 116.747869);
							markerOptions = new MarkerOptions()
									.position(latLngD).icon(bitmapDescriptor)
									.animateType(MarkerAnimateType.grow)
									.title("15");
							markerD = (Marker) baiduMap
									.addOverlay(markerOptions);

						}
						if (E == 18) {
							bitmapDescriptor = BitmapDescriptorFactory
									.fromResource(R.drawable.man);
							latLngE = new LatLng(39.53122, 116.747955);
							markerOptions = new MarkerOptions()
									.position(latLngE).icon(bitmapDescriptor)
									.animateType(MarkerAnimateType.grow)
									.title("16");
							markerE = (Marker) baiduMap
									.addOverlay(markerOptions);

						} else {
							bitmapDescriptor = BitmapDescriptorFactory
									.fromResource(R.drawable.kong);
							latLngE = new LatLng(39.53122, 116.747955);
							markerOptions = new MarkerOptions()
									.position(latLngE).icon(bitmapDescriptor)
									.animateType(MarkerAnimateType.grow)
									.title("16");
							markerE = (Marker) baiduMap
									.addOverlay(markerOptions);

						}
						if (F == 27) {
							bitmapDescriptor = BitmapDescriptorFactory
									.fromResource(R.drawable.man);
							latLngF = new LatLng(39.532128, 116.7442);
							markerOptions = new MarkerOptions()
									.position(latLngF).icon(bitmapDescriptor)
									.animateType(MarkerAnimateType.grow)
									.title("17");
							markerF = (Marker) baiduMap
									.addOverlay(markerOptions);

						} else {
							bitmapDescriptor = BitmapDescriptorFactory
									.fromResource(R.drawable.kong);
							latLngF = new LatLng(39.532128, 116.7442);
							markerOptions = new MarkerOptions()
									.position(latLngF).icon(bitmapDescriptor)
									.animateType(MarkerAnimateType.grow)
									.title("17");
							markerF = (Marker) baiduMap
									.addOverlay(markerOptions);

						}

					}

					@Override
					public void onError(int arg0, String arg1) {
						// TODO Auto-generated method stub
						Toast.makeText(getActivity(), "服务器请求失败, 请检查网络连接!", 3000)
								.show();
					}
				});
	}

	// 初始化定位功能
	private void initLocationView() {
		// TODO Auto-generated method stub
		client = new LocationClient(getActivity());
		// 定位监听器
		client.registerLocationListener(bdLocationListener);
		// 开启定位图层
		baiduMap.setMyLocationEnabled(true);
		clientOption = new LocationClientOption();
		clientOption.setOpenGps(true);// 打开gps
		clientOption.setCoorType("bd09ll"); // 设置坐标类型bd09ll
		clientOption.setScanSpan(1000);
		client.setLocOption(clientOption);
		baiduMap.setMyLocationConfigeration(new MyLocationConfiguration(
				com.baidu.mapapi.map.MyLocationConfiguration.LocationMode.NORMAL,
				true, null));
		client.start();
		Log.i("main", "初始化执行了");

	}

	private void mapStatueInit() {
		LatLng cenpt = new LatLng(39.533004, 116.746697);
		// 定义地图状态
		MapStatus mMapStatus = new MapStatus.Builder().target(cenpt).zoom(18)
				.build();
		// 定义MapStatusUpdate对象，以便描述地图状态将要发生的变化

		MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory
				.newMapStatus(mMapStatus);
		// 改变地图状态
		baiduMap.setMapStatus(mMapStatusUpdate);
	}

	// 定位
	class myBdLocationListener implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			// map view 销毁后不在处理新接收的位置
			if (location == null || mapView == null) {
				return;
			}

			MyLocationData locData = new MyLocationData.Builder()
					.accuracy(location.getRadius())
					// 此处设置开发者获取到的方向信息，顺时针0-360
					.direction(location.getDirection())
					.latitude(location.getLatitude())
					.longitude(location.getLongitude()).build();
			baiduMap.setMyLocationData(locData);

			if (isFirstLoc) {
				isFirstLoc = false;
				LatLng ll = new LatLng(39.533323, 116.74649);
				MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
				baiduMap.animateMapStatus(u);
			}

		}

		public void onReceivePoi(BDLocation poiLocation) {
		}

	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (mapView != null)
			mapView.onResume();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if (mapView != null)
			mapView.onPause();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (mapView != null)
			mapView.onDestroy();
		if (bitmapDescriptor != null)
			bitmapDescriptor.recycle();

	}

}
