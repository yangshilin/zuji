package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class DianZanActivity extends Activity{
	ImageButton dianzanReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dianzan);
		dianzanReturn=(ImageButton)findViewById(R.id.return_dianzan);
		dianzanReturn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()){
				case R.id.return_dianzan:
					Intent intent=new Intent(DianZanActivity.this,XiaoXiActivity.class);
					startActivity(intent);
					break;
				default:
					break;
				}
			}
			
		});
	}
	
}
