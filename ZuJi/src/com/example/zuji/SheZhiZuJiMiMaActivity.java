package com.example.zuji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SheZhiZuJiMiMaActivity extends Activity{
	ImageButton mimaReturn;
	EditText zhanghao,mima,qurenmima;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.shezhimima);
		
		mimaReturn=(ImageButton)findViewById(R.id.mima_return);
		zhanghao=(EditText)findViewById(R.id.zhaohao_mima);
		mima=(EditText)findViewById(R.id.mima_mima);
		qurenmima=(EditText)findViewById(R.id.quren_mima);
		
		mimaReturn.setOnClickListener(onClickListener);
		zhanghao.setOnClickListener(onClickListener);
		mima.setOnClickListener(onClickListener);
		qurenmima.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.mima_return:
				Intent intent =new Intent(SheZhiZuJiMiMaActivity.this,SheZhiActivity.class);
				startActivity(intent);
				break;
			case R.id.zhaohao_mima:
				break;
			case R.id.mima_mima:
				break;
			case R.id.quren_mima:
				Toast.makeText(SheZhiZuJiMiMaActivity.this, "去人密码", Toast.LENGTH_LONG).show();
				break;
				default:
					break;
			
			}
		}
	};
}
