package com.example.zuji.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zuji.R;
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
		LinearLayout dongtai=(LinearLayout)convertView.findViewById(R.id.pinglun_linear);
		
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
		huifu.setOnClickListener(onClickListener);
		OthersImage.setOnClickListener(onClickListener);
		dongtai.setOnClickListener(onClickListener);
		return convertView;
	}
	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.huifu_pinglun:
				Toast.makeText(context, "你要回复他", Toast.LENGTH_LONG).show();
				break;
			case R.id.otherImage_pinglun:
				Toast.makeText(context, "要跳转页面", Toast.LENGTH_LONG).show();
				break;
			case R.id.pinglun_linear:
				Toast.makeText(context, "要跳转页面", Toast.LENGTH_LONG).show();
				break;
				default:
					break;
			}
			
		}
	};
}
