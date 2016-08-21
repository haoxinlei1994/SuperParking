package com.example.supermap;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.RequestSMSCodeListener;
import cn.bmob.v3.listener.SaveListener;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.arg1 == 60) {
				btncode.setClickable(false);
			}
			if (msg.arg1 == 1) {
				btncode.setClickable(true);
				btncode.setText("获取验证码");
			} else {
				btncode.setText("剩余时间：" + msg.arg1 + "s");
			}
		};
	};

	EditText et_tel, et_password, et_password_again;
	Button btnRegister;

	EditText code;
	Button btncode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		initView();
		setListener();
		btncode.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (et_tel.getText().toString().equals("")
						|| et_tel.getText().toString() == null) {
					Toast.makeText(getApplicationContext(), "请先输入电话号码",
							Toast.LENGTH_SHORT).show();
				} else {
					BmobSMS.requestSMSCode(getApplicationContext(), et_tel
							.getText().toString(), "验证码",
							new RequestSMSCodeListener() {

								@Override
								public void done(Integer arg0,
										BmobException arg1) {
									// TODO Auto-generated method stub
									Toast.makeText(
											RegisterActivity.this,
											"验证码已发送到"
													+ et_tel.getText()
															.toString(), 3000)
											.show();

									new Thread(new Runnable() {

										@Override
										public void run() {
											for (int i = 0; i < 60; i++) {
												try {
													Thread.sleep(1000);
													Message message = new Message();
													message.arg1 = 60 - i;
													handler.sendMessage(message);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch
													// block
													e.printStackTrace();
												}

											}
										}
									}).start();
								}
							});
				}
			}
		});
	}

	private void setListener() {
		btnRegister.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String tel, pwd, pwdAgain;
				tel = et_tel.getText().toString();
				pwd = et_password.getText().toString();
				pwdAgain = et_password_again.getText().toString();
				if (checkTelAndPwd()) {// 如果检查输入合法
					if (pwd.equals(pwdAgain)) {
						BmobUser bmobUser = new BmobUser();
						bmobUser.setUsername(tel);
						bmobUser.setPassword(pwd);
						bmobUser.setMobilePhoneNumber(tel);
						bmobUser.signOrLogin(getApplicationContext(), code
								.getText().toString(), new SaveListener() {

							@Override
							public void onSuccess() {
								// TODO Auto-generated method stub
								Toast.makeText(RegisterActivity.this,
										"恭喜您注册成功！", 3000).show();
								finish();
							}

							@Override
							public void onFailure(int arg0, String arg1) {
								// TODO Auto-generated method stub
								Toast.makeText(RegisterActivity.this, "注册失败",
										3000).show();
							}
						});
					} else {
						Toast.makeText(RegisterActivity.this, "确认密码不一致",
								Toast.LENGTH_SHORT).show();
						et_tel.setText("");
						et_password.setText("");
						et_password_again.setText("");
					}

				} else {
					// 如果检查输入不合法，需要清空输入栏的文字
					et_tel.setText("");
					et_password.setText("");
					et_password_again.setText("");
				}
			}
		});
	}

	/**
	 * 检查用户名是否合法
	 * 
	 * @return
	 */
	public boolean checkTelAndPwd() {
		String strTel = et_tel.getText().toString();
		String strPwd = et_password.getText().toString();
		String strPwdAgain = et_password_again.getText().toString();
		String strCode = code.getText().toString();
		if (strTel.equals("")) {
			Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT)
					.show();
			return false;
		}
		if (strPwdAgain.equals("")) {
			Toast.makeText(RegisterActivity.this, "请输入确认密码", Toast.LENGTH_SHORT)
					.show();
			return false;
		}
		if (strPwd.equals("")) {
			Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT)
					.show();
			return false;
		}
		if (strTel.length() != 11) {
			Toast.makeText(RegisterActivity.this, "电话号码必须是11位",
					Toast.LENGTH_SHORT).show();
			return false;
		}
		if (strPwd.length() > 10 || strPwd.length() < 6) {
			Toast.makeText(RegisterActivity.this, "密码必须是6-10位字符",
					Toast.LENGTH_SHORT).show();
			return false;
		}
		if (strPwdAgain.length() > 10 || strPwd.length() < 6) {
			Toast.makeText(RegisterActivity.this, "确认密码必须是6-10位字符",
					Toast.LENGTH_SHORT).show();
			return false;
		}
		for (int i = 0; i < strTel.length(); i++) {
			if (strTel.charAt(i) < '0' || strTel.charAt(i) > '9') {
				Toast.makeText(RegisterActivity.this, "电话号码含有非法字符",
						Toast.LENGTH_SHORT).show();
				return false;
			}
		}
		if (strCode.equals("") || strCode == null) {
			Toast.makeText(RegisterActivity.this, "请输入验证码", Toast.LENGTH_SHORT)
					.show();
			return false;
		}
		return true;
	}

	private void initView() {
		et_password = (EditText) findViewById(R.id.et_password);
		et_password_again = (EditText) findViewById(R.id.et_password_again);
		et_tel = (EditText) findViewById(R.id.et_tel);
		btnRegister = (Button) findViewById(R.id.btn_register);
		code = (EditText) findViewById(R.id.code);
		btncode = (Button) findViewById(R.id.btncode);
	}
}
