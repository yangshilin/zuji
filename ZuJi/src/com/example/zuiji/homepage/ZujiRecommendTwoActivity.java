package com.example.zuiji.homepage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zuji.R;

public class ZujiRecommendTwoActivity extends Activity{
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
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
		setContentView(R.layout.activity_zuji_recommend_two);
		fanhuiBtn = (ImageButton) findViewById(R.id.zuji_tuijian_fanhuiBtn);
		zanView = (TextView)findViewById(R.id.zuji_tuijian_zan);
		pingyuView = (TextView)findViewById(R.id.zuji_tuijian_pinglun);
		ext = (EditText)findViewById(R.id.zuji_tuijian_edittext);
		dianzanBtn = (ImageButton)findViewById(R.id.zuji_tuijian_xiaoxilan_zan);
		zhuanfaBtn = (ImageButton)findViewById(R.id.zuji_tuijian_xiaoxilan_zhuanfa);
		fanhuiBtn.setOnClickListener(onclicklistener);
	}

	OnClickListener onclicklistener = new OnClickListener() {
		/**
		 * 页面跳转
		 */
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.zuji_tuijian_fanhuiBtn:// id执行 //当前上下文//跳转指定的界面
				Intent intent = new Intent(ZujiRecommendTwoActivity.this,null);
				startActivity(intent);// start开始 执行Intent意图【跳转】
				break;

			default:
				break;
			}
		}
	};
}