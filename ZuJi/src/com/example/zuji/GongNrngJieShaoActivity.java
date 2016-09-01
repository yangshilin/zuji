package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class GongNrngJieShaoActivity extends Activity{
	ImageButton jieshaoReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gerentouxiang_gridview);
		jieshaoReturn=(ImageButton)findViewById(R.id.gerenziliao_aihao);
		jieshaoReturn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.gengxin_linear){
					Intent intent=new Intent(GongNrngJieShaoActivity.this,GuanYuZuJiActivity.class);
					startActivity(intent);
				}
			}
		});
	}
}
