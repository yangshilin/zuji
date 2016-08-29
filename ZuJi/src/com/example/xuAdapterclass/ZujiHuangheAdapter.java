package com.example.xuAdapterclass;

import java.util.List;

import com.example.zuji.R;
import com.example.zuji.javaclass.SceneryCommentSetget;
import com.example.zuji.javaclass.ZujiHuangheSetget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ZujiHuangheAdapter extends BaseAdapter{
	LayoutInflater inflater;//布局填充器
	Context context;//上下文
	List<ZujiHuangheSetget>lists;//列表添加setget方法
	int resourceid;//资源id
	
	public ZujiHuangheAdapter(){//自定义的无参构造器
		
	}
	public ZujiHuangheAdapter(Context context , int resourceid,
			List<ZujiHuangheSetget> lists){//传入参数
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
			convertView = inflater.inflate(resourceid,null);
			
		}
		ImageView touxiang = (ImageView)convertView.findViewById(R.id.pinglun_list_tupian);
		TextView name = (TextView)convertView.findViewById(R.id.pinglun_list_name);
		TextView time = (TextView)convertView.findViewById(R.id.pinglun_list_time);
		TextView content = (TextView)convertView.findViewById(R.id.pinglun_list_content);
		
		ZujiHuangheSetget hh = lists.get(position);//类型参数获得位置；
		/*	imageView.setBackgroundDrawable(context.getResources().getDrawable(
		products.getImgedt())); 背景写法*/
		
		touxiang.setImageResource(hh.getTouxiang());//通过id设置图片资源，参数在相对应位置获得参数
		name.setText(hh.getName());
		time.setText(hh.getTime());
		content.setText(hh.getContent());
		
		return convertView;
	}

}
