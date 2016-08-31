package com.example.zuji.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xuactivity.Mine_Fragment;
import com.example.zuji.R;
import com.example.zuji.javaclass.TongZhi;

public class TongZhiAdapter extends BaseAdapter {
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
		inflater = LayoutInflater.from(context);
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
		final TongZhi tongzhi = tongzhiList.get(position);
		if (convertView == null) {
			convertView = inflater.inflate(item, null);
		}
		ImageView otherImage = (ImageView) convertView.findViewById(id[0]);
		otherImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v.getId() == R.id.tongzhi_otherImage) {
					Toast.makeText(context, "你要跳转了" + tongzhi.getName(),
							Toast.LENGTH_LONG).show();
				}
			}
		});
		TextView name = (TextView) convertView.findViewById(id[1]);
		TextView guanzhu = (TextView) convertView.findViewById(id[2]);
		TextView you = (TextView) convertView.findViewById(id[3]);
		TextView time = (TextView) convertView.findViewById(id[4]);
		final ImageView addImage = (ImageView) convertView.findViewById(id[5]);
		addImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v.getId() == R.id.tongzhi_addimage) {
					Toast.makeText(context, "你关注了" + tongzhi.getName(),
							Toast.LENGTH_LONG).show();
					addImage.setImageResource(R.drawable.add_gray);
				}
			}
		});

		otherImage.setImageResource(tongzhi.getOtherImage());
		name.setText(tongzhi.getName());
		guanzhu.setText(tongzhi.getGuanzhu());
		you.setText(tongzhi.getYou());
		time.setText(tongzhi.getTime());
		addImage.setImageResource(tongzhi.getAddImage());
		return convertView;
	}

}
