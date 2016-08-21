package com.example.Bmob;

import cn.bmob.v3.BmobObject;

public class Bean_copy extends BmobObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String partNum;
	int hour,minute,second;
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public String getPartNum() {
		return partNum;
	}

	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}
}
