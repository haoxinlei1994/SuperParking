package com.example.supermap;

import java.util.List;

import com.example.Bmob.Bean;
import com.example.Bmob.Bean_copy;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondA extends Activity implements OnClickListener {

	Button A01, A02, A03, A04, A05, A06, A07, A08, A09, A10, A11, A12, A13,
			A14, A15, A16, A17, A18;

	public static int flag = 0;  //0代表没有预定过车位    1：已经预定过车位了不能再预定了
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a);
		initView();

		initQuery();

		setListsner();
	}

	private void setListsner() {
		A01.setOnClickListener(this);
		A02.setOnClickListener(this);
		A03.setOnClickListener(this);
		A04.setOnClickListener(this);
		A05.setOnClickListener(this);
		A06.setOnClickListener(this);
		A07.setOnClickListener(this);
		A08.setOnClickListener(this);
		A09.setOnClickListener(this);
		A10.setOnClickListener(this);
		A11.setOnClickListener(this);
		A12.setOnClickListener(this);
		A13.setOnClickListener(this);
		A14.setOnClickListener(this);
		A15.setOnClickListener(this);
		A16.setOnClickListener(this);
		A17.setOnClickListener(this);
		A18.setOnClickListener(this);
	}

	private void initQuery() {
		BmobQuery<Bean> bmobQuery = new BmobQuery<Bean>();
		bmobQuery.findObjects(SecondA.this, new FindListener<Bean>() {

			@Override
			public void onSuccess(List<Bean> arg0) {
				for (int i = 0; i < arg0.size(); i++) {
					if (arg0.get(i).getPartNum().toString().equals("A01")) {
						A01.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A02")) {
						A02.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A03")) {
						A03.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A04")) {
						A04.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A05")) {
						A05.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A06")) {
						A06.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A07")) {
						A07.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A08")) {
						A08.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A09")) {
						A09.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A10")) {
						A10.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A11")) {
						A11.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A12")) {
						A12.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A13")) {
						A13.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A14")) {
						A14.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A15")) {
						A15.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A16")) {
						A16.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A17")) {
						A17.setText("有车");
					}
					if (arg0.get(i).getPartNum().toString().equals("A18")) {
						A18.setText("有车");
					}
				}

			}

			@Override
			public void onError(int arg0, String arg1) {
				Toast.makeText(SecondA.this, "请求服务器失败", 3000).show();
			}
		});

	}

	private void initView() {
		A01 = (Button) findViewById(R.id.A01);
		A02 = (Button) findViewById(R.id.A02);
		A03 = (Button) findViewById(R.id.A03);
		A04 = (Button) findViewById(R.id.A04);
		A05 = (Button) findViewById(R.id.A05);
		A06 = (Button) findViewById(R.id.A06);
		A07 = (Button) findViewById(R.id.A07);
		A08 = (Button) findViewById(R.id.A08);
		A09 = (Button) findViewById(R.id.A09);
		A10 = (Button) findViewById(R.id.A10);
		A11 = (Button) findViewById(R.id.A11);
		A12 = (Button) findViewById(R.id.A12);
		A13 = (Button) findViewById(R.id.A13);
		A14 = (Button) findViewById(R.id.A14);
		A15 = (Button) findViewById(R.id.A15);
		A16 = (Button) findViewById(R.id.A16);
		A17 = (Button) findViewById(R.id.A17);
		A18 = (Button) findViewById(R.id.A18);
	}

	@SuppressLint("ShowToast")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.A01:
			if (!A01.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A01",A01);				
			}
			break;
		case R.id.A02:
			if (!A02.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A02",A02);
			}
			break;
		case R.id.A03:
			if (!A03.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A03",A03);
			}
			break;
		case R.id.A04:
			if (!A04.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A04",A04);
			}
			break;
		case R.id.A05:
			if (!A05.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A05",A05);
			}
			break;
		case R.id.A06:
			if (!A06.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A06",A06);
			}
			break;
		case R.id.A07:
			if (!A07.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A07",A07);
			}
			break;
		case R.id.A08:
			if (!A08.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A08",A08);
			}
			break;
		case R.id.A09:
			if (!A09.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A09",A09);
			}
			break;
		case R.id.A10:
			if (!A10.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A10",A10);
			}
			break;
		case R.id.A11:
			if (!A11.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A11",A11);
			}
			break;
		case R.id.A12:
			if (!A12.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A12",A12);
			}
			break;
		case R.id.A13:
			if (!A13.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A13",A13);
			}
			break;
		case R.id.A14:
			if (!A14.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A14",A14);
			}
			break;
		case R.id.A15:
			if (!A15.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A15",A15);
			}
			break;
		case R.id.A16:
			if (!A16.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A16",A16);
			}
			break;
		case R.id.A17:
			if (!A17.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A17",A17);
			}
			break;
		case R.id.A18:
			if (!A03.getText().toString().equals("有车")&&flag==0) {
				showDialogue("A18",A18);
			}
			break;
		default:
			break;
		}
	}

	private void showDialogue(final String str,final Button btn) {

		AlertDialog alertDialog;
		AlertDialog.Builder builder = new Builder(SecondA.this);
		builder.setMessage("是否提前预定车位？预定三十分钟后自动失效。")
				.setPositiveButton("是", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (checkLogin()) {// 如果已经登陆
							yuDing(str);
							btn.setText("有车");
							flag=1;
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
