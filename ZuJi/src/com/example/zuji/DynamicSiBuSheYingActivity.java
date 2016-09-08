package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class DynamicSiBuSheYingActivity extends Activity {
	ImageView sheying_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dynamic_sibusheying);
		sheying_back = (ImageView) findViewById(R.id.sheying_back);
		sheying_back.setOnClickListener(clickListener);
	}

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.sheying_back:
				startActivity(new Intent(DynamicSiBuSheYingActivity.this,
						BottonNavigationActivity.class));
				break;

			default:
				break;
			}
		}
	};
}
