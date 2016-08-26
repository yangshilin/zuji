package com.example.xuactivity;

import com.example.zuji.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class Timeinthepast_activity extends Activity implements OnClickListener{
	
	ImageButton imbtfh;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.time_inthepast);
		imbtfh=(ImageButton) findViewById(R.id.imbtfh);
		imbtfh.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if (v.getId()==R.id.imbtfh) {
			startActivity(new Intent(Timeinthepast_activity.this,TimefusiondeletesActivity.class));
		}
		
	}

}
