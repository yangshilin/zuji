package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class YiJianFanKiuActivity extends Activity{
	ImageButton fankuiReturn,addImage;
	TextView guanbiText,tijiaoText;
	EditText yijianEdit,phoneEdit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yijianfankiu);
		
		fankuiReturn=(ImageButton)findViewById(R.id.return_fankui);
		addImage=(ImageButton)findViewById(R.id.addimage_fankui);
		guanbiText=(TextView)findViewById(R.id.guanbi_fankui);
		tijiaoText=(TextView)findViewById(R.id.tijiao_fankui);
		yijianEdit=(EditText)findViewById(R.id.edittext_fankui);
		phoneEdit=(EditText)findViewById(R.id.phone_fankui);
		
		
		fankuiReturn.setOnClickListener(onClickListener);
		addImage.setOnClickListener(onClickListener);
		guanbiText.setOnClickListener(onClickListener);
		tijiaoText.setOnClickListener(onClickListener);
		yijianEdit.setOnClickListener(onClickListener);
		phoneEdit.setOnClickListener(onClickListener);
		
	}
		OnClickListener onClickListener=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()){
				case R.id.return_fankui:
					Intent intent=new Intent(YiJianFanKiuActivity.this,SheZhiActivity.class);
					startActivity(intent);
					break;
				case R.id.addimage_fankui:
					break;
				case R.id.guanbi_fankui:
					Intent intent2=new Intent(YiJianFanKiuActivity.this,SheZhiActivity.class);
					startActivity(intent2);
					break;
				case R.id.tijiao_fankui:
					break;
				case R.id.edittext_fankui:
					break;
				case R.id.phone_fankui:
					break;
					default:
					break;
				}
			}
		};
}
