package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class TongZhiActivity extends Activity{
	ImageButton tongzhiReturn;
	ImageView addbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tongzhi);
		
		tongzhiReturn=(ImageButton)findViewById(R.id.return_tongzhi);
		addbtn=(ImageView)findViewById(R.id.add_tongzhi);
		
		tongzhiReturn.setOnClickListener(onClickListener);
		addbtn.setOnClickListener(onClickListener);
			
	}
	OnClickListener onClickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.return_tongzhi:
				Intent intent =new Intent(TongZhiActivity.this,XiaoXiActivity.class);
				startActivity(intent);
				break;
			case R.id.add_tongzhi:
				break;
			default:
				break;
			}
		}
		
	};
}
