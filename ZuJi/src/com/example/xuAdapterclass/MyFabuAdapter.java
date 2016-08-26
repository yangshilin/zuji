package com.example.xuAdapterclass;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyFabuAdapter extends BaseAdapter {
	Context context;
	LayoutInflater inflater;
	int item;
	int[] idd;
	List<Release> list;

	public MyFabuAdapter() {
		super();
	}

	public MyFabuAdapter(Context context, int item, int[] idd,
			List<Release> list) {
		super();
		this.context = context;
		this.item = item;
		this.idd = idd;
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
		}
		ImageView imageId = (ImageView) convertView.findViewById(idd[0]);
		TextView xinsheng = (TextView) convertView.findViewById(idd[1]);
		ImageView zan = (ImageView) convertView.findViewById(idd[2]);
		TextView zanmunb = (TextView) convertView.findViewById(idd[3]);
		TextView fabupinglun = (TextView) convertView.findViewById(idd[4]);
		ImageView fabupingluntu = (ImageView) convertView.findViewById(idd[5]);

		Release release = list.get(position);
		imageId.setImageResource(release.getImageId());
		xinsheng.setText(release.getXinsheng());
		zan.setImageResource(release.getZan());
		zanmunb.setText(release.getZanmunb());
		fabupinglun.setText(release.getFabupinglun());
		fabupingluntu.setImageResource(release.getFabupingluntu());

		return convertView;
	}

}
