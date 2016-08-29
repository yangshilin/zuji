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
import com.example.zuji.javaclass.HotData;

public class HotAdapter extends BaseAdapter{
	LayoutInflater inflater;//布局填充器
	Context context;//上下文
	List<HotData> lists;//列表添加setget方法 参数类型
	int resourceid;//资源id
	
	public HotAdapter(){
		
	}
	public HotAdapter(Context context, int resourceid,
			List<HotData> lists){
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
		if(convertView == null){
			convertView = inflater.inflate(resourceid, null);
		}
		ImageView tupian = (ImageView)convertView.findViewById(R.id.hot_data_Picture);
		TextView title = (TextView)convertView.findViewById(R.id.hot_data_title);
		TextView browse = (TextView)convertView.findViewById(R.id.hot_data_browse_quantity);
		ImageView tupiantwo = (ImageView)convertView.findViewById(R.id.hot_data_Picture_two);
		TextView titletwo = (TextView)convertView.findViewById(R.id.hot_data_title_two);
		TextView browsetwo = (TextView)convertView.findViewById(R.id.hot_data_browse_quantity_two);
		
		HotData hd = lists.get(position);//类型参数获得位置
		/*	imageView.setBackgroundDrawable(context.getResources().getDrawable(
		products.getImgedt())); 背景写法*/
		tupian.setImageResource(hd.getTupian());//通过id设置图片资源，参数在相对应位置获得参数
		title.setText(hd.getTitle());
		browse.setText(hd.getBrowse());
		tupiantwo.setImageResource(hd.getTupiantwo());//通过id设置图片资源，参数在相对应位置获得参数
		titletwo.setText(hd.getTitletwo());
		browsetwo.setText(hd.getBrowsetwo());
		
		return convertView;
	}

}
