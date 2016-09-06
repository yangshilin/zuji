package com.example.zuiji.homepage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.example.zuji.R;

public class CameraDongtaiActivity extends Activity{
	ImageView fanhui;
	ImageView zhaopian;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.activity_camera_dongtai);
	fanhui = (ImageView)findViewById(R.id.camera_back);
	zhaopian = (ImageView)findViewById(R.id.camera_addpic);
	
	fanhui.setOnClickListener(l);
	zhaopian.setOnClickListener(l);
	}
	OnClickListener l = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.camera_back:
				Intent fanhui = new Intent(CameraDongtaiActivity.this,CameraActivity.class);
				startActivity(fanhui);
				break;
				/*
				 * 调用系统相册里的图片
				 */
			case R.id.camera_addpic:
				Intent zhaopian = new Intent(Intent.ACTION_GET_CONTENT);
				zhaopian.addCategory(Intent.CATEGORY_OPENABLE);
				zhaopian.setType("image/*");
				zhaopian.putExtra("crop", "true");
				zhaopian.putExtra("outputX", "230");
				zhaopian.putExtra("outputY", "230");
				zhaopian.putExtra("return-data", true);
				startActivityForResult(zhaopian, 1);
				break;
			default:
				break;
			}
			
		}};
}
