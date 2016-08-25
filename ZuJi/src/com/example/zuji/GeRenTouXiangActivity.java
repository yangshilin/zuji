package com.example.zuji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

public class GeRenTouXiangActivity extends Activity {
	private final int paizhao = 0;
	private final int xuanze = 1;
	private final int baocun = 2;
	private final int quxiao = 3;
	
	
	ImageButton touxiangReturn;
	LinearLayout xuanzedialog;
	
	
	
	AlertDialog menuDialog;
	GridView gridview;
	SimpleAdapter simpleAdapter;
	List<Map<String, Object>> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gerentouxiang);

		touxiangReturn = (ImageButton) findViewById(R.id.touxiang_return);
		xuanzedialog = (LinearLayout) findViewById(R.id.caidan_touxiang);

		xuanzedialog.setOnClickListener(onClickListener);
		touxiangReturn.setOnClickListener(onClickListener);

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.touxiang_return:
				break;
			case R.id.caidan_touxiang:
				showMenu();
				break;

			default:
				break;
			}
		}
	};

	public void showMenu() {
		gridview = (GridView) findViewById(R.id.touxiang_griview);

		/*String[] from = { "paizhao_touxiang" };
		int[] to = { R.id.paizhao_touxiang };
		simpleAdapter = new SimpleAdapter(this, data(),
				R.layout.gerentouxiang_menu, from, to);*/

		gridview.setGravity(Gravity.BOTTOM);
		ArrayList<HashMap<String, Object>> item = new ArrayList<HashMap<String, Object>>();
	
			HashMap<String, Object> map = new HashMap<String, Object>();
			for(int i=0;i<4;i++){
				
			}
			map.put("ItemText", "拍照");
			map = new HashMap<String, Object>();
			item.add(map);
			map.put("ItemText", "从相册中选择");
			map = new HashMap<String, Object>();
			item.add(map);
			map.put("ItemText", "保存");
			map = new HashMap<String, Object>();
			item.add(map);
			map.put("ItemText", "取消");
			item.add(map);
	
		SimpleAdapter items = new SimpleAdapter(this, item,
				R.layout.gerentouxiang_menu, new String[] { "ItemText" },
				new int[] { R.id.paizhao_touxiang });
		gridview.setAdapter(items);
		gridview.setOnItemClickListener(onItemClickListener);
	}

	OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			HashMap<String, Object> item = (HashMap<String, Object>) parent
					.getItemAtPosition(position);
			setTitle((String) item.get("ItemText"));
			switch (position) {
			case paizhao:
				Intent intent=new Intent(GeRenTouXiangActivity.this,ZuJiActivity.class);
				startActivity(intent);
				break;
			case xuanze:
				Intent intent2=new Intent(GeRenTouXiangActivity.this,ZuJiActivity.class);
				startActivity(intent2);
				break;
			case baocun:
				Intent intent3=new Intent(GeRenTouXiangActivity.this,ZuJiActivity.class);
				startActivity(intent3);
				break;
			case quxiao:
				Intent intent4=new Intent(GeRenTouXiangActivity.this,ZuJiActivity.class);
				startActivity(intent4);
				break;
			default:
				break;
			}
		}

	};

	/*private List<Map<String, Object>> data() {
		list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paizhao_touxiang", "拍照");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("paizhao_touxiang", "拍照");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("paizhao_touxiang", "拍照");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("paizhao_touxiang", "拍照");
		list.add(map);
		return list;

	}*/
}
