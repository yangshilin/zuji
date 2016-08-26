package com.example.zuji;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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
	GridView gridview;

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
	public void show(){
	
	}

	public void showMenu() {
		gridview = (GridView) findViewById(R.id.touxiang_griview);
		gridview.setGravity(Gravity.BOTTOM);
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ItemText", "拍照");
		list.add(map);
		SimpleAdapter adapter = new SimpleAdapter(this, list,
				R.layout.gerentouxiang_menu, new String[] { "ItemText" },
				new int[] { R.id.paizhao_touxiang });
		gridview.setAdapter(adapter);
		gridview.setOnItemClickListener(onItemClickListener);
	}
	OnItemClickListener onItemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			switch (position) {
			case paizhao:
				
				break;
			case xuanze:
				Intent intent2 = new Intent(GeRenTouXiangActivity.this,
						SheZhiActivity.class);
				startActivity(intent2);
				break;
			case baocun:
				Intent intent3 = new Intent(GeRenTouXiangActivity.this,
						SheZhiActivity.class);
				startActivity(intent3);
				break;
			case quxiao:
				Intent intent4 = new Intent(GeRenTouXiangActivity.this,
						SheZhiActivity.class);
				startActivity(intent4);
				break;
			default:
				break;
			}
		}

	};
	/*public void getPhoto(View v){//拍照
		Intent intent = new Intent();intent.setAction("android.media.action.IMAGE_CAPTURE");
		intent.addCategory("android.intent.category.DEFAULT");
		 File file = new File(Environment.getExternalStorageDirectory()+"/000.jpg"); 
		 Uri uri = Uri.fromFile(file);
		 intent.putExtra(MediaStore.EXTRA_OUTPUT, uri); 
		this.startActivity(intent);
}*/
}