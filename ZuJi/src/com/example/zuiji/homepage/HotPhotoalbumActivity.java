package com.example.zuiji.homepage;

import java.util.ArrayList;
import java.util.List;

import com.example.xuAdapterclass.HotAdapter;
import com.example.zuji.BottonNavigationActivity;
import com.example.zuji.R;
import com.example.zuji.javaclass.HotData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;


public class HotPhotoalbumActivity extends Activity{
	ImageButton fanhuiBtn;
	/**
	 * 添加头视图
	 */
	View header;
	ImageButton guanzhu;
	/**
	 * listview添加数据
	 */
	ListView listview;
	List<HotData> lists;
	HotData hd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
	setContentView(R.layout.actvity_hot_photoalbum);
	fanhuiBtn= (ImageButton)findViewById(R.id.hot_yingji_fanhuiBtn);
	/**
	 * 头视图 Activity和Fragment有差异
	 * Activity是上文[本文名]【SceneryCommentActivity.this】
	 * Fragment用【getActivity()】方法。
	 */
	header = LayoutInflater.from(HotPhotoalbumActivity.this).inflate(
			R.layout.activity_hot_header,null);
	/**
	 * 头视图内控件id
	 */
	guanzhu = (ImageButton)header.findViewById(R.id.hot_guanzhu);
	/**
	 * listview添加数据
	 */
	listview = (ListView)findViewById(R.id.hot_listview);
	listview.addHeaderView(header);//添加头视图 少了这一步头视图将不会存在。
	/**
	 * 监听
	 */
	fanhuiBtn.setOnClickListener(onClickListener);
	getData();
	}
	
	OnClickListener onClickListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.hot_yingji_fanhuiBtn:// id执行 //当前上下文//跳转指定的界面
				Intent intent = new Intent(HotPhotoalbumActivity.this,BottonNavigationActivity.class);
				startActivity(intent);// start开始 执行Intent意图【跳转】
				break;

			default:
				break;
			}
		}
		
	};
	/**
	 * listview添加数据
	 */
	private void getData() {
		// TODO Auto-generated method stub
		lists = new ArrayList<HotData>();//数组列表集合参数
		
		for (int i=0 ; i < 10; i++){
		HotData hd = new HotData();//实例化参数对象
		hd.setTupian(R.drawable.publish_img2);
		hd.setTitle("春天的芬芳");
		hd.setBrowse("68");
		hd.setTupiantwo(R.drawable.publish_img4);
		hd.setTitletwo("秋天的硕果");
		hd.setBrowsetwo("28");
		lists.add(hd);//列表添加数据
		
		HotAdapter adapter = new HotAdapter(HotPhotoalbumActivity.this,
				R.layout.activity_hot_listview_data, lists);
		listview.setAdapter(adapter);
		}
	}
}
