package com.example.zuiji.homepage;

import com.example.zuji.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class HotPhotoalbumActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
	setContentView(R.layout.actvity_hot_photoalbum);
	}

}
