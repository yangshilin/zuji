package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class DynamicActivity extends Activity {
	ImageView back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dynamic_edit);
		back=(ImageView) findViewById(R.id.dynamic_back);
		back.setOnClickListener(clickListener);
	}
OnClickListener clickListener=new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dynamic_back:
			break;

		default:
			break;
		}
	}
};
}
