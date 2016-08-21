package com.example.Fragment;

import com.example.supermap.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentManager extends Fragment implements OnClickListener {

	LinearLayout checkBtn, detailBtn, naviBtn, settingBtn;
	HomeFragment checkFragment;
	DetailFragment detailFragment;
	NaviFragment naviFragment;
	SettingFragment settingFragment;

	ImageView iv_check, iv_detail, iv_navi, iv_setting;
	TextView tv_check, tv_detail, tv_navi, tv_setting;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_manager, container, false);
	}

	@SuppressLint("NewApi")
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		initView();
		setListener();

		// 页面展开后 首先展示出checkFragment
		getChildFragmentManager().beginTransaction()
				.replace(R.id.frameContent, checkFragment).commit();
		switchColor(R.id.check);
	}

	private void setListener() {
		checkBtn.setOnClickListener(this);
		detailBtn.setOnClickListener(this);
		naviBtn.setOnClickListener(this);
		settingBtn.setOnClickListener(this);
	}

	private void initView() {
		checkBtn = (LinearLayout) getActivity().findViewById(R.id.check);
		detailBtn = (LinearLayout) getActivity().findViewById(R.id.detail);
		naviBtn = (LinearLayout) getActivity().findViewById(R.id.navi);
		settingBtn = (LinearLayout) getActivity().findViewById(R.id.setting);

		checkFragment = new HomeFragment();
		detailFragment = new DetailFragment();
		naviFragment = new NaviFragment();
		settingFragment = new SettingFragment();

		iv_check = (ImageView) getActivity().findViewById(R.id.iv_check);
		iv_detail = (ImageView) getActivity().findViewById(R.id.iv_detail);
		iv_navi = (ImageView) getActivity().findViewById(R.id.iv_navi);
		iv_setting = (ImageView) getActivity().findViewById(R.id.iv_setting);

		tv_check = (TextView) getActivity().findViewById(R.id.tv_check);
		tv_detail = (TextView) getActivity().findViewById(R.id.tv_detail);
		tv_navi = (TextView) getActivity().findViewById(R.id.tv_navi);
		tv_setting = (TextView) getActivity().findViewById(R.id.tv_setting);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.check:
			switchFragment(checkFragment);
			// 改变颜色和图片
			switchColor(R.id.check);
			break;
		case R.id.detail:
			switchFragment(detailFragment);
			switchColor(R.id.detail);
			break;
		case R.id.navi:
			switchFragment(naviFragment);
			switchColor(R.id.navi);
			break;
		case R.id.setting:
			switchFragment(settingFragment);
			switchColor(R.id.setting);
			break;

		default:
			break;
		}
	}

	@SuppressLint("NewApi")
	private void switchFragment(Fragment fragment) {
		getChildFragmentManager().beginTransaction()
				.replace(R.id.frameContent, fragment).commit();
	}

	@SuppressLint({ "NewApi", "ResourceAsColor" })
	public void switchColor(int id) {
		switch (id) {
		case R.id.check:
			iv_check.setImageResource(R.drawable.tab_check_se);
			tv_check.setTextColor(getActivity().getResources().getColor(
					R.color.blue));
			iv_detail.setImageResource(R.drawable.tab_detail);
			tv_detail.setTextColor(R.color.black);
			iv_navi.setImageResource(R.drawable.tab_navi);
			tv_navi.setTextColor(R.color.black);
			iv_setting.setImageResource(R.drawable.tab_setting);
			tv_setting.setTextColor(R.color.black);
			break;
		case R.id.detail:
			iv_detail.setImageResource(R.drawable.tab_detail_se);
			tv_detail.setTextColor(getActivity().getResources().getColor(
					R.color.blue));

			iv_check.setImageResource(R.drawable.tab_check);
			tv_check.setTextColor(getActivity().getResources().getColor(
					R.color.black));
			iv_navi.setImageResource(R.drawable.tab_navi);
			tv_navi.setTextColor(R.color.black);
			iv_setting.setImageResource(R.drawable.tab_setting);
			tv_setting.setTextColor(R.color.black);
			break;
		case R.id.navi:
			iv_navi.setImageResource(R.drawable.tab_navi_se);
			tv_navi.setTextColor(getActivity().getResources().getColor(
					R.color.blue));

			iv_check.setImageResource(R.drawable.tab_check);
			tv_check.setTextColor(getActivity().getResources().getColor(
					R.color.black));
			iv_detail.setImageResource(R.drawable.tab_detail);
			tv_detail.setTextColor(R.color.black);
			iv_setting.setImageResource(R.drawable.tab_setting);
			tv_setting.setTextColor(R.color.black);
			break;
		case R.id.setting:
			iv_setting.setImageResource(R.drawable.tab_setting_se);
			tv_setting.setTextColor(getActivity().getResources().getColor(
					R.color.blue));

			iv_check.setImageResource(R.drawable.tab_check);
			tv_check.setTextColor(getActivity().getResources().getColor(
					R.color.black));
			iv_detail.setImageResource(R.drawable.tab_detail);
			tv_detail.setTextColor(R.color.black);
			iv_navi.setImageResource(R.drawable.tab_navi);
			tv_navi.setTextColor(R.color.black);
			break;

		default:
			break;
		}
	}

}
