package com.example.zuji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class MeiShiActivity extends Activity {
	NotScrollListView list_left;
	NotScrollListView list_right;
	ImageView meishi_back;
	String[] from = { "image", "name", "time", "xiai", "meishi_image", };
	int[] to = { R.id.touxiang_image, R.id.name, R.id.time, R.id.xiai,
			R.id.meishi_image };
	List<Map<String, Object>> data_left;
	List<Map<String, Object>> data_right;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_meishi);
		getDataForLeft();
		getDataForRight();
		list_left = (NotScrollListView) findViewById(R.id.meishi_listview_left);

		MeiShiAdapter meiShiAdapte_left = new MeiShiAdapter(
				getApplicationContext(), data_left, R.layout.listview_left,
				from, to);
		list_left.setAdapter(meiShiAdapte_left);
		list_right = (NotScrollListView) findViewById(R.id.meishi_listview_right);
		MeiShiAdapter meiShiAdapte_right = new MeiShiAdapter(
				getApplicationContext(), data_right, R.layout.listview_right,
				from, to);
		list_right.setAdapter(meiShiAdapte_right);
		meishi_back = (ImageView) findViewById(R.id.meishi_back);
		meishi_back.setOnClickListener(clickListener);
		list_left.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_MOVE:
					v.getParent().requestDisallowInterceptTouchEvent(true);
					break;
				case MotionEvent.ACTION_DOWN:
					v.getParent().requestDisallowInterceptTouchEvent(false);
				case MotionEvent.ACTION_UP:
					v.getParent().requestDisallowInterceptTouchEvent(false);
				case MotionEvent.ACTION_CANCEL:
					v.getParent().requestDisallowInterceptTouchEvent(false);
					break;
				}
				return false;
			}

		});
		list_left.setOnItemClickListener(itemClickListener);
	}

	OnItemClickListener itemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Log.i("onItemClick", position + "");
			if (position == 0) {
				startActivity(new Intent(MeiShiActivity.this,
						MeiShiDynamic_Activity.class));
			}
		}
	};
	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.meishi_back:
				startActivity(new Intent(MeiShiActivity.this,
						BottonNavigationActivity.class));
				break;

			default:
				break;
			}
		}
	};

	public void getDataForLeft() {
		data_left = new ArrayList<Map<String, Object>>();
		Map<String, Object> data_item = new HashMap<String, Object>();
		data_item.put("image", R.drawable.logo_1);
		data_item.put("name", "听风逝夜");
		data_item.put("time", "2");
		data_item.put("xiai", R.drawable.red_heart);
		data_item.put("meishi_image", R.drawable.meishi);
		data_left.add(data_item);
		data_item = new HashMap<String, Object>();
		data_item.put("image", R.drawable.logo_2);
		data_item.put("name", "南岸青栀");
		data_item.put("time", "2");
		data_item.put("xiai", R.drawable.xiai);
		data_item.put("meishi_image", R.drawable.meishi);
		data_left.add(data_item);

	}

	public void getDataForRight() {
		data_right = new ArrayList<Map<String, Object>>();
		Map<String, Object> data_item = new HashMap<String, Object>();
		data_item.put("image", R.drawable.logo_3);
		data_item.put("name", "灯火阑珊");
		data_item.put("time", "5");
		data_item.put("xiai", R.drawable.red_heart);
		data_item.put("meishi_image", R.drawable.dongtai2);
		data_right.add(data_item);
		data_item = new HashMap<String, Object>();
		data_item.put("image", R.drawable.logo_4);
		data_item.put("name", "南巷清风");
		data_item.put("time", "6");
		data_item.put("xiai", R.drawable.xiai);
		data_item.put("meishi_image", R.drawable.dongtai3);
		data_right.add(data_item);
		data_item = new HashMap<String, Object>();
		data_item.put("image", R.drawable.logo_5);
		data_item.put("name", "幻墨如烟");
		data_item.put("time", "8");
		data_item.put("xiai", R.drawable.xiai);
		data_item.put("meishi_image", R.drawable.dongtai3);
		data_right.add(data_item);

	}
}
