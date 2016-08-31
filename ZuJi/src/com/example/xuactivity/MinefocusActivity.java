package com.example.xuactivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.zuji.BottonNavigationActivity;
import com.example.zuji.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MinefocusActivity extends Activity implements OnClickListener {
	ImageButton ibhanhui;
	ListView minefocus_listview;
	SimpleAdapter simpleAdapter;
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.minefocus);
		intView();

	}

	public void intView() {
		minefocus_listview = (ListView) findViewById(R.id.minefocus_listview);
		String[] from = { "fanstuxiang", "howspeak", "addfans" };
		int[] to = { R.id.fanstuxiang, R.id.howspeak, R.id.addfans };
		simpleAdapter = new SimpleAdapter(this, getData(),
				R.layout.minefans_listview, from, to);
		minefocus_listview.setAdapter(simpleAdapter);
		ibhanhui=(ImageButton) findViewById(R.id.ibhanhui);
		ibhanhui.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		startActivity(new Intent(MinefocusActivity.this,BottonNavigationActivity.class));
	}
	private List<Map<String, Object>> getData() {
		for (int i = 0; i < 20; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("fanstuxiang", R.drawable.focus_iconone);
			map.put("howspeak", "怎么说");
			map.put("addfans", R.drawable.addfans);
			list.add(map);
		}
		return list;

	}


}
