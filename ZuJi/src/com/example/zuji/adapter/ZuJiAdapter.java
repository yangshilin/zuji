package com.example.zuji.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zuji.R;
import com.example.zuji.javaclass.ZuJi;

public class ZuJiAdapter extends BaseAdapter {
	private Context context = null;
	private List<ZuJi> zujiList = null;
	private LayoutInflater inflater = null;
	private int COME_MSG = 0;
	private int TO_MSG = 1;

	public ZuJiAdapter(Context context, List<ZuJi> zujiList) {
		this.context = context;
		this.zujiList = zujiList;
		inflater = LayoutInflater.from(this.context);
	}

	@Override
	public int getCount() {
		return zujiList.size();
	}

	@Override
	public Object getItem(int position) {
		return zujiList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getItemViewType(int position) {
		// 区别两种view的类型，标注两个不同的变量来分别表示各自的类型
		ZuJi zuji = zujiList.get(position);
		if (zuji.isComeMsg()) {
			return COME_MSG;
		} else {
			return TO_MSG;
		}
	}

	@Override
	public int getViewTypeCount() {
		// 这个方法默认返回1，如果希望listview的item都是一样的就返回1，我们这里有两种风格，返回2
		return 2;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ChatHolder chatHolder = null;
		if (convertView == null) {
			chatHolder = new ChatHolder();
			if (zujiList.get(position).isComeMsg()) {
				convertView = inflater.inflate(
						R.layout.zuji_listview_item_left, null);
			} else {
				convertView = inflater.inflate(
						R.layout.zuji_listview_item_right, null);
			}
			chatHolder.timeTextView = (TextView) convertView
					.findViewById(R.id.zuji_time);
			chatHolder.contentTextView = (TextView) convertView
					.findViewById(R.id.zuji_content);
			chatHolder.userImageView = (ImageView) convertView
					.findViewById(R.id.user_image);
			convertView.setTag(chatHolder);
		} else {
			chatHolder = (ChatHolder) convertView.getTag();
		}

		chatHolder.timeTextView.setText(zujiList.get(position).getZujitime());
		chatHolder.contentTextView.setText(zujiList.get(position).getContent());
		chatHolder.userImageView.setImageResource(zujiList.get(position)
				.getUserImage());
		chatHolder.userImageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId()==R.id.user_image){
					Toast.makeText(context, "你要跳转",Toast.LENGTH_LONG).show();
				}
			}
		});
		return convertView;
	}

	private class ChatHolder {
		private TextView timeTextView;
		private ImageView userImageView;
		private TextView contentTextView;
	}

}
