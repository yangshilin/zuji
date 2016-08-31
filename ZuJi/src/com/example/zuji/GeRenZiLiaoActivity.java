package com.example.zuji;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GeRenZiLiaoActivity extends Activity {
	ImageButton gerenzilaoReturn;
	EditText  nichengText,chengshiText,
			nianlingText,aihaoText, qianmingText;
	TextView xingbieText, baocun;
	String[] str = { "男", "女" };
	LinearLayout touxiangImage,xingbie;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gerenzhiliao);

		gerenzilaoReturn = (ImageButton) findViewById(R.id.gerenziliao_return);
		baocun = (TextView) findViewById(R.id.gerenziliao_baocun);
		touxiangImage = (LinearLayout) findViewById(R.id.gerenziliao_touxiang);
		nichengText=(EditText)findViewById(R.id.gerenziliao_nicheng);
		xingbie = (LinearLayout) findViewById(R.id.gerenziliao_xingbie);
		xingbieText=(TextView)findViewById(R.id.gerenziliao_xingbie1);
		chengshiText = (EditText) findViewById(R.id.gerenziliao_chengshi);
		nianlingText = (EditText) findViewById(R.id.gerenziliao_nianling);
		aihaoText = (EditText) findViewById(R.id.gerenziliao_aihao);
		qianmingText = (EditText) findViewById(R.id.gerenziliao_gexingqianming);

		gerenzilaoReturn.setOnClickListener(onClickListener);
		baocun.setOnClickListener(onClickListener);
		touxiangImage.setOnClickListener(onClickListener);
		xingbie.setOnClickListener(onClickListener);
		nichengText.setOnClickListener(onClickListener);
		chengshiText.setOnClickListener(onClickListener);
		nianlingText.setOnClickListener(onClickListener);
		aihaoText.setOnClickListener(onClickListener);
		qianmingText.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.gerenziliao_baocun:
				Intent intent3 = new Intent(GeRenZiLiaoActivity.this,
						SheZhiActivity.class);
				startActivity(intent3);
				break;
			case R.id.gerenziliao_return:
				Intent intent = new Intent(GeRenZiLiaoActivity.this,
						SheZhiActivity.class);
				startActivity(intent);
				break;
			case R.id.gerenziliao_touxiang:
				Intent intent2 = new Intent(GeRenZiLiaoActivity.this,
						GeRenTouXiangActivity.class);
				startActivity(intent2);
				break;
			case R.id.gerenziliao_xingbie:
				new AlertDialog.Builder(GeRenZiLiaoActivity.this)
						.setTitle("请选择性别")
						.setItems(str, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								switch (which) {
								case 0:
									xingbieText.setText(str[0]);
									break;
								case 1:
									xingbieText.setText(str[1]);
									break;
								}
							}
						}).show();
				break;
			case R.id.gerenziliao_nicheng:
				nichengText.setText("");
				break;
			case R.id.gerenziliao_chengshi:
				chengshiText.setText("");
				break;
			case R.id.gerenziliao_nianling:
				nianlingText.setText("");
				break;
			case R.id.gerenziliao_aihao:
				aihaoText.setText("");
				break;
			case R.id.gerenziliao_gexingqianming:
				qianmingText.setText("");
				break;
			default:
				break;
			}
		}
	};
}
