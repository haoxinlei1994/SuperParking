package com.example.Fragment;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;

import com.example.Bmob.Bean;
import com.example.Bmob.Bean_copy;
import com.example.supermap.LoginActivity;
import com.example.supermap.R;
import com.example.supermap.SecondA;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetailFragment extends Fragment {

	TextView tv_yuding, tv_yuding_write, tv_address, tv_address_write, tv_time,
			tv_time_write, tv_time_end, tv_time_end_write;
	Button btnCancle;
	ImageView iv_cry;
	TextView tv_cry;
	RelativeLayout content_lay;
	
	String id,partName;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.detail_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// 初始化控件
		initView();
		// 改变界面的文字和图标
		switchText();
		// 设置监听器 取消
		setListener();
	}

	private void setListener() {
		btnCancle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog alertDialog;
				AlertDialog.Builder builder = new Builder(getActivity());
				builder.setMessage("是否取消该预定的车位？").setPositiveButton("是", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						//删除Bean_Copy表中的一条数据
						Bean_copy bean_copy = new Bean_copy();
						bean_copy.setObjectId(id);
						bean_copy.delete(getActivity());
						//删除Bean表中的数据
						BmobQuery<Bean> bmobQuery = new BmobQuery<Bean>();
						bmobQuery.findObjects(getActivity(), new FindListener<Bean>() {
							
							@Override
							public void onSuccess(List<Bean> arg0) {
								for (Bean bean : arg0) {
									if(bean.getPartNum().toString().equals(partName)){
										bean.delete(getActivity());
										break;
									}
								}
								Toast.makeText(getActivity(), "取消预定成功", Toast.LENGTH_SHORT).show();
								switchText();
								SecondA.flag=0;
							}
							
							@Override
							public void onError(int arg0, String arg1) {
								// TODO Auto-generated method stub
								Toast.makeText(getActivity(), "删除失败", Toast.LENGTH_SHORT).show();
							}
						});
					}
				}).setNegativeButton("否", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
				alertDialog = builder.create();
				alertDialog.show();
			}
		});
	}

	private void switchText() {
		if (checkLogin()) {// 如果已经登陆了
			BmobQuery<Bean_copy> bmobQuery = new BmobQuery<Bean_copy>();
			bmobQuery.findObjects(getActivity(), new FindListener<Bean_copy>() {

				@Override
				public void onSuccess(List<Bean_copy> arg0) {
					if (arg0.size() == 0) {// 还没有预定的车位
						content_lay.setVisibility(View.GONE);
						iv_cry.setVisibility(View.VISIBLE);
						tv_cry.setVisibility(View.VISIBLE);
					} else {// 有预定的车位了，下边进行显示
						content_lay.setVisibility(View.VISIBLE);
						iv_cry.setVisibility(View.GONE);
						tv_cry.setVisibility(View.GONE);
						showPartDetail();
					}
				}

				@Override
				public void onError(int arg0, String arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT);
				}
			});
		} else {// 如果没有登陆
			Intent intent = new Intent(getActivity(), LoginActivity.class);
			startActivityForResult(intent, 1);
		}
	}

	private void showPartDetail() {
		BmobQuery<Bean_copy> bmobQuery = new BmobQuery<Bean_copy>();
		bmobQuery.findObjects(getActivity(), new FindListener<Bean_copy>() {

			@Override
			public void onSuccess(List<Bean_copy> arg0) {
				for (Bean_copy bean_copy : arg0) {
					String partNum, address, time, endTime;
					id = bean_copy.getObjectId();	
					partNum = bean_copy.getPartNum();
					partName = partNum;
					address = getAddressByPartNum(partNum);
					time = bean_copy.getHour() + ":" + bean_copy.getMinute()
							+ ":" + bean_copy.getSecond();
					endTime = getEdnTime(bean_copy.getHour(),
							bean_copy.getMinute(), bean_copy.getSecond());
					tv_yuding_write.setText(partNum);
					tv_address_write.setText(address);
					tv_time_write.setText(time);
					tv_time_end_write.setText(endTime);
				}
			}

			@Override
			public void onError(int arg0, String arg1) {

			}
		});
	}

	protected String getEdnTime(int hour, int minute, int second) {
		int h, m, s;
		if (minute + 30 > 60) {
			h = hour + 1;
			if (h == 25)
				h = 1;
			m = minute + 30 - 60;
			s = second;
			return h + ":" + m + ":" + s;
		}
		if (minute + 30 == 60) {
			h = hour + 1;
			if (h == 25)
				h = 1;
			m = 0;
			s = second;
			return h + ":" + m + ":" + s;
		}
		if (minute + 30 < 60 && minute + 60 > 0) {
			h = hour;
			m = minute+30;
			s = second;
			return h + ":" + m + ":" + s;

		}
		return null;
	}

	public String getAddressByPartNum(String partNum) {
		if (partNum.charAt(0) == 'A') {
			return "篮球场后小路";
		}
		if (partNum.charAt(0) == 'B') {
			return "学识路";
		}
		if (partNum.charAt(0) == 'D') {
			return "教八楼右侧";
		}
		if (partNum.charAt(0) == 'E') {
			return "教八楼后侧";
		}
		if (partNum.charAt(0) == 'F') {
			return "教八楼左侧";
		}
		return null;
	}

	private void initView() {
		tv_yuding = (TextView) getActivity().findViewById(R.id.tv_yuding);
		tv_yuding_write = (TextView) getActivity().findViewById(
				R.id.tv_yuding_write);
		tv_address = (TextView) getActivity().findViewById(R.id.tv_address);
		tv_address_write = (TextView) getActivity().findViewById(
				R.id.tv_adress_write);
		tv_time = (TextView) getActivity().findViewById(R.id.tv_time);
		tv_time_write = (TextView) getActivity().findViewById(
				R.id.tv_time_write);
		tv_time_end = (TextView) getActivity().findViewById(R.id.tv_time_end);
		tv_time_end_write = (TextView) getActivity().findViewById(
				R.id.tv_time_end_write);
		iv_cry = (ImageView) getActivity().findViewById(R.id.iv_cry);
		tv_cry = (TextView) getActivity().findViewById(R.id.tv_cry);

		content_lay = (RelativeLayout) getActivity().findViewById(
				R.id.contentLay);
		btnCancle = (Button) getActivity().findViewById(R.id.cancle_yuding);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
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

}
