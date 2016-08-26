package com.example.zuji;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.zuji.adapter.PingLunAdapter;
import com.example.zuji.javaclass.PingLun;



public class PingLunActivity extends Activity{
	ListView listview;
	int[] id={R.id.touxiang_pinglun,R.id.otheraName_pinglun,R.id.zipinglun_pinglun,R.id.nide_pinglun,
			R.id.huifu_pinglun,R.id.pingjia_pinglun,R.id.userImage_pinglun,R.id.userName_pinglun,
			R.id.dongtai_pinglun,R.id.time_pinglun};
	PingLunAdapter adapter;
	List<PingLun> pinglunList;
	
	ImageButton pinglunReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pinglun);
		
		pinglunReturn=(ImageButton)findViewById(R.id.return_pinglun);
		listview=(ListView)findViewById(R.id.pinglun_listview);
		
		getData();
		adapter=new PingLunAdapter(PingLunActivity.this,pinglunList,
				R.layout.pinglun_listview_item,id);
		listview.setAdapter(adapter);
		
		pinglunReturn.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.return_pinglun:
				Intent intent=new Intent(PingLunActivity.this,BottonNavigationActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
		
	};
	public void getData(){
		
		pinglunList=new ArrayList<PingLun>();
		PingLun pinglun=new PingLun();
		pinglun.setOthersImage(R.drawable.praise_friend_head);
		pinglun.setOthersName(getResources().getString(R.string.zuji));
		pinglun.setZipinglun(getResources().getString(R.string.pinglun));
		pinglun.setNide(getResources().getString(R.string.nide));
		pinglun.setHuifu(getResources().getString(R.string.huifu));
		pinglun.setOthersWords(getResources().getString(R.string.pingjia));
		pinglun.setOthersImage(R.drawable.praise_background);
		pinglun.setUserName(getResources().getString(R.string.zushiye));
		pinglun.setUserWords(getResources().getString(R.string.dongtai));
		pinglun.setTime(getResources().getString(R.string.shijian));
		pinglunList.add(pinglun);
		
	}
}
