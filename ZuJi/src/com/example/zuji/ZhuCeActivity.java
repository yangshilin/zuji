package com.example.zuji;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class ZhuCeActivity extends Activity {
	ImageButton zhuceReturn;
	EditText zhanhao, mima, yanzhengma;
	CheckBox checkbox;
	TextView zhuce, fasong;
	String status;
	String message;

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
				String zhanghao_content = zhanhao.getText().toString();
				String mima_content = mima.getText().toString();
				if (zhanghao_content != null && zhanghao_content != ""
						&& mima_content != null && mima_content != "") {
					zhuceZhangHao(zhanghao_content, mima_content);
				} else {
					Toast.makeText(ZhuCeActivity.this, "账号或者密码不能为空", 1).show();
				}
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
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1001:
				Bundle bundle = msg.getData();
				if (message.equals("添加成功")) {
					Toast.makeText(ZhuCeActivity.this, "注册成功！", 0).show();
					Intent intent2 = new Intent(ZhuCeActivity.this,
							DengLuActivity.class);
					startActivity(intent2);
				} else {
					Toast.makeText(ZhuCeActivity.this, message + "，请重新输入用户名！",
							1).show();
					zhanhao.setText("");
					mima.setText("");

				}
				break;
			default:
				break;
			}
		};

	};// 全局handler

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

	public void zhuceZhangHao(String zhanghao, String mima) {
		final String httpHost = "http://192.168.1.175/index.php/home/api/adduser";
		int type = 1;
		try {
			final String param = "usernum="
					+ URLEncoder.encode(zhanghao, "utf-8") + "&password="
					+ URLEncoder.encode(mima, "utf-8");
			new Thread(new Runnable() {
				StringBuilder builder = new StringBuilder();

				@Override
				public void run() {
					try {
						String urlName = httpHost + "?" + param;
						URL url = new URL(urlName);
						HttpURLConnection httpURLConnection = (HttpURLConnection) url
								.openConnection();
						httpURLConnection.setConnectTimeout(5000);
						httpURLConnection.connect();
						if (httpURLConnection.getResponseCode() == 200) {
							InputStream inputStream = httpURLConnection
									.getInputStream();
							// 获取输入流，相应内容
							BufferedReader bufferedReader = new BufferedReader(
									new InputStreamReader(inputStream));
							String line = bufferedReader.readLine();
							while (line != null && line.length() > 0) {
								builder.append(line);
								line = bufferedReader.readLine();
							}
							bufferedReader.close();
							inputStream.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					Log.i("httppost===>Data", builder.toString());
					Message msg = new Message();
					msg.what = 1001;
					Bundle bundle = new Bundle();
					try {
						JSONObject jsonObject = new JSONObject(builder
								.toString());
						status = jsonObject.getString("status").toString();
						message = jsonObject.getString("message").toString();
						bundle.putString("status", status);
						bundle.putString("message", message);
						msg.setData(bundle);
						mHandler.sendMessage(msg);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}).start();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//
	// Handler handler = new Handler() {
	// public void handleMessage(Message msg) {
	// switch (msg.what) {
	// case 1001:
	// Bundle bundle = msg.getData();
	// if (message.equals("login success")) {
	// Toast.makeText(DengLuActivity.this, "登陆成功！", 0).show();
	// Intent intent2 = new Intent(DengLuActivity.this,
	// BottonNavigationActivity.class);
	// startActivity(intent2);
	// } else {
	// if(message.equals("password wrong")){message="密码错误，请重新输入！";}
	// else if(message.equals("usernum not exists")){message="用户名不存在！";}
	// Toast.makeText(DengLuActivity.this, message, 1).show();
	// mima.setText("");
	// }
	// break;
	// case 1002:
	//
	// break;
	//
	// default:
	// break;
	// }
	// };
	//
	// };
}
