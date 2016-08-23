package com.example.zuji;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity {
	LinearLayout linearlayout;
	FragmentManager fm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		linearlayout = (LinearLayout) findViewById(R.id.mainlinearlayout);
		fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		SheQu_Fragment sheQu_Fragment = new SheQu_Fragment();
		ft.replace(R.id.mainlinearlayout, sheQu_Fragment);
		ft.commit();
	}
}
