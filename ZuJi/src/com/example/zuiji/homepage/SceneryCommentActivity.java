package com.example.zuiji.homepage;

import com.example.zuji.BottonNavigationActivity;
import com.example.zuji.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class SceneryCommentActivity extends Activity{
	ImageButton fanhuiBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
	setContentView(R.layout.activity_publicpraise_scenery_comment);
	fanhuiBtn= (ImageButton)findViewById(R.id.scenery_comment_fanhuiBtn);
	fanhuiBtn.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.scenery_comment_fanhuiBtn:// id执行 //当前上下文//跳转指定的界面
				Intent intent = new Intent(SceneryCommentActivity.this,BottonNavigationActivity.class);
				startActivity(intent);// start开始 执行Intent意图【跳转】
				break;

			default:
				break;
			}
		}
		
	};
}
