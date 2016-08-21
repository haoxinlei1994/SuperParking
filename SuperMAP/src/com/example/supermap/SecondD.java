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

public class SecondD extends Activity implements OnClickListener{
	Button D01, D02, D03, D04, D05, D06, D07, D08, D09, D10, D11, D12, D13,
			D14, D15, D16, D17, D18, D19, D20;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.d);
		initView();

		initQuery();
		
		setListener();
	}
	
	private void setListener() {
		D01.setOnClickListener(this);
		D02.setOnClickListener(this);
		D03.setOnClickListener(this);
		D04.setOnClickListener(this);
		D05.setOnClickListener(this);
		D06.setOnClickListener(this);
		D07.setOnClickListener(this);
		D08.setOnClickListener(this);
		D09.setOnClickListener(this);
		D10.setOnClickListener(this);
		D11.setOnClickListener(this);
		D12.setOnClickListener(this);
		D13.setOnClickListener(this);
		D14.setOnClickListener(this);
		D15.setOnClickListener(this);
		D16.setOnClickListener(this);
		D17.setOnClickListener(this);
		D18.setOnClickListener(this);
		D19.setOnClickListener(this);
		D20.setOnClickListener(this);
	}

	private void initQuery() {
		BmobQuery<Bean> bmobQuery = new BmobQuery<Bean>();
		bmobQuery.findObjects(SecondD.this, new FindListener<Bean>() {
			
			@Override
			public void onSuccess(List<Bean> arg0) {
				for(int i=0;i<arg0.size();i++){
					if(arg0.get(i).getPartNum().toString().equals("D01")){
						D01.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D02")){
						D02.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D03")){
						D03.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D04")){
						D04.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D05")){
						D05.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D06")){
						D06.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D07")){
						D07.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D08")){
						D08.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D09")){
						D09.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D10")){
						D10.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D11")){
						D11.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D12")){
						D12.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D13")){
						D13.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D14")){
						D14.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D15")){
						D15.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D16")){
						D16.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D17")){
						D17.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D18")){
						D18.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D19")){
						D19.setText("有车");
						
					}
					if(arg0.get(i).getPartNum().toString().equals("D20")){
						D20.setText("有车");
						
					}
				
					
				}
			
			}
			
			@Override
			public void onError(int arg0, String arg1) {
				Toast.makeText(SecondD.this, "请求服务器失败", 3000).show();
			}
		});
}
     private void initView() {
		D01 = (Button) findViewById(R.id.D01);
		D02 = (Button) findViewById(R.id.D02);
		D03 = (Button) findViewById(R.id.D03);
		D04 = (Button) findViewById(R.id.D04);
		D05 = (Button) findViewById(R.id.D05);
		D06 = (Button) findViewById(R.id.D06);
		D07 = (Button) findViewById(R.id.D07);
		D08 = (Button) findViewById(R.id.D08);
		
		D09 = (Button) findViewById(R.id.D09);
		D10 = (Button) findViewById(R.id.D10);
		D11= (Button) findViewById(R.id.D11);
		D12 = (Button) findViewById(R.id.D12);
		D13 = (Button) findViewById(R.id.D13);
		D14 = (Button) findViewById(R.id.D14);
		D15 = (Button) findViewById(R.id.D15);
		D16 = (Button) findViewById(R.id.D16);
		
		D17 = (Button) findViewById(R.id.D17);
		D18 = (Button) findViewById(R.id.D18);
		D19 = (Button) findViewById(R.id.D19);
		D20 = (Button) findViewById(R.id.D20);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.D01:
			if (!D01.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D01",D01);				
			}
			break;
		case R.id.D02:
			if (!D02.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D02",D02);
			}
			break;
		case R.id.D03:
			if (!D03.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D03",D03);
			}
			break;
		case R.id.D04:
			if (!D04.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D04",D04);
			}
			break;
		case R.id.D05:
			if (!D05.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D05",D05);
			}
			break;
		case R.id.D06:
			if (!D06.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D06",D06);
			}
			break;
		case R.id.D07:
			if (!D07.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D07",D07);
			}
			break;
		case R.id.D08:
			if (!D08.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D08",D08);
			}
			break;
		case R.id.D09:
			if (!D09.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D09",D09);
			}
			break;
		case R.id.D10:
			if (!D10.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D10",D10);
			}
			break;
		case R.id.D11:
			if (!D11.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D11",D11);
			}
			break;
		case R.id.D12:
			if (!D12.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D12",D12);
			}
			break;
		case R.id.D13:
			if (!D13.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D13",D13);
			}
			break;
		case R.id.D14:
			if (!D14.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D14",D14);
			}
			break;
		case R.id.D15:
			if (!D15.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D15",D15);
			}
			break;
		case R.id.D16:
			if (!D16.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D16",D16);
			}
			break;
		case R.id.D17:
			if (!D17.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D17",D17);
			}
			break;
		case R.id.D18:
			if (!D18.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D18",D18);
			}
			break;
		case R.id.D19:
			if (!D19.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D19",D19);
			}
			break;
		case R.id.D20:
			if (!D20.getText().toString().equals("有车")&&SecondA.flag==0) {
				showDialogue("D20",D20);
			}
			break;
		default:
			break;
		}
	}
	private void showDialogue(final String str,final Button btn) {

		AlertDialog alertDialog;
		AlertDialog.Builder builder = new Builder(SecondD.this);
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
