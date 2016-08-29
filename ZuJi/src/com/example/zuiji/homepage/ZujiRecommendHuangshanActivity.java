package com.example.zuiji.homepage;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xuAdapterclass.ZujiHuangheAdapter;
import com.example.xuAdapterclass.ZujiHuangshanAdapter;
import com.example.zuji.R;
import com.example.zuji.javaclass.ZujiHuangheSetget;
import com.example.zuji.javaclass.ZujiHuangshan;

public class ZujiRecommendHuangshanActivity extends Activity{
	ImageButton fanhuiBtn;
	EditText ext;
	ImageButton dianzanBtn;
	ImageButton zhuanfaBtn;
	/**
	 * 添加头视图
	 */
	View header;
	TextView zanView;
	TextView pingyuView;
	/**
	 * listview添加数据
	 */
	ListView listview;
	List<ZujiHuangshan> lists;
	ZujiHuangshan hs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
		setContentView(R.layout.activity_zuji_huangshan);
		fanhuiBtn = (ImageButton) findViewById(R.id.zuji_tuijian_fanhuiBtn);
	
		ext = (EditText)findViewById(R.id.zuji_tuijian_edittext);
		dianzanBtn = (ImageButton)findViewById(R.id.zuji_tuijian_xiaoxilan_zan);
		zhuanfaBtn = (ImageButton)findViewById(R.id.zuji_tuijian_xiaoxilan_zhuanfa);
		/**
		 * 头视图 Activity和Fragment有差异
		 * Activity是上文[本文名]【SceneryCommentActivity.this】
		 * Fragment用【getActivity()】方法。
		 */
		header = LayoutInflater.from(ZujiRecommendHuangshanActivity.this).inflate(
				R.layout.activity_zuji_huangshan_header, null);
		/**
		 * 头视图内控件id
		 */
		zanView = (TextView)findViewById(R.id.zuji_tuijian_zan);
		pingyuView = (TextView)findViewById(R.id.zuji_tuijian_pinglun);
		/**
		 * listview数据添加
		 */
		listview = (ListView)findViewById(R.id.ziju_hunagshan_listview);
		listview.addHeaderView(header);// listview添加头视图 少了这一步头视图将不会移动。
		
		fanhuiBtn.setOnClickListener(onclicklistener);
		getDate();
	}

	private void getDate() {
		// TODO Auto-generated method stub
		lists = new ArrayList<ZujiHuangshan>();//数组列表集合参数
		ZujiHuangshan hh = new ZujiHuangshan();//实例化参数对象
		hh.setTouxiang(R.drawable.collect_icon2);
		hh.setName("潇洒哥");
		hh.setTime("36分钟前");
		hh.setContent("好屌的样子");
		lists.add(hh);// 列表添加参数

		for (int i = 0; i < 10; i++) {
			hh = new ZujiHuangshan();// 实例化参数对象
			hh.setTouxiang(R.drawable.logo_7);
			hh.setName("K仔");
			hh.setTime("今天12:25");
			hh.setContent("你去游个泳");
			lists.add(hh);
			
			ZujiHuangshanAdapter hsAdapter = new ZujiHuangshanAdapter(ZujiRecommendHuangshanActivity.this,
					R.layout.actvity_homepage_listview_punglun,lists);
			listview.setAdapter(hsAdapter);//listView设置Adapter
		}
	}
	/**
	 * 页面跳转
	 */
	OnClickListener onclicklistener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.zuji_tuijian_fanhuiBtn:// id执行 //当前上下文//跳转指定的界面
				Intent intent = new Intent(ZujiRecommendHuangshanActivity.this,null);
				startActivity(intent);// start开始 执行Intent意图【跳转】
				break;

			default:
				break;
			}
		}
	};
}