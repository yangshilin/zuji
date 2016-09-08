package com.example.zuiji.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zuji.R;

public class HomepageFragment extends Fragment{
	ImageView title;
	EditText edt;
	TextView qiandao;
	//风景口碑
	TextView fengjing;
	ImageView fengjing1;
	ImageView fengjing2;
	ImageView fengjing3;
	TextView gengduofengjing;
	ImageView gengduoBtn;
	//足迹推荐
	TextView tuijian;
	ImageView huangshan;
	//影集
	TextView yingji;
	ImageView yingji2;
	ImageView yingji3;
	ImageView yingji4;
	ImageView yingji5;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
		View view = inflater.inflate(R.layout.activity_homepage, container,false);//视图传入布局
		title = (ImageView)view.findViewById(R.id.homepage_window_image);
		edt = (EditText)view.findViewById(R.id.homepage_edit_text);
		//风景口碑
		fengjing =(TextView)view.findViewById(R.id.homepage_fengjing);
		fengjing1 =(ImageView)view.findViewById(R.id.homepage_koubei_viewone);
		fengjing2 =(ImageView)view.findViewById(R.id.homepage_koubei_viewtwo);
		fengjing3 =(ImageView)view.findViewById(R.id.homepage_koubei_viewthree);		
		gengduofengjing = (TextView)view.findViewById(R.id.homepage_gengduo_fengjing);
		gengduoBtn = (ImageView)view.findViewById(R.id.homepage_genduo_koubei_Btn);
		//足迹推荐
		tuijian = (TextView)view.findViewById(R.id.homepage_tuijian);
		huangshan = (ImageView)view.findViewById(R.id.homepage_tuijian_view);
		//影集
		yingji =(TextView)view.findViewById(R.id.homepage_hot);
		yingji2 =(ImageView)view.findViewById(R.id.homepage_hot_one);
		yingji3 =(ImageView)view.findViewById(R.id.homepage_hot_two);
		yingji4 =(ImageView)view.findViewById(R.id.homepage_hot_three);
		yingji5 =(ImageView)view.findViewById(R.id.homepage_hot_frou);
		/**
		 * 监听
		 */
		title.setOnClickListener(onClickListener);
		edt.setOnClickListener(onClickListener);
		//风景口碑
		fengjing.setOnClickListener(onClickListener);
		fengjing1.setOnClickListener(onClickListener);
		fengjing2.setOnClickListener(onClickListener);
		fengjing3.setOnClickListener(onClickListener);
		gengduofengjing.setOnClickListener(onClickListener);
		gengduoBtn.setOnClickListener(onClickListener);
		//足迹推荐
		tuijian.setOnClickListener(onClickListener);
		huangshan.setOnClickListener(onClickListener);
		//影集
		yingji.setOnClickListener(onClickListener);
		yingji2.setOnClickListener(onClickListener);
		yingji3.setOnClickListener(onClickListener);
		yingji4.setOnClickListener(onClickListener);
		yingji5.setOnClickListener(onClickListener);
		return view;
	}
	private void requestWindowFeature(int featureNoTitle) {
		// TODO Auto-generated method stub
		
	}
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.homepage_window_image:
				Intent window = new Intent(getActivity(),HomepageZuji.class);
				startActivity(window);
				break;
			case R.id.homepage_edit_text:
				Intent sousuo = new Intent(getActivity(),SeekActivity.class);
				startActivity(sousuo);
				break;
				//风景口碑
			case R.id.homepage_fengjing:// id执行 //当前上下文//跳转指定的界面
				Intent fengjing = new Intent(getActivity(),SceneryCommentActivity.class);
				startActivity(fengjing);//start开始 执行Intent意图【跳转】
				break;
			case R.id.homepage_koubei_viewone:
				Intent fengjing1 = new Intent(getActivity(),SceneryCommentActivity.class);
				startActivity(fengjing1);
				break;
			case R.id.homepage_koubei_viewtwo:
				Intent fengjing2 = new Intent(getActivity(),SceneryCommentActivity.class);
				startActivity(fengjing2);
				break;
			case R.id.homepage_koubei_viewthree:
				Intent fengjing3 = new Intent(getActivity(),SceneryCommentActivity.class);
				startActivity(fengjing3);
				break;
			case R.id.homepage_gengduo_fengjing:
				Intent gengduofengjing = new Intent(getActivity(),SceneryMoreActivity.class);
				startActivity(gengduofengjing);
				break;
			case R.id.homepage_genduo_koubei_Btn:
				Intent gengduoBtn = new Intent(getActivity(),SceneryMoreActivity.class);
				startActivity(gengduoBtn);
				break;
				//足迹推荐
			case R.id.homepage_tuijian:
				Intent tuijian = new Intent(getActivity(),ZujiRecommendHuangheActivity.class);
				startActivity(tuijian);
				break;
			case R.id.homepage_tuijian_view:
				Intent huangshan = new Intent(getActivity(),ZujiRecommendHuangshanActivity.class);
				startActivity(huangshan);
				break;
				//影集
			case R.id.homepage_hot:
				Intent yingji = new Intent(getActivity(),HotPhotoalbumActivity.class);
				startActivity(yingji);
				break;
			case R.id.homepage_hot_one:
				Intent yingji2 = new Intent(getActivity(),HotPhotoalbumActivity.class);
				startActivity(yingji2);
				break;
			case R.id.homepage_hot_two:
				Intent yingji3 = new Intent(getActivity(),HotPhotoalbumActivity.class);
				startActivity(yingji3);
				break;
			case R.id.homepage_hot_three:
				Intent yingji4 = new Intent(getActivity(),HotPhotoalbumActivity.class);
				startActivity(yingji4);
				break;
			case R.id.homepage_hot_frou:
				Intent yingji5 = new Intent(getActivity(),HotPhotoalbumActivity.class);
				startActivity(yingji5);
				break;
		default:
				break;
			}
		}
	};
};
	
	














