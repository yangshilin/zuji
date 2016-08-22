package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class TiDaoActivity extends Activity{
	ImageButton tidaoReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tidaonide);
		
		tidaoReturn=(ImageButton)findViewById(R.id.return_tidao);
	
		tidaoReturn.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener=new OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.return_tidao:
				Intent intent=new Intent(TiDaoActivity.this,XiaoXiActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}	
		}
	};
}
