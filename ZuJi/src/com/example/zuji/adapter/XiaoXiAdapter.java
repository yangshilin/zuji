package com.example.zuji.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zuji.javaclass.XiaoXi;

public class XiaoXiAdapter extends BaseAdapter{
	Context context;
	List<XiaoXi> xiaoxiList;
	LayoutInflater inflater;
	int item;
	int[] id;
	

	public XiaoXiAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XiaoXiAdapter(Context context, List<XiaoXi> xiaoxiList, int item,
			int[] id) {
		super();
		this.context = context;
		this.xiaoxiList = xiaoxiList;
		this.item = item;
		this.id = id;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return xiaoxiList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return xiaoxiList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			convertView=inflater.inflate(item,null);
		}
		ImageView xiaoxiImage=(ImageView)convertView.findViewById(id[0]);
		TextView xiaoxiName=(TextView)convertView.findViewById(id[1]);
		TextView xiaoxiText=(TextView)convertView.findViewById(id[2]);
		
		XiaoXi xiaoxi=xiaoxiList.get(position);
		xiaoxiImage.setImageResource(xiaoxi.getXiaoxiImage());
		xiaoxiName.setText(xiaoxi.getXiaoxiName());
		xiaoxiText.setText(xiaoxi.getXiaoxiText());
		return convertView;
	}

}
