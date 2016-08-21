package com.example.common;

import com.example.supermap.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopBar extends RelativeLayout {
	// 定义显示的控件
	private Button leftButton, rightButton;
	private TextView tvTittle;

	// 左边Button的属性
	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;

	// 右边Button的属性
	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;

	// 中间Title的属性
	private String tittle;
	private float tittleTextSize;
	private int tittleTextColor;
	// 设置三个控件的格式 或者说是布局
	private LayoutParams leftParams, rightParams, tittleParams;

	// 定义接口
	private TopBarListener topBarListener;

	Context context;

	// 定义方法使用接口机制 该方法的主要目的是暴露给使用者 使用者通过重写topBarListener的方法 实现onClick的功能
	public void setOnLeftButtonClickListener(TopBarListener topBarListener) {
		this.topBarListener = topBarListener;
	}

	/**
	 * 在构造函数中完成控件的初始化 使用接口的回调机制实现点击事件 获取xml中的属性
	 * 
	 * @param context
	 * @param attrs
	 */
	@SuppressLint("NewApi")
	public TopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.TopBar);
		leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
		leftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
		leftText = ta.getString(R.styleable.TopBar_leftText);

		rightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
		rightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
		rightText = ta.getString(R.styleable.TopBar_rightText);

		tittle = ta.getString(R.styleable.TopBar_tittle);
		tittleTextColor = ta.getColor(R.styleable.TopBar_tittleTextColor, 0);
		tittleTextSize = ta.getDimension(R.styleable.TopBar_tittleTextSize, 0);

		ta.recycle();

		leftButton = new Button(context);
		rightButton = new Button(context);
		tvTittle = new TextView(context);

		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);
		leftButton.setText(leftText);

		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);
		rightButton.setText(rightText);

		tvTittle.setText(tittle);
		tvTittle.setTextColor(tittleTextColor);
		tvTittle.setTextSize(tittleTextSize);
		tvTittle.setGravity(Gravity.CENTER);

		setBackgroundColor(getResources().getColor(R.color.nav_bar_bg));

		// 设置左边Button的布局
		// 宽：WRAP_CONTENT 高：WRAP_CONTENT 布局：居左对齐
		leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
		leftParams.addRule(RelativeLayout.CENTER_VERTICAL);
		addView(leftButton, leftParams);

		// 右边按钮的属性
		// 宽：WRAP_CONTENT 高：WRAP_CONTENT 布局：居右对齐
		rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		addView(rightButton, rightParams);

		// 中间Tittle的属性
		tittleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		tittleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		addView(tvTittle, tittleParams);

		// 使用接口回调机制 实现按钮的点击事件
		leftButton.setOnClickListener(new MyListener());

	}

	public class MyListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			((Activity) context).finish();
		}

	}

}
