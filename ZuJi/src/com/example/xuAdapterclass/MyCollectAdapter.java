package com.example.xuAdapterclass;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCollectAdapter extends BaseAdapter {
	Context context;
	LayoutInflater inflater;
	int item;
	int[] id;
	List<Collect> list;

	public MyCollectAdapter() {
		super();
	}

	public MyCollectAdapter(Context context, int item, int[] id,
			List<Collect> list) {
		super();
		this.context = context;
		this.item = item;
		this.id = id;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = inflater.inflate(item, null);

			ImageView tuxiang = (ImageView) convertView.findViewById(id[0]);
			TextView name = (TextView) convertView.findViewById(id[1]);
			TextView shiwuname = (TextView) convertView.findViewById(id[2]);
			TextView daytime = (TextView) convertView.findViewById(id[4]);
			TextView liulan = (TextView) convertView.findViewById(id[5]);
			ImageView zan = (ImageView) convertView.findViewById(id[6]);
			TextView zannumb = (TextView) convertView.findViewById(id[7]);
			ImageView commection = (ImageView) convertView.findViewById(id[8]);
			TextView commnumb = (TextView) convertView.findViewById(id[9]);

			Collect collect = list.get(position);

			tuxiang.setImageResource(collect.getTuxiang());
			name.setText(collect.getName());
			shiwuname.setText(collect.getShiwuname());
			daytime.setText(collect.getDaytime());
			liulan.setText(collect.getLiulan());
			zan.setImageResource(collect.getZan());
			zannumb.setText(collect.getZannumb());
			commection.setImageResource(collect.getCommection());
			commnumb.setText(collect.getCommnumb());
		}
		return convertView;
	}

}
