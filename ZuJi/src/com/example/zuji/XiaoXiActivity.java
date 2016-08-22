package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class XiaoXiActivity extends Activity{
	ImageButton xiaoxiReturn;
	LinearLayout pinglunText,dianzantext,tongzhitext,tidaotext,zujiText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xiaoxi);
		xiaoxiReturn=(ImageButton)findViewById(R.id.return_xiaoxi);
		pinglunText=(LinearLayout)findViewById(R.id.pinglun_xiaoxi);
		dianzantext=(LinearLayout)findViewById(R.id.dianzan_xiaoxi);
		tongzhitext=(LinearLayout)findViewById(R.id.tongzhi_xiaoxi);
		tidaotext=(LinearLayout)findViewById(R.id.tidao_xiaoxi);
		zujiText=(LinearLayout)findViewById(R.id.zuji_xiaozi);
		
		xiaoxiReturn.setOnClickListener(onClickListener);
		pinglunText.setOnClickListener(onClickListener);
		dianzantext.setOnClickListener(onClickListener);
		tongzhitext.setOnClickListener(onClickListener);
		tidaotext.setOnClickListener(onClickListener);
		zujiText.setOnClickListener(onClickListener);
		
	}
	OnClickListener onClickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.return_xiaoxi:
				Intent intent1= new Intent(XiaoXiActivity.this,PingLunActivity.class);
				startActivity(intent1);
				break;
			case R.id.pinglun_xiaoxi:
				Intent intent2= new Intent(XiaoXiActivity.this,PingLunActivity.class);
				startActivity(intent2);
				break;
			case R.id.dianzan_xiaoxi:
				Intent intent3= new Intent(XiaoXiActivity.this,DianZanActivity.class);
				startActivity(intent3);
				break;
			case R.id.tongzhi_xiaoxi:
				Intent intent4= new Intent(XiaoXiActivity.this,TongZhiActivity.class);
				startActivity(intent4);
				break;
			case R.id.tidao_xiaoxi:
				Intent intent5= new Intent(XiaoXiActivity.this,TiDaoActivity.class);
				startActivity(intent5);
				break;
			case R.id.zuji_xiaozi:
				Intent intent6= new Intent(XiaoXiActivity.this,ZuJiActivity.class);
				startActivity(intent6);
				break;
			default:
				break;
			
			}
		}
		
	};
}
