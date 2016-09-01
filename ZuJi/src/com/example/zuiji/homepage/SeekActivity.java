package com.example.zuiji.homepage;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zuji.BottonNavigationActivity;
import com.example.zuji.R;

public class SeekActivity extends Activity{
	EditText editText;
	ImageButton sousu;
	TextView quxiao;
	TextView diming_tishi_1;
	TextView diming_tishi_2;
	TextView diming_tishi_3;
	TextView diming_tishi_4;
	TextView diming_tishi_5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
	setContentView(R.layout.activity_travel_seek);
	editText = (EditText)findViewById(R.id.seek_edittext);
	sousu = (ImageButton)findViewById(R.id.seek_edittext_btn);
	quxiao = (TextView)findViewById(R.id.seek_quxiao_btn);
	diming_tishi_1 = (TextView)findViewById(R.id.see_tuijian_didian);
	diming_tishi_2 = (TextView)findViewById(R.id.see_tuijian_didian_two);
	diming_tishi_3 = (TextView)findViewById(R.id.see_tuijian_didian_three);
	diming_tishi_4 = (TextView)findViewById(R.id.see_tuijian_didian_frou);
	diming_tishi_5 = (TextView)findViewById(R.id.see_tuijian_didian_five);
	
	quxiao.setOnClickListener(l);
	}
	OnClickListener l = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.seek_quxiao_btn:
				Intent quxiao = new Intent(SeekActivity.this,BottonNavigationActivity.class);
				startActivity(quxiao);
				break;

			default:
				break;
			}
		}
		};
	

}
