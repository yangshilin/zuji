package com.example.zuji;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.RadioGroup;

import com.example.xuactivity.Mine_Fragment;

public class MainActivity extends FragmentActivity {
	Mine_Fragment mine_Fragment = new Mine_Fragment();
	RadioGroup centre_RadioGroup;
	FragmentManager fm;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_test);
		fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.test, mine_Fragment);
		ft.commit();
	}
}
