package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class GuanYuZuJiActivity extends Activity{
	ImageButton guanyuReturn;
	LinearLayout gongneng,bangzhu,fankui;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.guanyu);
		
		guanyuReturn=(ImageButton)findViewById(R.id.zuji_return);
		gongneng=(LinearLayout)findViewById(R.id.gongneng_guanyu);
		bangzhu=(LinearLayout)findViewById(R.id.bangzhu_guanyu);
		fankui=(LinearLayout)findViewById(R.id.fankui_guanyu);
		
		guanyuReturn.setOnClickListener(onClickListener);
		gongneng.setOnClickListener(onClickListener);
		bangzhu.setOnClickListener(onClickListener);
		fankui.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener=new OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.zuji_return:
				Intent intent=new Intent(GuanYuZuJiActivity.this,SheZhiActivity.class);
				startActivity(intent);
				break;
			case R.id.gongneng_guanyu:
				Intent intent2=new Intent(GuanYuZuJiActivity.this,GongNengJieShaoActivity.class);
				startActivity(intent2);
				break;
			case R.id.bangzhu_guanyu:
				break;
			case R.id.fankui_guanyu:
				Intent intent4=new Intent(GuanYuZuJiActivity.this,YiJianFanKiuActivity.class);
				startActivity(intent4);
				break;
				default:
					break;
			}
		}
	};
}
