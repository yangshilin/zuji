package com.example.xuactivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.zuji.BottonNavigationActivity;
import com.example.zuji.R;

public class MinefansActivity extends Activity implements OnClickListener{
	ImageButton fanhuimine;
	ListView minefans_listview;
	SimpleAdapter saAdapter;
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.minefans);
		intView();

	}

	private void intView() {
		minefans_listview = (ListView) findViewById(R.id.minefans_listview);
		String[] from = { "fanstuxiang", "howspeak", "addfans" };
		int[] to = { R.id.fanstuxiang, R.id.howspeak, R.id.addfans };
		saAdapter = new SimpleAdapter(this, getlist(),
				R.layout.minefans_listview, from, to);
		minefans_listview.setAdapter(saAdapter);
		fanhuimine=(ImageButton) findViewById(R.id.fanhuimine);
		fanhuimine.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		startActivity(new Intent(MinefansActivity.this,BottonNavigationActivity.class));
	}
	private List<Map<String, Object>> getlist() {
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
