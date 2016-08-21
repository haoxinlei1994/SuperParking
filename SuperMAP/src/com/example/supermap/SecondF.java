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
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import com.example.Bmob.Bean;
import com.example.Bmob.Bean_copy;

public class SecondF extends Activity implements OnClickListener{
	Button F01, F02, F03, F04, F05, F06, F07, F08, F09, F10, F11, F12, F13,
			F14, F15, F16, F17, F18;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.f);

		initView();

		initQuery();
		
		setListener();
	}

	private void setListener() {
		F01.setOnClickListener(this);
		F02.setOnClickListener(this);
		F03.setOnClickListener(this);
		F04.setOnClickListener(this);
		F05.setOnClickListener(this);
		F06.setOnClickListener(this);
		F07.setOnClickListener(this);
		F08.setOnClickListener(this);
		F09.setOnClickListener(this);
		F10.setOnClickListener(this);
		F11.setOnClickListener(this);
		F12.setOnClickListener(this);
		F13.setOnClickListener(this);
		F14.setOnClickListener(this);
		F15.setOnClickListener(this);
		F16.setOnClickListener(this);
		F17.setOnClickListener(this);
		F18.setOnClickListener(this);
	}

	private void initQuery() {
		BmobQuery<Bean> bmobQuery = new BmobQuery<Bean>();
		bmobQuery.findObjects(SecondF.this, new FindListener<Bean>() {
			
			@Override
			public void onSuccess(List<Bean> arg0) {
				for(int i=0;i<arg0.size();i++){
					if(arg0.get(i).getPartNum().toString().equals("F01")){
						F01.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F02")){
						F02.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F03")){
						F03.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F04")){
						F04.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F05")){
						F05.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F06")){
						F06.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F07")){
						F07.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F08")){
						F08.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F09")){
						F09.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F10")){
						F10.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F11")){
						F11.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F12")){
						F12.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F13")){
						F13.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F14")){
						F14.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F15")){
						F15.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F16")){
						F16.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F17")){
						F17.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("F18")){
						F18.setText("有车");
						
					}
					
					
					
				}
			
			}
			
			@Override
			public void onError(int arg0, String arg1) {
				Toast.makeText(SecondF.this, "请求服务器失败", 3000).show();
			}
		});
	}

	private void initView() {
		F01 = (Button) findViewById(R.id.F01);
		F02 = (Button) findViewById(R.id.F02);
		F03 = (Button) findViewById(R.id.F03);
		F04 = (Button) findViewById(R.id.F04);
		F05 = (Button) findViewById(R.id.F05);
		F06 = (Button) findViewById(R.id.F06);
		F07 = (Button) findViewById(R.id.F07);

		F08 = (Button) findViewById(R.id.F08);
		F09 = (Button) findViewById(R.id.F09);
		F10 = (Button) findViewById(R.id.F10);
		F11 = (Button) findViewById(R.id.F11);
		F12 = (Button) findViewById(R.id.F12);
		F13 = (Button) findViewById(R.id.F13);
		F14 = (Button) findViewById(R.id.F14);

		F15 = (Button) findViewById(R.id.F15);
		F16 = (Button) findViewById(R.id.F16);
		F17 = (Button) findViewById(R.id.F17);
		F18 = (Button) findViewById(R.id.F18);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.F01:
			if (!F01.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F01",F01);				
			}
			break;
		case R.id.F02:
			if (!F02.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F02",F02);
			}
			break;
		case R.id.F03:
			if (!F03.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F03",F03);
			}
			break;
		case R.id.F04:
			if (!F04.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F04",F04);
			}
			break;
		case R.id.F05:
			if (!F05.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F05",F05);
			}
			break;
		case R.id.F06:
			if (!F06.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F06",F06);
			}
			break;
		case R.id.F07:
			if (!F07.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F07",F07);
			}
			break;
		case R.id.F08:
			if (!F08.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F08",F08);
			}
			break;
		case R.id.F09:
			if (!F09.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F09",F09);
			}
			break;
		case R.id.F10:
			if (!F10.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F10",F10);
			}
			break;
		case R.id.F11:
			if (!F11.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F11",F11);
			}
			break;
		case R.id.F12:
			if (!F12.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F12",F12);
			}
			break;
		case R.id.F13:
			if (!F13.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F13",F13);
			}
			break;
		case R.id.F14:
			if (!F14.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F14",F14);
			}
			break;
		case R.id.F15:
			if (!F15.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F15",F15);
			}
			break;
		case R.id.F16:
			if (!F16.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F16",F16);
			}
			break;
		case R.id.F17:
			if (!F17.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F17",F17);
			}
			break;
		case R.id.F18:
			if (!F03.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("F18",F18);
			}
			break;
		default:
			break;
			}
	}
	
	private void showDialogue(final String str,final Button btn) {

		AlertDialog alertDialog;
		AlertDialog.Builder builder = new Builder(SecondF.this);
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
