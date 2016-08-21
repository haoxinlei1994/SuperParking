package com.example.supermap;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import com.example.Bmob.Bean;
import com.example.Bmob.Bean_copy;

public class SecondB extends Activity implements OnClickListener{

	Button B01, B02, B03, B04, B05, B06, B07, B08, B09, B10, B11, B12, B13,
			B14, B15, B16, B17, B18;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.b);
		initView();
		initQuery();
		setListsner();
	}

	private void setListsner() {
		B01.setOnClickListener(this);
		B02.setOnClickListener(this);
		B03.setOnClickListener(this);
		B04.setOnClickListener(this);
		B05.setOnClickListener(this);
		B06.setOnClickListener(this);
		B07.setOnClickListener(this);
		B08.setOnClickListener(this);
		B09.setOnClickListener(this);
		B10.setOnClickListener(this);
		B11.setOnClickListener(this);
		B12.setOnClickListener(this);
		B13.setOnClickListener(this);
		B14.setOnClickListener(this);
		B15.setOnClickListener(this);
		B16.setOnClickListener(this);
		B17.setOnClickListener(this);
		B18.setOnClickListener(this);
		
	}

	private void initQuery() {
		BmobQuery<Bean> bmobQuery = new BmobQuery<Bean>();
		bmobQuery.findObjects(SecondB.this, new FindListener<Bean>() {

			@Override
			public void onSuccess(List<Bean> arg0) {
				for (int i = 0; i < arg0.size(); i++) {
					if (arg0.get(i).getPartNum().toString().equals("B01")) {
						B01.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B02")) {
						B02.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B03")) {
						B03.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B04")) {
						B04.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B05")) {
						B05.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B06")) {
						B06.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B07")) {
						B07.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B08")) {
						B08.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B09")) {
						B09.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B10")) {
						B10.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B11")) {
						B11.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B12")) {
						B12.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B13")) {
						B13.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B14")) {
						B14.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B15")) {
						B15.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B16")) {
						B16.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B17")) {
						B17.setText("有车");

					}
					if (arg0.get(i).getPartNum().toString().equals("B18")) {
						B18.setText("有车");

					}
				}

			}

			@Override
			public void onError(int arg0, String arg1) {
				Toast.makeText(SecondB.this, "请求服务器失败", 3000).show();
			}
		});
	}

	private void initView() {

		B01 = (Button) findViewById(R.id.B01);
		B02 = (Button) findViewById(R.id.B02);
		B03 = (Button) findViewById(R.id.B03);
		B04 = (Button) findViewById(R.id.B04);
		B05 = (Button) findViewById(R.id.B05);
		B06 = (Button) findViewById(R.id.B06);
		B07 = (Button) findViewById(R.id.B07);
		B08 = (Button) findViewById(R.id.B08);
		B09 = (Button) findViewById(R.id.B09);
		B10 = (Button) findViewById(R.id.B10);
		B11 = (Button) findViewById(R.id.B11);
		B12 = (Button) findViewById(R.id.B12);
		B13 = (Button) findViewById(R.id.B13);
		B14 = (Button) findViewById(R.id.B14);
		B15 = (Button) findViewById(R.id.B15);
		B16 = (Button) findViewById(R.id.B16);
		B17 = (Button) findViewById(R.id.B17);
		B18 = (Button) findViewById(R.id.B18);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.B01:
			if (!B01.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B01",B01);				
			}
			break;
		case R.id.B02:
			if (!B02.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B02",B02);
			}
			break;
		case R.id.B03:
			if (!B03.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B03",B03);
			}
			break;
		case R.id.B04:
			if (!B04.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B04",B04);
			}
			break;
		case R.id.B05:
			if (!B05.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B05",B05);
			}
			break;
		case R.id.B06:
			if (!B06.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B06",B06);
			}
			break;
		case R.id.B07:
			if (!B07.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B07",B07);
			}
			break;
		case R.id.B08:
			if (!B08.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B08",B08);
			}
			break;
		case R.id.B09:
			if (!B09.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B09",B09);
			}
			break;
		case R.id.B10:
			if (!B10.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B10",B10);
			}
			break;
		case R.id.B11:
			if (!B11.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B11",B11);
			}
			break;
		case R.id.B12:
			if (!B12.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B12",B12);
			}
			break;
		case R.id.B13:
			if (!B13.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B13",B13);
			}
			break;
		case R.id.B14:
			if (!B14.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B14",B14);
			}
			break;
		case R.id.B15:
			if (!B15.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B15",B15);
			}
			break;
		case R.id.B16:
			if (!B16.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B16",B16);
			}
			break;
		case R.id.B17:
			if (!B17.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B17",B17);
			}
			break;
		case R.id.B18:
			if (!B03.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("B18",B18);
			}
			break;
		default:
			break;
		}
	}
	
	private void showDialogue(final String str,final Button btn) {

		AlertDialog alertDialog;
		AlertDialog.Builder builder = new Builder(SecondB.this);
		builder.setMessage("是否提前预定车位？预定三十分钟后自动失效。")
				.setPositiveButton("是", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (checkLogin()) {// 如果已经登陆
							yuDing(str);
							btn.setText("有车");
							SecondA.flag=1;
						} else {
							Intent intent = new Intent(getApplicationContext(),
									LoginActivity.class);
							startActivity(intent);
						}
					}
				})
				.setNegativeButton("否", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
		alertDialog = builder.create();
		alertDialog.show();
	}

	// 检查是否登陆
	private boolean checkLogin() {
		BmobUser bmobUser = new BmobUser();
		if (BmobUser.getCurrentUser(getApplicationContext()) == null
				|| BmobUser.getCurrentUser(getApplicationContext())
						.getUsername() == null) {
			return false;
		}
		return true;
	}

	public void yuDing(final String str) {

		Bean beanAdd = new Bean();
		beanAdd.setPartNum(str);
		beanAdd.save(getApplicationContext());

		Bean_copy bean_copy = new Bean_copy();
		bean_copy.setPartNum(str);

		Time time = new Time();
		time.setToNow();
		bean_copy.setHour(time.hour);
		bean_copy.setMinute(time.minute);
		bean_copy.setSecond(time.second);
		bean_copy.save(getApplicationContext(), new SaveListener() {
			@Override
			public void onSuccess() {
				Toast.makeText(getApplicationContext(), "预订成功", 2000).show();
				new Thread(new Runnable() {

					@Override
					public void run() {
						for (int i = 0; i < 1800; i++) {
							try {
								Thread.sleep(1000);
								Log.i("main", "时间：：：：：" + i);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
						BmobQuery<Bean> query = new BmobQuery<Bean>();
						query.findObjects(getApplicationContext(),
								new FindListener<Bean>() {

									@Override
									public void onSuccess(List<Bean> arg0) {
										for (Bean bean : arg0) {
											if (bean.getPartNum().toString()
													.equals(str)) {
												String id = bean.getObjectId();
												Bean bean2 = new Bean();
												bean2.setObjectId(id);
												bean2.delete(getApplicationContext());
											}
										}
									}

									@Override
									public void onError(int arg0, String arg1) {
										// TODO Auto-generated method stub

									}
								});

						BmobQuery<Bean_copy> bmobQuery = new BmobQuery<Bean_copy>();
						bmobQuery.findObjects(getApplicationContext(),
								new FindListener<Bean_copy>() {

									@Override
									public void onSuccess(List<Bean_copy> arg0) {
										// TODO Auto-generated method stub
										for (Bean_copy bean_copy2 : arg0) {
											String id = bean_copy2
													.getObjectId();
											Bean_copy deleteBean = new Bean_copy();
											deleteBean.setObjectId(id);
											deleteBean
													.delete(getApplicationContext());
											Log.i("main", id + "删除了");
										}
									}

									@Override
									public void onError(int arg0, String arg1) {
									}
								});

					}
				}).start();
			}

			@SuppressLint("ShowToast")
			@Override
			public void onFailure(int arg0, String arg1) {
				Toast.makeText(getApplicationContext(), "预订失败", 2000).show();

			}
		});

	}
}
