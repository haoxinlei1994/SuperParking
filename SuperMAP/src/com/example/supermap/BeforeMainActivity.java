package com.example.supermap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

@SuppressLint("HandlerLeak") public class BeforeMainActivity extends Activity {

	
	
	class MyHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			Intent intent = new Intent(BeforeMainActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
		}
	}
	

	MyHandler handler  =  new MyHandler();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_before_main);
		
		 //该线程用于实现页面的条跳转
        new Thread(){
        	@Override
        	public void run() {
        		try {
					sleep(3000);
					Message msg = new Message();
					
					handler.sendMessage(msg);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }.start();

		
	}
}
