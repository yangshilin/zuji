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

public class HomepageZuji extends Activity {
	ImageButton fanhui_btn;
	ImageButton fenxiang_btn;
	ImageButton dianzan_btn;
	TextView pinglun_btn;
	EditText pingyu;
	ImageButton biaoqing;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
		setContentView(R.layout.activity_homepage_zuji);
		fanhui_btn = (ImageButton) findViewById(R.id.homepage_zuju_fanhuiBtn);
		fenxiang_btn = (ImageButton) findViewById(R.id.homepage_zuju_fenxiangBtn);
		dianzan_btn = (ImageButton) findViewById(R.id.shouye_zuju_hongxin);
		pinglun_btn = (TextView) findViewById(R.id.homepage_zuju_pinglun);
		pingyu = (EditText) findViewById(R.id.homepage_zuju_edittext);
		biaoqing = (ImageButton) findViewById(R.id.homepage_zuju_biaoqing);
		/**
		 * 页面跳转
		 */
		fanhui_btn.setOnClickListener(onclicklistener);
		fenxiang_btn.setOnClickListener(onclicklistener);
	}

	OnClickListener onclicklistener = new OnClickListener() {
		/**
		 * 页面跳转
		 */
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.homepage_zuju_fanhuiBtn:// id执行 //当前上下文//跳转指定的界面
				Intent fanhui = new Intent(HomepageZuji.this, null);
				startActivity(fanhui);// start开始 执行Intent意图【跳转】
				break;
			case R.id.homepage_zuju_fenxiangBtn:
				Intent fenxiang = new Intent(HomepageZuji.this, null);
				startActivity(fenxiang);
				break;

			default:
				break;
			}
		}

	};

}
