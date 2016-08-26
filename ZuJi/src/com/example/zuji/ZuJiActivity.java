package com.example.zuji;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zuji.adapter.ZuJiAdapter;
import com.example.zuji.javaclass.ZuJi;

public class ZuJiActivity extends Activity {
	private TextView fasongText = null;
	private EditText zujiEditText = null;
	private ListView zujiListView = null;
	private List<ZuJi> zujiList = null;
	private ZuJiAdapter zujiAdapter = null;
	ImageButton zujiReturn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.zuji);

		zujiEditText = (EditText) this.findViewById(R.id.zuji_edittext);
		fasongText = (TextView) this.findViewById(R.id.zuji_fasong);
		zujiReturn = (ImageButton) this.findViewById(R.id.zuji_return);

		zujiListView = (ListView) this.findViewById(R.id.duihua_listview);

		zujiList = new ArrayList<ZuJi>();
		ZuJi zuji = null;
		for (int i = 0; i < 2; i++) {
			zuji = new ZuJi();
			if (i % 2 == 0) {
				zuji.setComeMsg(false);
				zuji.setContent("Hello");
				zuji.setZujitime("2012-09-20 15:12:32");
			} else {
				zuji.setComeMsg(true);
				zuji.setContent("Hello,nice to meet you!");
				zuji.setZujitime("2012-09-20 15:13:32");
			}
			zujiList.add(zuji);
		}

		zujiAdapter = new ZuJiAdapter(this, zujiList);
		zujiListView.setAdapter(zujiAdapter);

		fasongText.setOnClickListener(onClickListener);
		zujiReturn.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case R.id.zuji_fasong:
				if (!zujiEditText.getText().toString().equals("")) {
					// 发送消息
					send();
				} else {
					Toast.makeText(ZuJiActivity.this, "Content is empty",
							Toast.LENGTH_SHORT).show();
				}

				break;
			case R.id.zuji_return:
					Intent intent=new Intent(ZuJiActivity.this,Fragment_XiaoXi.class);
					startActivity(intent);
				break;
			default:
				break;
			}

		}
	};

	private void send() {
		ZuJi zuji = new ZuJi();
		zuji.setZujitime("2012-09-20 15:16:34");
		zuji.setContent(zujiEditText.getText().toString());
		zuji.setComeMsg(false);
		zujiList.add(zuji);
		zujiAdapter.notifyDataSetChanged();
		zujiListView.setSelection(zujiList.size() - 1);
		zujiEditText.setText("");
	}

}