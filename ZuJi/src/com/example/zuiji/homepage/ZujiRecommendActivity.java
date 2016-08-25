package com.example.zuiji.homepage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zuji.R;

public class ZujiRecommendActivity extends Activity{
	ImageButton fanhuiBtn;
	TextView zanView;
	TextView pingyuView;
	EditText ext;
	ImageButton dianzanBtn;
	ImageButton zhuanfaBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);//运行时去掉代码顶部拦
	setContentView(R.layout.activity_zuji_recommend);
	fanhuiBtn= (ImageButton)findViewById(R.id.zuji_recommend_fanhuiBtn);
	zanView = (TextView)findViewById(R.id.zuji_recommend_zan);
	pingyuView = (TextView)findViewById(R.id.zuji_recommend_pinglun);
	ext = (EditText)findViewById(R.id.zuji_recommend_edittext);
	dianzanBtn = (ImageButton)findViewById(R.id.zuji_recommend_xiaoxilan_zan);
	zhuanfaBtn = (ImageButton)findViewById(R.id.zuji_recommend_xiaoxilan_zhuanfa);
	fanhuiBtn.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.zuji_recommend_fanhuiBtn:// id执行 //当前上下文//跳转指定的界面
				Intent intent = new Intent(ZujiRecommendActivity.this,null);
				startActivity(intent);// start开始 执行Intent意图【跳转】
				
				break;

			default:
				break;
			}
		}
		
	};
}
