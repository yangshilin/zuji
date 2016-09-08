package com.example.xuactivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.zuji.BottonNavigationActivity;
import com.example.zuji.R;

public class Mine_collect_activity extends Activity implements OnClickListener{

	View header;// 头视图
	ImageView real_logo;
	TextView kittyname;
	TextView fabutime;
	TextView title_name;
	
	ImageButton fanhuicollect;

	ListView collect_listviewsup;
	SimpleAdapter saAdpter;
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		 setContentView(R.layout.mine_collect_activity);
		 
		 collect_listviewsup=(ListView)findViewById(R.id.collect_listviewsup);
		 LayoutInflater inflater=LayoutInflater.from(Mine_collect_activity.this);
			header=inflater.inflate(R.layout.mine_collect_listheader,null);
			real_logo = (ImageView) header.findViewById(R.id.real_logo);
			kittyname = (TextView) header.findViewById(R.id.kittyname);
			fabutime = (TextView) header.findViewById(R.id.fabutime);
			title_name = (TextView) header.findViewById(R.id.title_name);
			collect_listviewsup.addHeaderView(header);
			intView();
			
	}
	

	public void intView() {
		fanhuicollect=(ImageButton) findViewById(R.id.fanhuicollect);
		fanhuicollect.setOnClickListener(this);
		collect_listviewsup = (ListView) findViewById(R.id.collect_listviewsup);
		
		String[] from = { "iv_mijia", "daytime", "tv_speak" };
		int[] to = { R.id.iv_mijia, R.id.daytime, R.id.tv_speak };
		saAdpter = new SimpleAdapter(Mine_collect_activity.this, getData(),
				R.layout.collect_listviewsup, from, to);
		collect_listviewsup.setAdapter(saAdpter);
		
	}
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.fanhuicollect:
			startActivity(new Intent(Mine_collect_activity.this,BottonNavigationActivity.class));
			break;

		default:
			break;
		}
		
		
		
	}

	private List<Map<String, Object>> getData() {
		list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iv_mijia", R.drawable.sceneryfour);
		map.put("daytime", "Day one");
		map.put("tv_speak", "到达酒店后，就赶紧休息。一觉睡到自然醒，居然还赶上了早餐.");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("iv_mijia", R.drawable.sceneryfour);
		map.put("daytime", "Day one");
		map.put("tv_speak", "到达酒店后，就赶紧休息。一觉睡到自然醒，居然还赶上了早餐.");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("iv_mijia", R.drawable.sceneryfour);
		map.put("daytime", "Day one");
		map.put("tv_speak", "到达酒店后，就赶紧休息。一觉睡到自然醒，居然还赶上了早餐.");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("iv_mijia", R.drawable.sceneryfour);
		map.put("daytime", "Day one");
		map.put("tv_speak", "到达酒店后，就赶紧休息。一觉睡到自然醒，居然还赶上了早餐.");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("iv_mijia", R.drawable.sceneryfour);
		map.put("daytime", "Day one");
		map.put("tv_speak", "到达酒店后，就赶紧休息。一觉睡到自然醒，居然还赶上了早餐.");
		list.add(map);

		return list;

	}


	

}
