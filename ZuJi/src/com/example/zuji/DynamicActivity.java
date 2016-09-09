package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class DynamicActivity extends Activity {
	ImageView back;
	ImageView addpic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dynamic_edit);
		back = (ImageView) findViewById(R.id.dynamic_back);
		addpic = (ImageView) findViewById(R.id.addpic);
		back.setOnClickListener(clickListener);
		addpic.setOnClickListener(clickListener);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Bitmap bitmap = (Bitmap) data.getExtras().get("data");// 获取相机返回的数据，并转换为Bitmap图片格式

		try {
			addpic.setImageBitmap(bitmap);// 将图片显示在ImageView里
		} catch (Exception e) {
			Log.e("error", e.getMessage());
		}
		super.onActivityResult(requestCode, resultCode, data);

	};

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.dynamic_back:
				startActivity(new Intent(DynamicActivity.this,
						BottonNavigationActivity.class));
				break;
			case R.id.addpic:
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.addCategory(Intent.CATEGORY_OPENABLE);
				intent.setType("image/*");
				intent.putExtra("crop", "true");
				intent.putExtra("outputX", 230);
				intent.putExtra("outputY", 230);
				intent.putExtra("return-data", true);
				startActivityForResult(intent, 1);
				break;
			default:
				break;
			}
		}
	};
}
