package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class PingLunActivity extends Activity{
	ImageButton pinglunReturn;
	TextView huifu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		pinglunReturn=(ImageButton)findViewById(R.id.return_pinglun);
		huifu=(TextView)findViewById(R.id.huifu);
		
		
		pinglunReturn.setOnClickListener(onClickListener);
		huifu.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.return_pinglun:
				Intent intent=new Intent(PingLunActivity.this,XiaoXiActivity.class);
				startActivity(intent);
				break;
			case R.id.huifu:
				break;
			default:
				break;
			}
		}
		
	};
}
