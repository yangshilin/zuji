package com.example.zuji.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zuji.javaclass.PingLun;


public class PingLunAdapter extends BaseAdapter{
	Context context;
	List<PingLun> pinglunList;
	LayoutInflater inflater;
	int item;
	int[] id;
	
	
	public PingLunAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public PingLunAdapter(Context context, List<PingLun> pinglunList, int item,
			int[] id) {
		super();
		this.context = context;
		this.pinglunList = pinglunList;
		this.item = item;
		this.id = id;
		inflater=LayoutInflater.from(context);
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pinglunList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return pinglunList.get(position);
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
		ImageView OthersImage=(ImageView)convertView.findViewById(id[0]);
		TextView OthersName=(TextView)convertView.findViewById(id[1]);
		TextView zipinglun=(TextView)convertView.findViewById(id[2]);
		TextView nide=(TextView)convertView.findViewById(id[3]);
		TextView huifu=(TextView)convertView.findViewById(id[4]);
		TextView OthersWords=(TextView)convertView.findViewById(id[5]);
		ImageView userImage=(ImageView)convertView.findViewById(id[6]);
		TextView userName=(TextView)convertView.findViewById(id[7]);
		TextView userWords=(TextView)convertView.findViewById(id[8]);
		TextView time=(TextView)convertView.findViewById(id[9]);
		
		PingLun pinglun=pinglunList.get(position);
		OthersImage.setImageResource(pinglun.getOthersImage());
		OthersName.setText(pinglun.getOthersName());
		zipinglun.setText(pinglun.getZipinglun());
		nide.setText(pinglun.getNide());
		huifu.setText(pinglun.getHuifu());
		OthersWords.setText(pinglun.getOthersWords());
		userImage.setImageResource(pinglun.getUserImage());
		userName.setText(pinglun.getUserName());
		userWords.setText(pinglun.getUserWords());
		time.setText(pinglun.getTime());
	
		return convertView;
	}

}
