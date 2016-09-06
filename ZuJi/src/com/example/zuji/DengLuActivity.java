package com.example.zuji;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class DengLuActivity extends Activity {
	ImageButton loginReturn;
	TextView zhuceText,login,wangjimima;
	EditText zhanghao,mima;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.denglu);
		
		loginReturn=(ImageButton)findViewById(R.id.denglu_return);
		zhuceText=(TextView)findViewById(R.id.denglu_zhuce);
		login=(TextView)findViewById(R.id.denglu_denglu);
		wangjimima=(TextView)findViewById(R.id.denglu_wangjimima);
		zhanghao=(EditText)findViewById(R.id.denglu_zhanghao);
		mima=(EditText)findViewById(R.id.denglu_mima);
		
		
		loginReturn.setOnClickListener(onClickListener);
		zhuceText.setOnClickListener(onClickListener);
		login.setOnClickListener(onClickListener);
		wangjimima.setOnClickListener(onClickListener);
		zhanghao.setOnClickListener(onClickListener);
		mima.setOnClickListener(onClickListener);
		
	}
	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.denglu_return:
				Intent intent=new Intent(DengLuActivity.this,YinDaoYeActivity.class);
				startActivity(intent);
				break;
			case R.id.denglu_zhuce:
				Intent intent3=new Intent(DengLuActivity.this,ZhuCeActivity.class);
				startActivity(intent3);
				break;
			case R.id.denglu_denglu:
				Intent intent2=new Intent(DengLuActivity.this,BottonNavigationActivity.class);
				startActivity(intent2);
				break;
			case R.id.denglu_wangjimima:
				break;
			case R.id.denglu_zhanghao:
				break;
			case R.id.denglu_mima:
				break;
				default:
					break;
			}
		}
	};
}
