package com.example.zuiji.homepage;

import com.example.zuji.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class HomepageFragment extends Fragment{
	ImageView beijing;
	EditText edt;
	TextView qiandao;
	TextView fengjing;
	TextView gengduofengjing;
	ImageView gengduoBtn;
	TextView tuijian;
	TextView yingji;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 取消运行时的顶部标题
		View view = inflater.inflate(R.layout.activity_homepage, container,false);//视图传入布局
		edt = (EditText)view.findViewById(R.id.homepage_edit_text);
		fengjing =(TextView)view.findViewById(R.id.homepage_fengjing);
		gengduofengjing = (TextView)view.findViewById(R.id.homepage_gengduo_fengjing);
		gengduoBtn = (ImageView)view.findViewById(R.id.homepage_genduo_koubei_Btn);
		tuijian = (TextView)view.findViewById(R.id.homepage_tuijian);
		yingji =(TextView)view.findViewById(R.id.homepage_hot);
		
		fengjing.setOnClickListener(onClickListener);
		gengduofengjing.setOnClickListener(onClickListener);
		gengduoBtn.setOnClickListener(onClickListener);
		tuijian.setOnClickListener(onClickListener);
		yingji.setOnClickListener(onClickListener);
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
			case R.id.homepage_fengjing:// id执行 //当前上下文//跳转指定的界面
				Intent fengjing = new Intent(getActivity(),SceneryCommentActivity.class);
				startActivity(fengjing);//start开始 执行Intent意图【跳转】
				break;
			case R.id.homepage_gengduo_fengjing:
				Intent gengduofengjing = new Intent(getActivity(),SceneryCommentContentActivity.class);
				startActivity(gengduofengjing);
				break;
			case R.id.homepage_genduo_koubei_Btn:
				Intent gengduoBtn = new Intent(getActivity(),SceneryCommentContentActivity.class);
				startActivity(gengduoBtn);
				break;
			case R.id.homepage_tuijian:
				Intent tuijian = new Intent(getActivity(),ZujiRecommendActivity.class);
				startActivity(tuijian);
				break;
			case R.id.homepage_hot:
				Intent yingji = new Intent(getActivity(),HotPhotoalbumActivity.class);
				startActivity(yingji);
				break;

			default:
				break;
			}
		}
	};
};
	
	














