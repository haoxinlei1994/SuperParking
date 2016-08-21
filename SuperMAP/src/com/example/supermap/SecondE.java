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

public class SecondE extends Activity implements OnClickListener{
	Button E01, E02, E03, E04, E05, E06, E07, E08, E09, E10, E11, E12, E13,
			E14, E15, E16, E17, E18;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.e);
		initView();

		initQuery();
		
		setListener();
	}
	private void setListener() {
		E01.setOnClickListener(this);
		E02.setOnClickListener(this);
		E03.setOnClickListener(this);
		E04.setOnClickListener(this);
		E05.setOnClickListener(this);
		E06.setOnClickListener(this);
		E07.setOnClickListener(this);
		E08.setOnClickListener(this);
		E09.setOnClickListener(this);
		E10.setOnClickListener(this);
		E11.setOnClickListener(this);
		E12.setOnClickListener(this);
		E13.setOnClickListener(this);
		E14.setOnClickListener(this);
		E15.setOnClickListener(this);
		E16.setOnClickListener(this);
		E17.setOnClickListener(this);
		E18.setOnClickListener(this);
	}
	private void initView() {
		E01 = (Button) findViewById(R.id.E01);
		E02 = (Button) findViewById(R.id.E02);
		E03 = (Button) findViewById(R.id.E03);
		E04 = (Button) findViewById(R.id.E04);
		E05 = (Button) findViewById(R.id.E05);
		E06 = (Button) findViewById(R.id.E06);
		E07 = (Button) findViewById(R.id.E07);
		
		E08 = (Button) findViewById(R.id.E08);
		E09 = (Button) findViewById(R.id.E09);
		E10 = (Button) findViewById(R.id.E10);
		E11 = (Button) findViewById(R.id.E11);
		E12 = (Button) findViewById(R.id.E12);
		E13 = (Button) findViewById(R.id.E13);
		E14 = (Button) findViewById(R.id.E14);
		
		E15 = (Button) findViewById(R.id.E15);
		E16 = (Button) findViewById(R.id.E16);
		E17 = (Button) findViewById(R.id.E17);
		E18 = (Button) findViewById(R.id.E18);

	
	}
	
	private void initQuery() {
		BmobQuery<Bean> bmobQuery = new BmobQuery<Bean>();
		bmobQuery.findObjects(SecondE.this, new FindListener<Bean>() {
			
			@Override
			public void onSuccess(List<Bean> arg0) {
				for(int i=0;i<arg0.size();i++){
					if(arg0.get(i).getPartNum().toString().equals("E01")){
						E01.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E02")){
						E02.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E03")){
						E03.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E04")){
						E04.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E05")){
						E05.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E06")){
						E06.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E07")){
						E07.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E08")){
						E08.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E09")){
						E09.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E10")){
						E10.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E11")){
						E11.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E12")){
						E12.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E13")){
						E13.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E14")){
						E14.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E15")){
						E15.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E16")){
						E16.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E17")){
						E17.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("E18")){
						E18.setText("有车");
						
					}
				
					
					
				}
		
			}
			
			@Override
			public void onError(int arg0, String arg1) {
				Toast.makeText(SecondE.this, "请求服务器失败", 3000).show();
			}
		});
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.E01:
			if (!E01.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E01",E01);				
			}
			break;
		case R.id.E02:
			if (!E02.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E02",E02);
			}
			break;
		case R.id.E03:
			if (!E03.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E03",E03);
			}
			break;
		case R.id.E04:
			if (!E04.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E04",E04);
			}
			break;
		case R.id.E05:
			if (!E05.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E05",E05);
			}
			break;
		case R.id.E06:
			if (!E06.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E06",E06);
			}
			break;
		case R.id.E07:
			if (!E07.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E07",E07);
			}
			break;
		case R.id.E08:
			if (!E08.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E08",E08);
			}
			break;
		case R.id.E09:
			if (!E09.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E09",E09);
			}
			break;
		case R.id.E10:
			if (!E10.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E10",E10);
			}
			break;
		case R.id.E11:
			if (!E11.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E11",E11);
			}
			break;
		case R.id.E12:
			if (!E12.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E12",E12);
			}
			break;
		case R.id.E13:
			if (!E13.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E13",E13);
			}
			break;
		case R.id.E14:
			if (!E14.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E14",E14);
			}
			break;
		case R.id.E15:
			if (!E15.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E15",E15);
			}
			break;
		case R.id.E16:
			if (!E16.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E16",E16);
			}
			break;
		case R.id.E17:
			if (!E17.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E17",E17);
			}
			break;
		case R.id.E18:
			if (!E18.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("E18",E18);
			}
			break;
		}
	}

		private void showDialogue(final String str,final Button btn) {

			AlertDialog alertDialog;
			AlertDialog.Builder builder = new Builder(SecondE.this);
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
											// TODO Auto-generated method stub

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
