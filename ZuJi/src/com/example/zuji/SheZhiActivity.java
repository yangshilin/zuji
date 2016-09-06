package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SheZhiActivity extends Activity{
	
	ImageButton shizhiReturn;
	TextView tuichu;
	CheckBox weizhibtn,shoucangbtn;
	LinearLayout ziliao,guangli,huancun,guanyu,gengxing,yijian;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.shezhi);
		
		shizhiReturn=(ImageButton)findViewById(R.id.zhezhi_return);
		weizhibtn=(CheckBox)findViewById(R.id.weizhi_shezhi);
		shoucangbtn=(CheckBox)findViewById(R.id.shouchang_shezhi);
		ziliao=(LinearLayout)findViewById(R.id.ziliao_linear);
		guangli=(LinearLayout)findViewById(R.id.guanli_linear);
		huancun=(LinearLayout)findViewById(R.id.fancun_linear);
		guanyu=(LinearLayout)findViewById(R.id.guanyu_linear);
		gengxing=(LinearLayout)findViewById(R.id.gengxin_linear);
		yijian=(LinearLayout)findViewById(R.id.fankiu_linear);
		tuichu=(TextView)findViewById(R.id.tuichu_shezhi);
		
		shizhiReturn.setOnClickListener(onClickListener);
		weizhibtn.setOnClickListener(onClickListener);
		shoucangbtn.setOnClickListener(onClickListener);
		ziliao.setOnClickListener(onClickListener);
		guangli.setOnClickListener(onClickListener);
		huancun.setOnClickListener(onClickListener);
		guanyu.setOnClickListener(onClickListener);
		gengxing.setOnClickListener(onClickListener);
		yijian.setOnClickListener(onClickListener);
		tuichu.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener=new OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.zhezhi_return:
				Intent intent1=new Intent(SheZhiActivity.this,BottonNavigationActivity.class);
				startActivity(intent1);
				break;
			case R.id.weizhi_shezhi:
				
				break;
			case R.id.shouchang_shezhi:
				
				break;
			case R.id.ziliao_linear:
				Intent intent2=new Intent(SheZhiActivity.this,GeRenZiLiaoActivity.class);
				startActivity(intent2);
				break;
			case R.id.guanli_linear:
				Intent intent3=new Intent(SheZhiActivity.this,SheZhiZuJiMiMaActivity.class);
				startActivity(intent3);
				break;
			case R.id.fancun_linear:
				Intent intent4=new Intent(SheZhiActivity.this,BottonNavigationActivity.class);
				startActivity(intent4);
				break;
			case R.id.guanyu_linear:
				Intent intent5=new Intent(SheZhiActivity.this,GuanYuZuJiActivity.class);
				startActivity(intent5);
				break;
			case R.id.gengxin_linear:
				
				break;
			case R.id.fankiu_linear:
				Intent intent7=new Intent(SheZhiActivity.this,YiJianFanKiuActivity.class);
				startActivity(intent7);
			case R.id.tuichu_shezhi:
				Intent intent8=new Intent(SheZhiActivity.this,DengLuActivity.class);
				startActivity(intent8);
				break;
			default:
				break;
			}
		}
	};
}
