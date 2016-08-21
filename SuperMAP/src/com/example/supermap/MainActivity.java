package com.example.supermap;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

import com.baidu.mapapi.SDKInitializer;
import com.example.Fragment.FragmentManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext());
		setContentView(R.layout.activity_main);

		// 自动登录
		final BmobUser bmobUser = BmobUser.getCurrentUser(MainActivity.this);
		if (bmobUser != null && bmobUser.getUsername() != null) {

			// 获取密码
			SharedPreferences preferences = getSharedPreferences("haoxinlei",
					MODE_PRIVATE);
			String password = preferences.getString("password", "");
			if (password != null) {
				bmobUser.setPassword(password);
				bmobUser.login(MainActivity.this, new SaveListener() {

					@Override
					public void onSuccess() {
						Log.i("main", "自动登录成功");
					}

					@Override
					public void onFailure(int arg0, String arg1) {
						Log.i("main", "自动登录失败:"
								+ bmobUser.getUsername().toString());
					}
				});
			}
		}

		FragmentManager fragmentManager = new FragmentManager();
		getFragmentManager().beginTransaction()
				.replace(R.id.id_contenet, fragmentManager).commit();

	}

}
