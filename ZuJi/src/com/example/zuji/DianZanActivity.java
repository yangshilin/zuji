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

import com.example.zuji.adapter.DianZanAdapter;
import com.example.zuji.javaclass.DianZan;


public class DianZanActivity extends Activity{
	ListView listview;
	DianZanAdapter adapter;
	List<DianZan>  dianzanList;
	int[] id={R.id.dianzan_otherImage,R.id.dianzan_otherName,
			R.id.dianzan_zanle,R.id.dianzan_nide,R.id.dianzan_userImage,
			R.id.dianzan_userName,R.id.dianzan_dongtai,R.id.dianzan_time};
	ImageButton dianzanReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dianzan);
		dianzanReturn=(ImageButton)findViewById(R.id.return_dianzan);
		listview=(ListView)findViewById(R.id.dianzan_listview);
		getData();
		adapter=new DianZanAdapter(DianZanActivity.this,dianzanList,
				R.layout.dianzan_listview_item,id);
		listview.setAdapter(adapter);
		dianzanReturn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()){
				case R.id.return_dianzan:
					Intent intent=new Intent(DianZanActivity.this,BottonNavigationActivity.class);
					startActivity(intent);
					break;
				default:
					break;
				}
			}
			
		});
	}
public void getData(){
	dianzanList=new ArrayList<DianZan>();
	DianZan dianzan=new DianZan();
	dianzan.setOthersImage(R.drawable.praise_friend_head);
	dianzan.setOthersName(getResources().getString(R.string.zuji));
	dianzan.setZanle(getResources().getString(R.string.zan));
	dianzan.setNide(getResources().getString(R.string.nide));
	dianzan.setUserImage(R.drawable.praise_background);
	dianzan.setUserName(getResources().getString(R.string.zushiye));
	dianzan.setUserWords(getResources().getString(R.string.dongtai));
	dianzan.setTime(getResources().getString(R.string.shijian));
	dianzanList.add(dianzan);
		
		
	}
}
