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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DengLuActivity extends Activity {
	ImageButton loginReturn;
	TextView zhuceText, login, wangjimima;
	EditText zhanghao, mima;
	String status = null;
	String message = null;
	String token = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.denglu);

		loginReturn = (ImageButton) findViewById(R.id.denglu_return);
		zhuceText = (TextView) findViewById(R.id.denglu_zhuce);
		login = (TextView) findViewById(R.id.denglu_denglu);
		wangjimima = (TextView) findViewById(R.id.denglu_wangjimima);
		zhanghao = (EditText) findViewById(R.id.denglu_zhanghao);
		mima = (EditText) findViewById(R.id.denglu_mima);

		loginReturn.setOnClickListener(onClickListener);
		zhuceText.setOnClickListener(onClickListener);
		login.setOnClickListener(onClickListener);
		wangjimima.setOnClickListener(onClickListener);
		zhanghao.setOnClickListener(onClickListener);
		mima.setOnClickListener(onClickListener);

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.denglu_return:
				Intent intent = new Intent(DengLuActivity.this,
						YinDaoYeActivity.class);
				startActivity(intent);
				break;
			case R.id.denglu_zhuce:
				Intent intent3 = new Intent(DengLuActivity.this,
						ZhuCeActivity.class);
				startActivity(intent3);
				break;
			case R.id.denglu_denglu:
				String zhanghao_content = zhanghao.getText().toString();
				String mima_content = mima.getText().toString();
				login(zhanghao_content, mima_content);
				
				break;
			case R.id.denglu_wangjimima:
				break;
			case R.id.denglu_zhanghao:
				break;
			case R.id.denglu_mima:
				break;
			default:
				break;
			}
		}
	};

	public void login(String zhanghao, String mima) {
		final String httpHost = "http://192.168.1.175/index.php/home/api/login";

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
						if (message.equals("login success")) {
							token = jsonObject.getString("token").toString();
							bundle.putString("token", token);
						}
						bundle.putString("status", status);
						bundle.putString("message", message);
						msg.setData(bundle);
						handler.sendMessage(msg);
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

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1001:
				Bundle bundle = msg.getData();
				if (message.equals("login success")) {
					Toast.makeText(DengLuActivity.this, "登陆成功！", 0).show();
					Intent intent2 = new Intent(DengLuActivity.this,
							BottonNavigationActivity.class);
					startActivity(intent2);
				} else {
					if (message.equals("password wrong")) {
						message = "密码错误，请重新输入！";
					} else if (message.equals("usernum not exists")) {
						message = "用户名不存在！";
					}
					Toast.makeText(DengLuActivity.this, message, 1).show();
					mima.setText("");
				}
				break;
			case 1002:

				break;

			default:
				break;
			}
		};

	};

	//
	// public public synchronized void httpUrlConn(String httpHost, String
	// param,
	// final int type) {
	// final String newHttpHost = httpHost;
	// final String newParam = param;
	// new Thread(new Runnable() {
	// StringBuilder builder = new StringBuilder();
	//
	// @Override
	// public void run() {
	// try {
	// String urlName = newHttpHost + "?" + newParam;
	// URL url = new URL(urlName);
	// HttpURLConnection httpURLConnection = (HttpURLConnection) url
	// .openConnection();
	// httpURLConnection.setConnectTimeout(5000);
	// httpURLConnection.connect();
	// if (httpURLConnection.getResponseCode() == 200) {
	// InputStream inputStream = httpURLConnection
	// .getInputStream();
	// // 获取输入流，相应内容
	// BufferedReader bufferedReader = new BufferedReader(
	// new InputStreamReader(inputStream));
	// String line = bufferedReader.readLine();
	// while (line != null && line.length() > 0) {
	// builder.append(line);
	// line = bufferedReader.readLine();
	// }
	// bufferedReader.close();
	// inputStream.close();
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// Log.i("httppost===>Data", builder.toString());
	// getJsonData(builder.toString());
	// }
	// }).start();
	// }

	public void getJsonData(String data) {
		try {
			JSONObject jsonObject = new JSONObject(data);
			status = jsonObject.getString("status").toString();
			message = jsonObject.getString("message").toString();
			token = jsonObject.getString("token").toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
