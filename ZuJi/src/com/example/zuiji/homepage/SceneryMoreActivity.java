package com.example.zuiji.homepage;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.xuAdapterclass.SceneryMoreAdapter;
import com.example.zuji.BottonNavigationActivity;
import com.example.zuji.R;
import com.example.zuji.javaclass.SceneryMore;

public class SceneryMoreActivity extends Activity {
	ImageButton fanhuiBtn;
	ImageButton guanzhuBtn;
	/**
	 * GridView添加数据
	 */
	GridView gridview;
	List<SceneryMore> lists;
	SceneryMore sm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
		setContentView(R.layout.activity_scenery_more);
		fanhuiBtn = (ImageButton) findViewById(R.id.scenery_comment_content_fanhuiBtn);
		guanzhuBtn = (ImageButton)findViewById(R.id.hot_guanzhu);
	
		gridview = (GridView)findViewById(R.id.scenery_comment_content_gview);
		fanhuiBtn.setOnClickListener(onclicklistener);
		getDate();
	}
	/**
	 * GridView添加数据
	 */
	private void getDate() {
		// TODO Auto-generated method stub
		lists = new ArrayList<SceneryMore>();//数组列表集合参数
		for (int i = 0; i < 20; i++) {
		SceneryMore sm = new SceneryMore();//实例化参数对象
		sm.setTupian(R.drawable.teita);
		sm.setTouxiang(R.drawable.touxiang);
		sm.setTitle("普通菇凉");
		sm.setShizhong(R.drawable.shijian);
		sm.setRiqi("3-10");
		sm.setShijian("10:15");
		sm.setPingyu(R.drawable.xiao_pinglun);
		sm.setPingyushu("13");
		sm.setXin(R.drawable.xin);
		sm.setZanshu("278");
		lists.add(sm);// 列表添加参数
		
		SceneryMoreAdapter smAdapter = new SceneryMoreAdapter(SceneryMoreActivity.this,
				R.layout.activity_scenery_more_gridview, lists);
		gridview.setAdapter(smAdapter);//listView设置Adapter
	}

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
				Intent intent = new Intent(SceneryMoreActivity.this,
						BottonNavigationActivity.class);
				startActivity(intent);// start开始 执行Intent意图【跳转】
				break;

			default:
				break;
			}
		}
	};
}
