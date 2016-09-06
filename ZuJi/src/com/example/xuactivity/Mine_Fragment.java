package com.example.xuactivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.xuAdapterclass.Collect;
import com.example.xuAdapterclass.MyCollectAdapter;
import com.example.xuAdapterclass.MyFabuAdapter;
import com.example.xuAdapterclass.Release;
import com.example.zuji.R;
import com.example.zuji.SheZhiActivity;

public class Mine_Fragment extends Fragment implements OnClickListener {
	TextView fensi, fensishu, guanzhu, guanzhushu;
	ImageButton shezhi;
	Button btnzujitime;
	ListView shoucang_listview;
	GridView fabu_gridview;
	List<Release> listfabu = new ArrayList<Release>();
	List<Collect> list = new ArrayList<Collect>();
	RadioGroup centre_radiogroup;
	LinearLayout layout_zhuye;
	LinearLayout layout_fabu;
	LinearLayout layout_shoucang;
	MyCollectAdapter adapter;
	MyFabuAdapter adapterfabu;
	int[] idd = { R.id.publish, R.id.xinshen, R.id.da_xin, R.id.tv_zanmunb,
			R.id.fabupinglun, R.id.tv_cemment };
	int[] id = { R.id.collect_iconone, R.id.collect_name, R.id.looktime,
			R.id.colorview, R.id.daytime, R.id.liulan, R.id.iv_zan,
			R.id.tv_number, R.id.iv_comment, R.id.comment_numb };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_mine, null);

		btnzujitime = (Button) v.findViewById(R.id.btnzujitime);
		btnzujitime.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),
						TimefusiondeletesActivity.class);
				startActivity(intent);

			}
		});
		shoucang_listview = (ListView) v.findViewById(R.id.shoucang_listview);
		fabu_gridview = (GridView) v.findViewById(R.id.fabu_gridview);
		getDataFabu();
		getData();
		adapter = new MyCollectAdapter(getActivity(),
				R.layout.mine_listview_collect, id, list);
		shoucang_listview.setAdapter(adapter);

		adapterfabu = new MyFabuAdapter(getActivity(),
				R.layout.mine_listview_release, idd, listfabu);
		fabu_gridview.setAdapter(adapterfabu);

		centre_radiogroup = (RadioGroup) v.findViewById(R.id.centre_radiogroup);
		centre_radiogroup.setOnCheckedChangeListener(checkedChangeListener);
		layout_zhuye = (LinearLayout) v.findViewById(R.id.layout_zhuye);
		layout_fabu = (LinearLayout) v.findViewById(R.id.layout_fabu);
		layout_shoucang = (LinearLayout) v.findViewById(R.id.layout_shoucang);
		layout_shoucang.setVisibility(layout_shoucang.GONE);
		layout_zhuye.setVisibility(layout_zhuye.VISIBLE);
		layout_fabu.setVisibility(layout_fabu.GONE);
		shezhi = (ImageButton) v.findViewById(R.id.set);
		shezhi.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v.getId() == R.id.set) {
					Intent intent = new Intent(getActivity(),
							SheZhiActivity.class);
					startActivity(intent);
				}

			}
		});

		fensi = (TextView) v.findViewById(R.id.fensi);
		fensishu = (TextView) v.findViewById(R.id.fensishu);
		guanzhu = (TextView) v.findViewById(R.id.guanzhu);
		guanzhushu = (TextView) v.findViewById(R.id.guanzhushu);
		fensi.setOnClickListener(this);
		fensishu.setOnClickListener(this);
		guanzhu.setOnClickListener(this);
		guanzhushu.setOnClickListener(this);
		return v;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fensi:
			startActivity(new Intent(getActivity(), MinefansActivity.class));
			break;
		case R.id.fensishu:
			startActivity(new Intent(getActivity(), MinefansActivity.class));
			break;
		case R.id.guanzhu:
			startActivity(new Intent(getActivity(), MinefocusActivity.class));
			break;
		case R.id.guanzhushu:
			startActivity(new Intent(getActivity(), MinefocusActivity.class));
			break;
		}

	}

	OnCheckedChangeListener checkedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.zhuye:
				layout_shoucang.setVisibility(layout_shoucang.GONE);
				layout_zhuye.setVisibility(layout_zhuye.VISIBLE);
				layout_fabu.setVisibility(layout_fabu.GONE);
				break;
			case R.id.fabu:
				layout_shoucang.setVisibility(layout_shoucang.GONE);
				layout_zhuye.setVisibility(layout_zhuye.GONE);
				layout_fabu.setVisibility(layout_fabu.VISIBLE);
				break;
			case R.id.shoucang:
				layout_shoucang.setVisibility(layout_shoucang.VISIBLE);
				layout_zhuye.setVisibility(layout_zhuye.GONE);
				layout_fabu.setVisibility(layout_fabu.GONE);
				break;

			default:
				break;
			}
		}
	};

	public void getData() {
		for (int i = 0; i < 20; i++) {
			Collect collect = new Collect();
			collect.setTuxiang(R.drawable.collect_iconone);
			collect.setName("恬恬喜欢的甜");
			collect.setShiwuname("芒果千层糕");
			collect.setView(R.id.colorview);
			collect.setDaytime("2015.6.8");
			collect.setLiulan("120次浏览");
			collect.setZan(R.drawable.da_xin);
			collect.setZannumb("12");
			collect.setCommection(R.drawable.comment_tu);
			collect.setCommnumb("15");
			list.add(collect);
		}

	}

	public void getDataFabu() {
		String httpHost = "http://192.168.1.175/index.php/home/api/getfabudata";
		String param = null;
		try {
			param = "user_id=" + URLEncoder.encode("123456", "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpUrlConn(httpHost, param);
	}

	public void httpUrlConn(String httpHost, String param) {
		final String newHttpHost = httpHost;
		final String newParam = param;
		new Thread(new Runnable() {
			StringBuilder builder = new StringBuilder();

			@Override
			public void run() {
				try {
					String urlName = newHttpHost + "?" + newParam;
					URL url = new URL(urlName);
					HttpURLConnection httpURLConnection = (HttpURLConnection) url
							.openConnection();
					httpURLConnection.setConnectTimeout(5000);
					httpURLConnection.connect();
					if (httpURLConnection.getResponseCode() == 200) {
						InputStream inputStream = httpURLConnection
								.getInputStream();
						// 获取输入流，相应内容
						BufferedReader bufferedReader = new BufferedReader(
								new InputStreamReader(inputStream));
						String line = bufferedReader.readLine();
						while (line != null && line.length() > 0) {
							builder.append(line);
							line = bufferedReader.readLine();
						}
						bufferedReader.close();
						inputStream.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				Log.i("httppost===>Data", builder.toString());
				getJsonData(builder.toString());
			}
		}).start();

	}

	public void getJsonData(String data) {
		try {
			JSONArray jsonArray = new JSONArray(data);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject2 = jsonArray.getJSONObject(i);
				String content_text = jsonObject2.get("content_text")
						.toString();
				String count_zan = jsonObject2.getString("count_zan")
						.toString();
				String count_pinlun = jsonObject2.getString("count_pinlun")
						.toString();
				Release release = new Release();
				release.setImageId(R.drawable.publish_imgone);
				release.setXinsheng(content_text);
				release.setZan(R.drawable.da_xin);
				release.setZanmunb(count_zan);
				release.setFabupinglun(count_pinlun);
				release.setFabupingluntu(R.drawable.comment_tu);
				listfabu.add(release);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
