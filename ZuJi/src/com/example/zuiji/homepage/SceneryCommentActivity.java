package com.example.zuiji.homepage;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xuAdapterclass.SceneryCommentAdapter;
import com.example.zuji.BottonNavigationActivity;
import com.example.zuji.R;
import com.example.zuji.javaclass.SceneryCommentSetget;

public class SceneryCommentActivity extends Activity {
	ImageButton fanhuiBtn;
	/**
	 * 添加头视图
	 */
	View header;
	ImageView touxiang;
	TextView name;
	ImageButton shizhong;
	TextView riqi;
	TextView shijian;
	TextView pingyu;
	TextView zan;
	/**
	 * listview添加数据
	 */
	ListView listview;
	List<SceneryCommentSetget> lists;
	SceneryCommentSetget scs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
		setContentView(R.layout.activity_publicpraise_scenery_comment);
		fanhuiBtn = (ImageButton) findViewById(R.id.scenery_comment_fanhuiBtn);
		/**
		 * 头视图 Activity和Fragment有差异
		 * Activity是上文[本文名]【SceneryCommentActivity.this】
		 * Fragment用【getActivity()】方法。
		 */
		header = LayoutInflater.from(SceneryCommentActivity.this).inflate(
				R.layout.activity_scenery_comment_header_two, null);
		/**
		 * 头视图内控件
		 */
		touxiang = (ImageView) header.findViewById(R.id.scenery_comment_fabutouxiang);
		name = (TextView) header.findViewById(R.id.scenery_comment_user_name);
		shizhong = (ImageButton) header.findViewById(R.id.clock_icon);
		riqi = (TextView) header.findViewById(R.id.scenery_comment_fabu_date);
		shijian = (TextView) header.findViewById(R.id.scenery_comment_fabu_time);
		pingyu = (TextView) header.findViewById(R.id.scenery_comment_pingyu);
		zan = (TextView) header.findViewById(R.id.scenery_comment_dianzan);
		/**
		 * listview数据添加
		 */
		listview = (ListView) findViewById(R.id.scenery_comment_listview);
		listview.addHeaderView(header);// listview添加头视图 少了这一步头视图将不会移动。
		fanhuiBtn.setOnClickListener(onClickListener);
		getDate();
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.scenery_comment_fanhuiBtn:// id执行 //当前上下文//跳转指定的界面
				/*Intent intent = new Intent(SceneryCommentActivity.this,
						SceneryMoreActivity.class);
				startActivity(intent);// start开始 执行Intent意图【跳转】*/	
				finish();//返回上一页面
				break;

			default:
				break;
			}
		}

	};

	/**
	 * listview添加数据
	 */
	public void getDate() {
		// TODO Auto-generated method stub
		lists = new ArrayList<SceneryCommentSetget>();// 数组列表集合参数
		SceneryCommentSetget scs = new SceneryCommentSetget();// 实例化参数对象
		scs.setTouxiang(R.drawable.touxiang);
		scs.setName("冰梦一痕");
		scs.setTime("13分钟前");
		scs.setContent("好屌的样子");
		lists.add(scs);// 列表添加参数

		for (int i = 0; i < 10; i++) {
			scs = new SceneryCommentSetget();// 实例化参数对象
			scs.setTouxiang(R.drawable.collect_icon1);
			scs.setName("开心果");
			scs.setTime("3小时前");
			scs.setContent("还不错");
			lists.add(scs);
			
			SceneryCommentAdapter scsAdapter = new SceneryCommentAdapter(SceneryCommentActivity.this,
					R.layout.actvity_homepage_listview_punglun,lists);
			listview.setAdapter(scsAdapter);//listView设置Adapter
		}
	}
}
