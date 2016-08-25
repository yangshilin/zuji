package com.example.zuji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class ChongQingActivity extends Activity {
	NotScrollListView cq_list_left;
	NotScrollListView cq_list_right;
	ImageView cq_back;
	String[] from = { "image", "name", "time", "xiai", "meishi_image", };
	int[] to = { R.id.touxiang_image, R.id.name, R.id.time, R.id.xiai,
			R.id.meishi_image };
	List<Map<String, Object>> cq_data_left;
	List<Map<String, Object>> cq_data_right;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_chongqing);
		getDataForLeft();
		getDataForRight();
		cq_list_left = (NotScrollListView) findViewById(R.id.cq_listview_left);
		MeiShiAdapter meiShiAdapte_left = new MeiShiAdapter(
				getApplicationContext(), cq_data_left, R.layout.listview_left,
				from, to);
		cq_list_left.setAdapter(meiShiAdapte_left);
		cq_list_right = (NotScrollListView) findViewById(R.id.cq_listview_right);
		MeiShiAdapter meiShiAdapte_right = new MeiShiAdapter(
				getApplicationContext(), cq_data_right, R.layout.listview_right,
				from, to);
		cq_list_right.setAdapter(meiShiAdapte_right);
		cq_back = (ImageView) findViewById(R.id.cq_back);
		cq_back.setOnClickListener(clickListener);
	}

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.cq_back:

				break;

			default:
				break;
			}
		}
	};
	public void getDataForLeft() {
		cq_data_left = new ArrayList<Map<String, Object>>();
		Map<String, Object> data_item = new HashMap<String, Object>();
		data_item.put("image", R.drawable.logo_1);
		data_item.put("name", "笑谈曾经");
		data_item.put("time", "2");
		data_item.put("xiai", R.drawable.red_heart);
		data_item.put("meishi_image", R.drawable.meishi);
		cq_data_left.add(data_item);
		data_item = new HashMap<String, Object>();
		data_item.put("image", R.drawable.logo_2);
		data_item.put("name", "言希");
		data_item.put("time", "2");
		data_item.put("xiai", R.drawable.xiai);
		data_item.put("meishi_image", R.drawable.meishi);
		cq_data_left.add(data_item);

	}

	public void getDataForRight() {
		cq_data_right = new ArrayList<Map<String, Object>>();
		Map<String, Object> data_item = new HashMap<String, Object>();
		data_item.put("image", R.drawable.logo_3);
		data_item.put("name", "陌尘漓殇");
		data_item.put("time", "5");
		data_item.put("xiai", R.drawable.red_heart);
		data_item.put("meishi_image", R.drawable.dongtai2);
		cq_data_right.add(data_item);
		data_item = new HashMap<String, Object>();
		data_item.put("image", R.drawable.logo_4);
		data_item.put("name", "念之深蓝");
		data_item.put("time", "6");
		data_item.put("xiai", R.drawable.xiai);
		data_item.put("meishi_image", R.drawable.dongtai3);
		cq_data_right.add(data_item);
		data_item = new HashMap<String, Object>();
		data_item.put("image", R.drawable.logo_5);
		data_item.put("name", "笑颜如初");
		data_item.put("time", "8");
		data_item.put("xiai", R.drawable.xiai);
		data_item.put("meishi_image", R.drawable.dongtai3);
		cq_data_right.add(data_item);

	}

}
