package com.example.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.supermap.R;
import com.google.gson.Gson;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

public class NaviFragment extends Fragment {


	

	private Context mContext;
	private TextView weather_net, shidu_net, temperature_net, wind_net, pm_net,
			address, date, nongli, xiche_tittle, xiche_content, wuran_tittle,
			wuran_content, sport_tittle, sport_content, loading;
	private LinearLayout line1;
	private RelativeLayout xiche_lay, wuran_lay, yundong_lay;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.navi_fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		mContext = getActivity();
		initView();

		Parameters params = new Parameters();
		params.add("ip", "www.juhe.cn");
		params.add("dtype", "json");
		params.add("cityname", "北京");
		JuheData.executeWithAPI(mContext, 73,
				"http://op.juhe.cn/onebox/weather/query", JuheData.GET,
				params, new DataCallBack() {
					@Override
					public void onSuccess(int statusCode,
							String responseString) {

						line1.setVisibility(View.VISIBLE);
						xiche_lay.setVisibility(View.VISIBLE);
						wuran_lay.setVisibility(View.VISIBLE);
						yundong_lay.setVisibility(View.VISIBLE);
						loading.setVisibility(View.GONE);
						Gson gson = new Gson();
						com.example.juhedata.Bean bean = gson.fromJson(responseString,
								com.example.juhedata.Bean.class);
						String weather = bean.getResult().getData().getRealtime()
								.getWeather().getInfo();
						String temperature = bean.getResult().getData().getRealtime()
								.getWeather().getTemperature()
								+ "℃";
						String shidu = bean.getResult().getData().getRealtime()
								.getWeather().getHumidity();
						String wind = bean.getResult().getData().getRealtime().getWind()
								.getDirect();
						String pm25 = bean.getResult().getData().getPm25().getPm25()
								.getPm25();
						String address = bean.getResult().getData().getRealtime()
								.getCity_name();
						String nongli = "农历"
								+ bean.getResult().getData().getRealtime().getMoon();
						String date = bean.getResult().getData().getRealtime().getDate();
						String str_xiche_tittle = bean.getResult().getData().getLife()
								.getInfo().getXiche().get(0);
						String str_xiche_content = bean.getResult().getData().getLife()
								.getInfo().getXiche().get(1);
						String str_wuran_tittle = bean.getResult().getData().getLife()
								.getInfo().getWuran().get(0);
						String str_wuran_content = bean.getResult().getData().getLife()
								.getInfo().getWuran().get(1);
						String str_sport_tittle = bean.getResult().getData().getLife()
								.getInfo().getYundong().get(0);
						String str_sport_content = bean.getResult().getData().getLife()
								.getInfo().getYundong().get(1);

						weather_net.setText(weather);
						temperature_net.setText(temperature);
						shidu_net.setText(shidu);
						wind_net.setText(wind);
						pm_net.setText(pm25);
						NaviFragment.this.address.setText(address);
						NaviFragment.this.nongli.setText(nongli);
						NaviFragment.this.date.setText(date);
						xiche_tittle.setText(str_xiche_tittle);
						xiche_content.setText(str_xiche_content);
						wuran_tittle.setText(str_wuran_tittle);
						wuran_content.setText(str_wuran_content);
						sport_tittle.setText(str_sport_tittle);
						sport_content.setText(str_sport_content);

					}

					@Override
					public void onFinish() {
					}

					@Override
					public void onFailure(int statusCode,
							String responseString, Throwable throwable) {

					}
				});
	}

	private void initView() {
		weather_net = (TextView) getActivity().findViewById(R.id.weather_net);
		shidu_net = (TextView) getActivity().findViewById(R.id.shidu_net);
		temperature_net = (TextView) getActivity().findViewById(
				R.id.temperature_net);
		wind_net = (TextView) getActivity().findViewById(R.id.wind_net);
		pm_net = (TextView) getActivity().findViewById(R.id.pm25_net);
		address = (TextView) getActivity().findViewById(R.id.address_net);
		nongli = (TextView) getActivity().findViewById(R.id.nongli_net);
		date = (TextView) getActivity().findViewById(R.id.date_net);
		xiche_tittle = (TextView) getActivity().findViewById(R.id.xiche_tittle);
		xiche_content = (TextView) getActivity().findViewById(
				R.id.xiche_content);
		wuran_tittle = (TextView) getActivity().findViewById(R.id.wuran_tittle);
		wuran_content = (TextView) getActivity().findViewById(
				R.id.wuran_content);
		sport_content = (TextView) getActivity().findViewById(
				R.id.sport_content);
		sport_tittle = (TextView) getActivity().findViewById(R.id.sport_tittle);
		line1 = (LinearLayout) getActivity().findViewById(R.id.linearLayout1);
		xiche_lay = (RelativeLayout) getActivity().findViewById(
				R.id.linelayout_xiche);
		wuran_lay = (RelativeLayout) getActivity().findViewById(
				R.id.linelayout_wuran);
		yundong_lay = (RelativeLayout) getActivity().findViewById(
				R.id.linelayout_sport);
		loading = (TextView) getActivity().findViewById(R.id.loading);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		JuheData.cancelRequests(mContext);
	}

}
