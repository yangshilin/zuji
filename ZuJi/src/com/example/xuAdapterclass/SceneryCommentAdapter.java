package com.example.xuAdapterclass;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zuji.R;
import com.example.zuji.javaclass.SceneryCommentSetget;

public class SceneryCommentAdapter extends BaseAdapter{
	LayoutInflater inflater;//布局填充器
	Context context;//上下文
	List<SceneryCommentSetget>lists;//列表添加setget方法
	int resourceid;//资源id
	
	public SceneryCommentAdapter(){//自定义的无参构造器
		
	}
	public SceneryCommentAdapter(Context context,int resourceid, List<SceneryCommentSetget> lists){//传入参数
		this.context = context;
		this.lists = lists;
		this.resourceid = resourceid;
		inflater = LayoutInflater.from(context);//填充器将要填充的布局，来自上下文
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();//返回数据大小
		
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lists.get(position);//lists获取位置
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;//获取项目id确定当前位置
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){//convertView转换视图
			convertView = inflater.inflate(resourceid, null);//
		}
		ImageView touxiang = (ImageView)convertView.findViewById(R.id.pinglun_list_tupian);
		TextView name = (TextView)convertView.findViewById(R.id.pinglun_list_name);
		TextView time = (TextView)convertView.findViewById(R.id.pinglun_list_time);
		TextView content = (TextView)convertView.findViewById(R.id.pinglun_list_content);
		
		SceneryCommentSetget scs = lists.get(position);//类型参数获得位置；
		/*	imageView.setBackgroundDrawable(context.getResources().getDrawable(
		products.getImgedt())); 背景写法*/
		
		touxiang.setImageResource(scs.getTouxiang());//通过id设置图片资源，参数在相对应位置获得参数
		name.setText(scs.getName());
		time.setText(scs.getTime());
		content.setText(scs.getContent());
		
		return convertView;
	}

}
