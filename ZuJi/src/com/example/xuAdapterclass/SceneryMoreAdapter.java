package com.example.xuAdapterclass;

import java.util.List;

import com.example.zuji.R;
import com.example.zuji.javaclass.SceneryMore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SceneryMoreAdapter extends BaseAdapter{
	LayoutInflater inflater;//布局填充器
	Context context;//上下文
	List<SceneryMore>lists;//列表添加setget方法
	int resourceid;//资源id
	
	public SceneryMoreAdapter(){//自定义的无参构造器
		
	}
	public SceneryMoreAdapter(Context context, int resourceid,
			List<SceneryMore> lists){//传入参数
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
			convertView = inflater.inflate(resourceid, null);
		}
		ImageView tupian = (ImageView)convertView.findViewById(R.id.scenery_more_tupian);
		ImageView touxiang = (ImageView)convertView.findViewById(R.id.scenery_more_touxiang);
		TextView title = (TextView)convertView.findViewById(R.id.scenery_more_title);
		ImageView shizhong = (ImageView)convertView.findViewById(R.id.scenery_more_clock);
		TextView riqi = (TextView)convertView.findViewById(R.id.scenery_more_fabu_date);
		TextView shijian = (TextView)convertView.findViewById(R.id.scenery_more_fabu_time);
		ImageView pingyu = (ImageView)convertView.findViewById(R.id.scenery_more_pingyu);
		TextView pingyushu = (TextView)convertView.findViewById(R.id.scenery_more_pingyu_shuju);
		ImageView xin = (ImageView)convertView.findViewById(R.id.scenery_more_dianzan);
		TextView zanshu = (TextView)convertView.findViewById(R.id.scenery_more_dianzan_shuju);
		
		SceneryMore sm = lists.get(position);//类型参数获得位置；
		
		tupian.setImageResource(sm.getTupian());//通过id设置图片资源，参数在相对应位置获得参数
		touxiang.setImageResource(sm.getTouxiang());
		title.setText(sm.getTitle());
		shizhong.setImageResource(sm.getShizhong());
		riqi.setText(sm.getRiqi());
		shijian.setText(sm.getShijian());
		pingyu.setImageResource(sm.getPingyu());
		pingyushu.setText(sm.getPingyushu());
		xin.setImageResource(sm.getXin());
		zanshu.setText(sm.getZanshu());
		return convertView;
	}

}
