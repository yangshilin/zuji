package com.example.xuactivity;

import com.example.zuji.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Timeinthepast_activity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.time_inthepast);
	}

}
