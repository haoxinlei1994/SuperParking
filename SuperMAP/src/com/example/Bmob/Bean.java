package com.example.Bmob;

import android.content.Context;
import android.view.View.OnClickListener;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;

public class Bean extends BmobObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String partNum;

	public String getPartNum() {
		return partNum;
	}

	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}
	
}
