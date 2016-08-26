package com.example.zuiji.homepage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

import com.example.zuji.BottonNavigationActivity;
import com.example.zuji.R;

public class SceneryCommentContentActivity extends Activity {
	ImageButton fanhuiBtn;
	ImageButton guanzhuBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
		setContentView(R.layout.activity_publicpraise_scenery_comment_content);
		fanhuiBtn = (ImageButton) findViewById(R.id.scenery_comment_content_fanhuiBtn);
		guanzhuBtn = (ImageButton)findViewById(R.id.hot_guanzhu);
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
			case R.id.scenery_comment_content_fanhuiBtn:// id执行 //当前上下文//跳转指定的界面
				Intent intent = new Intent(SceneryCommentContentActivity.this,
						BottonNavigationActivity.class);
				startActivity(intent);// start开始 执行Intent意图【跳转】
				break;

			default:
				break;
			}
		}
	};
}
