package com.example.zuji;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class ZhuCeActivity extends Activity {
	ImageButton zhuceReturn;
	EditText zhanhao, mima, yanzhengma;
	CheckBox checkbox;
	TextView zhuce, fasong;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.zhuce);
		
		zhuceReturn = (ImageButton) findViewById(R.id.zhuce_return);
		zhanhao = (EditText) findViewById(R.id.zhece_zhanghao);
		mima = (EditText) findViewById(R.id.zhuce_mima);
		yanzhengma = (EditText) findViewById(R.id.zhuce_yanzhengma);
		checkbox = (CheckBox) findViewById(R.id.zhuce_checkbox);
		zhuce = (TextView) findViewById(R.id.zhuce_zhuce);
		fasong = (TextView) findViewById(R.id.zhuce_fasong);

		zhuceReturn.setOnClickListener(onClickListener);
		zhanhao.setOnClickListener(onClickListener);
		mima.setOnClickListener(onClickListener);
		yanzhengma.setOnClickListener(onClickListener);
		checkbox.setOnClickListener(onClickListener);
		zhuce.setOnClickListener(onClickListener);
		fasong.setOnClickListener(onClickListener);
		
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View V) {
			// TODO Auto-generated method stub
			switch (V.getId()) {
			case R.id.zhuce_return:
				Intent intent = new Intent(ZhuCeActivity.this,
						DengLuActivity.class);
				startActivity(intent);
				break;
			case R.id.zhece_zhanghao:
				break;
			case R.id.zhuce_mima:
				break;
			case R.id.zhuce_yanzhengma:
				break;
			case R.id.zhuce_checkbox:
				if (checkbox.isChecked()) {
					mima.setInputType(EditorInfo.TYPE_CLASS_TEXT
							| EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
				} else {
					mima.setInputType(EditorInfo.TYPE_CLASS_TEXT
							| EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD);
				}
				break;
			case R.id.zhuce_zhuce:
				Toast.makeText(ZhuCeActivity.this, "已注册成功", Toast.LENGTH_SHORT)
						.show();
				break;
			case R.id.zhuce_fasong:
				showTime();
				break;
			default:
				break;

			}
		}
	};
	int i = 60;
	private Handler mHandler = new Handler();// 全局handler

	public void showTime() {
		new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				while (i > 0) {// 整个倒计时执行的循环
					i--;
					mHandler.post(new Runnable() {// 通过它在UI主线程中修改显示的剩余时间
						@Override
						public void run() {
							// TODO Auto-generated method stub
							fasong.setText(i + "(S)");// 显示剩余时间
						}
					});
					try {
						Thread.sleep(1000);// 线程休眠一秒钟 这个就是倒计时的间隔时间
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// 下面是倒计时结束逻辑
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						fasong.setText("重新发送");// 一轮倒计时结束,看用户是否需要重新发送验证码
					}
				});
			}

		}).start();
	}
}
