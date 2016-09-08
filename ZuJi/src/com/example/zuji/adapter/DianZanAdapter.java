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
import com.example.zuji.javaclass.DianZan;




public class DianZanAdapter extends BaseAdapter{
	Context context;
	List<DianZan> dianzanList;
	LayoutInflater inflater;
	int item;
	int[] id;

	
	public DianZanAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	public DianZanAdapter(Context context, List<DianZan> dianzanList, int item,
			int[] id) {
		super();
		this.context = context;
		this.dianzanList = dianzanList;
		this.item = item;
		this.id = id;
		inflater=LayoutInflater.from(context);
	}


	@Override
	public int getCount() {
		return dianzanList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return dianzanList.get(position);
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
		TextView zanle=(TextView)convertView.findViewById(id[2]);
		TextView nide=(TextView)convertView.findViewById(id[3]);
		ImageView userImage=(ImageView)convertView.findViewById(id[4]);
		TextView userName=(TextView)convertView.findViewById(id[5]);
		TextView userWords=(TextView)convertView.findViewById(id[6]);
		TextView time=(TextView)convertView.findViewById(id[7]);
		LinearLayout dongtai=(LinearLayout)convertView.findViewById(R.id.dianzan_linear);
		DianZan dianzan=dianzanList.get(position);
		OthersImage.setImageResource(dianzan.getOthersImage());
		OthersName.setText(dianzan.getOthersName());
		zanle.setText(dianzan.getZanle());
		nide.setText(dianzan.getNide());
		userImage.setImageResource(dianzan.getUserImage());
		userName.setText(dianzan.getUserName());
		userWords.setText(dianzan.getUserWords());
		time.setText(dianzan.getTime());
		OthersImage.setOnClickListener(onClickListener);
		dongtai.setOnClickListener(onClickListener);
	return convertView;
}
OnClickListener onClickListener=new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		
		case R.id.dianzan_otherImage:
			Toast.makeText(context, "要跳转页面", Toast.LENGTH_LONG).show();
			break;
		case R.id.dianzan_linear:
			Toast.makeText(context, "要跳转页面", Toast.LENGTH_LONG).show();
			break;
			default:
				break;
		}
		
	}
};

}
