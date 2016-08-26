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

import com.example.zuji.adapter.TiDaoNiDaAdapter;
import com.example.zuji.javaclass.TiDaoNiDe;

public class TiDaoActivity extends Activity{
	TiDaoNiDaAdapter adapter;
	List<TiDaoNiDe> tidaonideList;
	int[] id={R.id.tidao_otherImage,R.id.tidao_otherName,R.id.tidao_tidao,R.id.tidao_ni,
			R.id.tidao_ait,R.id.tidao_otherWords,R.id.tidao_userImage,R.id.tidao_userName,
			R.id.tidao_userWords,R.id.tidao_time};
	
	ListView listview;
	ImageButton tidaoReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tidaonide);
		
		tidaoReturn=(ImageButton)findViewById(R.id.return_tidao);
		listview=(ListView)findViewById(R.id.tidaoyou_listview);
		
		getData();
		adapter=new TiDaoNiDaAdapter(TiDaoActivity.this,tidaonideList,
				R.layout.tidaonide_listview_item,id);
		listview.setAdapter(adapter);
		
		tidaoReturn.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener=new OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.return_tidao:
				Intent intent=new Intent(TiDaoActivity.this,Fragment_XiaoXi.class);
				startActivity(intent);
				break;
			default:
				break;
			}	
		}
	};
	public void getData(){
		tidaonideList=new ArrayList<TiDaoNiDe>();
		TiDaoNiDe tidaonide=new TiDaoNiDe();
		tidaonide.setOthersImage(R.drawable.praise_friend_head);
		tidaonide.setOthersName(getResources().getString(R.string.zuji));
		tidaonide.setTidao(getResources().getString(R.string.tidaole));
		tidaonide.setNi(getResources().getString(R.string.ni));
		tidaonide.setAit("@Krystal:");
		tidaonide.setOthersWords(getResources().getString(R.string.dui));
		tidaonide.setUserImage(R.drawable.praise_background);
		tidaonide.setUserName(getResources().getString(R.string.zushiye));
		tidaonide.setUserWords(getResources().getString(R.string.dongtai));
		tidaonide.setTime(getResources().getString(R.string.shijian));
		tidaonideList.add(tidaonide);
		
		
		 tidaonide=new TiDaoNiDe();
		tidaonide.setOthersImage(R.drawable.praise_friend_head);
		tidaonide.setOthersName(getResources().getString(R.string.zuji));
		tidaonide.setTidao(getResources().getString(R.string.tidaole));
		tidaonide.setNi(getResources().getString(R.string.ni));
		tidaonide.setAit("@Krystal:");
		tidaonide.setOthersWords(getResources().getString(R.string.dui));
		tidaonide.setUserImage(R.drawable.praise_background);
		tidaonide.setUserName(getResources().getString(R.string.zushiye));
		tidaonide.setUserWords(getResources().getString(R.string.dongtai));
		tidaonide.setTime(getResources().getString(R.string.shijian));
		tidaonideList.add(tidaonide);
	}
}
