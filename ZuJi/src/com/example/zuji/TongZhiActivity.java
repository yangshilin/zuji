package com.example.zuji;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.zuji.adapter.TongZhiAdapter;
import com.example.zuji.javaclass.TongZhi;

public class TongZhiActivity extends Activity {
	TongZhiAdapter adapter;
	ListView listview;
	List<TongZhi> tongzhilist;
	int[] id={R.id.tongzhi_otherImage,R.id.tongzhi_name,R.id.tongzhi_guanzhu,
			R.id.tongzhi_you,R.id.tongzhi_time,R.id.tongzhi_addimage};
	ImageButton tongzhiReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tongzhi);
		
		tongzhiReturn=(ImageButton)findViewById(R.id.return_tongzhi);
		listview=(ListView)findViewById(R.id.listview_tongzhi);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(TongZhiActivity.this,ZuJiActivity.class);
				startActivity(intent);
			}
		});
		getData();
		adapter=new TongZhiAdapter(TongZhiActivity.this,tongzhilist,
				R.layout.tongzhi_listview_item,id);
		listview.setAdapter(adapter);
		
		tongzhiReturn.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.return_tongzhi:
				Intent intent =new Intent(TongZhiActivity.this,BottonNavigationActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
		
	};
	public void getData(){
		tongzhilist=new ArrayList<TongZhi>();
		TongZhi tongzhi=new TongZhi();
		tongzhi.setOtherImage(R.drawable.praise_friend_head);
		tongzhi.setName(getResources().getString(R.string.zuji));
		tongzhi.setGuanzhu(getResources().getString(R.string.guanzhu));
		tongzhi.setYou(getResources().getString(R.string.ni));
		tongzhi.setTime(getResources().getString(R.string.shijian));
		tongzhi.setAddImage(R.drawable.add);
		tongzhilist.add(tongzhi);
	}
	
}
