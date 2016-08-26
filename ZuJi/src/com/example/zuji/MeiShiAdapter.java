package com.example.zuji;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MeiShiAdapter extends BaseAdapter {
	List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
	String[] from;
	int[] to;
	Context context;
	int resource;
	LayoutInflater inflater;

	public MeiShiAdapter(Context context, List<Map<String, Object>> data,
			int resource, String[] from, int[] to) {
		this.context = context;
		this.data = data;
		this.resource = resource;
		this.from = from;
		this.to = to;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = inflater.inflate(resource, null);
		}
		ImageView iv = (ImageView) convertView.findViewById(to[0]);
		iv.setImageDrawable(convertView.getResources().getDrawable(
				(Integer) data.get(position).get("image")));
		TextView name = (TextView) convertView.findViewById(to[1]);
		name.setText((String) data.get(position).get("name"));
		TextView time = (TextView) convertView.findViewById(to[2]);
		time.setText((String) data.get(position).get("time")+"小时前");
		ImageView xiai = (ImageView) convertView.findViewById(to[3]);
		xiai.setImageDrawable(convertView.getResources().getDrawable(
				(Integer) data.get(position).get("xiai")));
		ImageView meishi_image = (ImageView) convertView.findViewById(to[4]);
		meishi_image.setImageDrawable(convertView.getResources().getDrawable(
				(Integer) data.get(position).get("meishi_image")));

		return convertView;
	}

}
