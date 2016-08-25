package com.example.zuiji.homepage;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zuji.R;

public class seekActivity extends Activity{
	EditText editText;
	ImageButton sousu;
	TextView quxiao;
	TextView diming_tishi_1;
	TextView diming_tishi_2;
	TextView diming_tishi_3;
	TextView diming_tishi_4;
	TextView diming_tishi_5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
	setContentView(R.layout.activity_travel_seek);
	editText = (EditText)findViewById(R.id.seek_edittext);
	sousu = (ImageButton)findViewById(R.id.seek_edittext_btn);
	quxiao = (TextView)findViewById(R.id.seek_quxiao_btn);
	diming_tishi_1 = (TextView)findViewById(R.id.see_tuijian_didian);
	diming_tishi_2 = (TextView)findViewById(R.id.see_tuijian_didian_two);
	diming_tishi_3 = (TextView)findViewById(R.id.see_tuijian_didian_three);
	diming_tishi_4 = (TextView)findViewById(R.id.see_tuijian_didian_frou);
	diming_tishi_5 = (TextView)findViewById(R.id.see_tuijian_didian_five);
	}

}
