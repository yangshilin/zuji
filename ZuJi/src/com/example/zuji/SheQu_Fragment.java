package com.example.zuji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SheQu_Fragment extends Fragment {
	RadioGroup shequ_randiogroup;
	RadioButton guangchang;
	RadioButton guanzhu;
	ImageView write;
	ImageView xiaobian1;
	RelativeLayout tag1;
	RelativeLayout tag2;
	RelativeLayout tag3;
	ListView guanzhu_listview;
	LinearLayout layout_guangchang;
	LinearLayout layout_guanzhu;
	LayoutInflater inflater;
	ListView listview;
	String[] from = { "icon", "name", "time", "content_image", "title",
			"content_time", "content_count", "dianzan_count", "comment_count" };
	int[] to = { R.id.icon, R.id.name, R.id.time, R.id.content_image,
			R.id.title, R.id.content_time, R.id.content_count,
			R.id.dianzan_count, R.id.comment_count };
	List<Map<String, Object>> data;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_shequ, null);
		shequ_randiogroup = (RadioGroup) v.findViewById(R.id.shequ_randiogroup);
		shequ_randiogroup.setOnCheckedChangeListener(checkedChangeListener);
		guangchang = (RadioButton) v.findViewById(R.id.shequ_guangchang);
		guanzhu = (RadioButton) v.findViewById(R.id.guanzhu);
		write = (ImageView) v.findViewById(R.id.shequ_write);
		xiaobian1 = (ImageView) v.findViewById(R.id.xiaobian1);
		write.setOnClickListener(clickListener);
		xiaobian1.setOnClickListener(clickListener);
		layout_guangchang = (LinearLayout) v
				.findViewById(R.id.layout_guangchang);
		layout_guanzhu = (LinearLayout) v.findViewById(R.id.layout_guanzhu);
		layout_guanzhu.setVisibility(layout_guanzhu.GONE);
		listview = (ListView) v.findViewById(R.id.guanzhu_listview);

		listview.setOnItemClickListener(itemClickListener);
		getData();
		listview.setAdapter(new GuanZhuAdapater(getActivity(), data,
				R.layout.guanzhu_listview_item, from, to));
		tag1 = (RelativeLayout) v.findViewById(R.id.tag1);
		tag1.setOnClickListener(clickListener);
		tag2 = (RelativeLayout) v.findViewById(R.id.tag2);
		tag2.setOnClickListener(clickListener);
		tag3 = (RelativeLayout) v.findViewById(R.id.tag3);
		tag3.setOnClickListener(clickListener);
		return v;
	}

	OnItemClickListener itemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view,
				final int position, long id) {
			Toast.makeText(getActivity(), "" + position, 0).show();
			ImageView share = (ImageView) view.findViewById(R.id.share);
			share.setOnClickListener(clickListener);
		}
	};
	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.shequ_write:
				Intent intent = new Intent(getActivity(), DynamicActivity.class);
				startActivity(intent);
				break;
			case R.id.tag1:
				Intent intent_meishi = new Intent(getActivity(),
						MeiShiActivity.class);
				startActivity(intent_meishi);
				break;
			case R.id.tag2:
				Intent intent_chongqing = new Intent(getActivity(),
						ChongQingActivity.class);
				startActivity(intent_chongqing);
				break;
			case R.id.tag3:
				break;
			case R.id.share:

				break;
			case R.id.xiaobian1:
				startActivity(new Intent(getActivity(),DynamicSiBuSheYingActivity.class));
				break;
			default:
				break;
			}
		}
	};

	public void getData() {
		data = new ArrayList<Map<String, Object>>();
		Map<String, Object> data_item = new HashMap<String, Object>();
		data_item.put("icon", R.drawable.focus_icon1);
		data_item.put("name", "怎么说");
		data_item.put("time", "10小时前");
		data_item.put("content_image", R.drawable.collect_img1);
		data_item.put("title", "我在北方的寒夜里四季如春");
		data_item.put("content_time", "2016.1.20");
		data_item.put("content_count", "200");
		data_item.put("dianzan_count", "124");
		data_item.put("comment_count", "15");
		data.add(data_item);

		data_item = new HashMap<String, Object>();
		data_item.put("icon", R.drawable.home_page_arrow_back_up);
		data_item.put("name", "等你来");
		data_item.put("time", "10小时前");
		data_item.put("content_image", R.drawable.collect_img1);
		data_item.put("title", "糯米蛋糕");
		data_item.put("content_time", "2016.2.8");
		data_item.put("content_count", "30");
		data_item.put("dianzan_count", "124");
		data_item.put("comment_count", "15");
		data.add(data_item);

	}

	OnCheckedChangeListener checkedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.guanzhu:
				layout_guanzhu.setVisibility(layout_guanzhu.VISIBLE);
				layout_guangchang.setVisibility(layout_guangchang.GONE);
				shequ_randiogroup.setBackgroundDrawable(getResources()
						.getDrawable(R.drawable.yuanjiao_backgrund_other));
				guangchang.setTextColor(getResources().getColor(R.color.white));
				guanzhu.setTextColor(getResources().getColor(R.color.lvse));
				break;
			case R.id.shequ_guangchang:
				layout_guanzhu.setVisibility(layout_guanzhu.GONE);
				layout_guangchang.setVisibility(layout_guangchang.VISIBLE);
				shequ_randiogroup.setBackgroundDrawable(getResources()
						.getDrawable(R.drawable.yuanjiao_backgrund));
				guangchang.setTextColor(getResources().getColor(R.color.lvse));
				guanzhu.setTextColor(getResources().getColor(R.color.white));
				break;
			default:
				break;
			}
		}
	};
}
