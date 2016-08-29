package com.example.xuactivity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.xuAdapterclass.Collect;
import com.example.xuAdapterclass.MyCollectAdapter;
import com.example.xuAdapterclass.MyFabuAdapter;
import com.example.xuAdapterclass.Release;
import com.example.zuji.GeRenTouXiangActivity;
import com.example.zuji.R;
import com.example.zuji.SheZhiActivity;

public class Mine_Fragment extends Fragment implements OnClickListener {
	ImageView tuceng_icon;
	TextView tiaofensi;
	TextView tiaoguanzhu;
	TextView fensi;
	TextView guanzhu;
	ImageButton shezhi;
	Button btnzujitime;
	ListView shoucang_listview;
	GridView fabu_gridview;
	List<Release> listfabu = new ArrayList<Release>();
	List<Collect> list = new ArrayList<Collect>();;
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
		View v = inflater.inflate(R.layout.fragment_mine, null);
		btnzujitime = (Button) v.findViewById(R.id.btnzujitime);
		// 进入时光轴
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
		// 收藏转换
		adapterfabu = new MyFabuAdapter(getActivity(),
				R.layout.mine_listview_release, idd, listfabu);
		fabu_gridview.setAdapter(adapterfabu);
		// 发布转换
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
				if (v.getId() == R.id.set) {
					Intent intent = new Intent(getActivity(),
							SheZhiActivity.class);
					startActivity(intent);
				}

			}
		});
		tuceng_icon = (ImageView) v.findViewById(R.id.tuceng_icon);
		fensi = (TextView) v.findViewById(R.id.fensi);
		guanzhu = (TextView) v.findViewById(R.id.guanzhu);
		tiaofensi = (TextView) v.findViewById(R.id.tiaofensi);
		tiaoguanzhu = (TextView) v.findViewById(R.id.tiaoguanzhu);
		fensi.setOnClickListener(this);
		guanzhu.setOnClickListener(this);
		tiaofensi.setOnClickListener(this);
		tiaoguanzhu.setOnClickListener(this);
		tuceng_icon.setOnClickListener(this);
		return v;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fensi:
			Intent intent = new Intent(getActivity(), MinefansActivity.class);
			startActivity(intent);
			break;

		case R.id.guanzhu:
			Intent intent2 = new Intent(getActivity(), MinefocusActivity.class);
			startActivity(intent2);
			break;
		case R.id.tiaofensi:
			Intent intent3 = new Intent(getActivity(), MinefocusActivity.class);
			startActivity(intent3);
			break;
		case R.id.tiaoguanzhu:
			Intent intent4 = new Intent(getActivity(), MinefocusActivity.class);
			startActivity(intent4);
			break;
		case R.id.tuceng_icon:
			Intent intent5 = new Intent(getActivity(), GeRenTouXiangActivity.class);
			startActivity(intent5);
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

	public void getData() {// 收藏的数据
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

	public void getDataFabu() {// 发布的数据
		for (int i = 0; i < 20; i++) {
			Release release = new Release();
			release.setImageId(R.drawable.publish_imgone);
			release.setXinsheng("一路向北，只为在最美丽的季节与你相遇。");
			release.setZan(R.drawable.da_xin);
			release.setZanmunb("20");
			release.setFabupinglun("99");
			release.setFabupingluntu(R.drawable.comment_tu);
			listfabu.add(release);
		}
	}

}
