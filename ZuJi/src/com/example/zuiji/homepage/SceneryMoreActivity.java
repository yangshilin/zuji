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
		
		 sm = new SceneryMore();//实例化参数对象
			sm.setTupian(R.drawable.koubei_work_image);
			sm.setTouxiang(R.drawable.logo_1);
			sm.setTitle("flalf");
			sm.setShizhong(R.drawable.shijian);
			sm.setRiqi("3-10");
			sm.setShijian("10:15");
			sm.setPingyu(R.drawable.xiao_pinglun);
			sm.setPingyushu("52");
			sm.setXin(R.drawable.xin);
			sm.setZanshu("432");
			lists.add(sm);// 列表添加参数
			
			 sm = new SceneryMore();//实例化参数对象
				sm.setTupian(R.drawable.tag2);
				sm.setTouxiang(R.drawable.logo_2);
				sm.setTitle("kt-mi");
				sm.setShizhong(R.drawable.shijian);
				sm.setRiqi("3-10");
				sm.setShijian("10:15");
				sm.setPingyu(R.drawable.xiao_pinglun);
				sm.setPingyushu("522");
				sm.setXin(R.drawable.xin);
				sm.setZanshu("412");
				lists.add(sm);// 列表添加参数
				
				 sm = new SceneryMore();//实例化参数对象
					sm.setTupian(R.drawable.tag3);
					sm.setTouxiang(R.drawable.logo_7);
					sm.setTitle("小虾米");
					sm.setShizhong(R.drawable.shijian);
					sm.setRiqi("3-10");
					sm.setShijian("10:15");
					sm.setPingyu(R.drawable.xiao_pinglun);
					sm.setPingyushu("520");
					sm.setXin(R.drawable.xin);
					sm.setZanshu("42");
					lists.add(sm);// 列表添加参数
					
					
					 sm = new SceneryMore();//实例化参数对象
						sm.setTupian(R.drawable.xiaobian2);
						sm.setTouxiang(R.drawable.logo_8);
						sm.setTitle("秋风");
						sm.setShizhong(R.drawable.shijian);
						sm.setRiqi("2-8");
						sm.setShijian("15:15");
						sm.setPingyu(R.drawable.xiao_pinglun);
						sm.setPingyushu("1204");
						sm.setXin(R.drawable.xin);
						sm.setZanshu("742");
						lists.add(sm);// 列表添加参数
						
						
						 sm = new SceneryMore();//实例化参数对象
							sm.setTupian(R.drawable.xiaobian3);
							sm.setTouxiang(R.drawable.logo_5);
							sm.setTitle("雨滴");
							sm.setShizhong(R.drawable.shijian);
							sm.setRiqi("2-7");
							sm.setShijian("13:15");
							sm.setPingyu(R.drawable.xiao_pinglun);
							sm.setPingyushu("43");
							sm.setXin(R.drawable.xin);
							sm.setZanshu("763");
							lists.add(sm);// 列表添加参数
							
							
							 sm = new SceneryMore();//实例化参数对象
								sm.setTupian(R.drawable.homepage_koubei_image2);
								sm.setTouxiang(R.drawable.logo_1);
								sm.setTitle("东方红");
								sm.setShizhong(R.drawable.shijian);
								sm.setRiqi("1-10");
								sm.setShijian("16:15");
								sm.setPingyu(R.drawable.xiao_pinglun);
								sm.setPingyushu("45");
								sm.setXin(R.drawable.xin);
								sm.setZanshu("7432");
								lists.add(sm);// 列表添加参数
								
								
								 sm = new SceneryMore();//实例化参数对象
									sm.setTupian(R.drawable.homepage_hot_photo_album_image3);
									sm.setTouxiang(R.drawable.logo_1);
									sm.setTitle("阿甘铪");
									sm.setShizhong(R.drawable.shijian);
									sm.setRiqi("1-10");
									sm.setShijian("12:13");
									sm.setPingyu(R.drawable.xiao_pinglun);
									sm.setPingyushu("42");
									sm.setXin(R.drawable.xin);
									sm.setZanshu("745");
									lists.add(sm);// 列表添加参数
			
		SceneryMoreAdapter smAdapter = new SceneryMoreAdapter(SceneryMoreActivity.this,
				R.layout.activity_scenery_more_gridview, lists);
		gridview.setAdapter(smAdapter);//listView设置Adapter
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
