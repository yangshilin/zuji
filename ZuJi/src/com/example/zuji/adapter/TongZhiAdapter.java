package com.example.zuji.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zuji.javaclass.TongZhi;

public class TongZhiAdapter extends BaseAdapter{
	Context context;
	List<TongZhi> tongzhiList;
	LayoutInflater inflater;
	int item;
	int[] id;
	
	public TongZhiAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TongZhiAdapter(Context context, List<TongZhi> tongzhiList, int item,
			int[] id) {
		super();
		this.context = context;
		this.tongzhiList = tongzhiList;
		this.item = item;
		this.id = id;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return tongzhiList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return tongzhiList.get(position);
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
			convertView=inflater.inflate(item, null);
		}	
		ImageView otherImage=(ImageView)convertView.findViewById(id[0]);
		TextView name=(TextView)convertView.findViewById(id[1]);
		TextView guanzhu=(TextView)convertView.findViewById(id[2]);
		TextView you=(TextView)convertView.findViewById(id[3]);
		TextView time=(TextView)convertView.findViewById(id[4]);
		ImageView addImage=(ImageView)convertView.findViewById(id[5]);

		TongZhi tongzhi=tongzhiList.get(position);
		
		otherImage.setImageResource(tongzhi.getOtherImage());
		name.setText(tongzhi.getName());
		guanzhu.setText(tongzhi.getGuanzhu());
		you.setText(tongzhi.getYou());
		time.setText(tongzhi.getTime());
		addImage.setImageResource(tongzhi.getAddImage());
		return convertView;
	}

}
