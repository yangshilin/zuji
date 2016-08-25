package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SheZhiActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shezhi);
	}
	/*ImageButton shizhiReturn;
	ImageView weizhibtn,shoucangbtn;
	LinearLayout ziliao,guangli,huancun,guanyu,gengxing,yijian;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.shezhi);
		
		shizhiReturn=(ImageButton)findViewById(R.id.zhezhi_return);
		weizhibtn=(ImageView)findViewById(R.id.weishi_shezhi);
		shoucangbtn=(ImageView)findViewById(R.id.shouchang_shezhi);
		ziliao=(LinearLayout)findViewById(R.id.ziliao_linear);
		guangli=(LinearLayout)findViewById(R.id.guanli_linear);
		huancun=(LinearLayout)findViewById(R.id.fancun_linear);
		guanyu=(LinearLayout)findViewById(R.id.guanyu_linear);
		gengxing=(LinearLayout)findViewById(R.id.gengxin_linear);
		yijian=(LinearLayout)findViewById(R.id.fankiu_linear);
		
		
		shizhiReturn.setOnClickListener(onClickListener);
		weizhibtn.setOnClickListener(onClickListener);
		shoucangbtn.setOnClickListener(onClickListener);
		ziliao.setOnClickListener(onClickListener);
		guangli.setOnClickListener(onClickListener);
		huancun.setOnClickListener(onClickListener);
		guanyu.setOnClickListener(onClickListener);
		gengxing.setOnClickListener(onClickListener);
		yijian.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener=new OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.zhezhi_return:
				break;
			case R.id.weishi_shezhi:
				break;
			case R.id.shouchang_shezhi:
				break;
			case R.id.ziliao_linear:
				break;
			case R.id.guanli_linear:
				break;
			case R.id.fancun_linear:
				break;
			case R.id.guanyu_linear:
				Intent intent=new Intent(SheZhiActivity.this,GuanYuZuJiActivity.class);
				startActivity(intent);
				break;
			case R.id.gengxin_linear:
				break;
			case R.id.fankiu_linear:
				break;
			}
		}
	};*/
}
