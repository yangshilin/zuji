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
import com.example.zuji.javaclass.TiDaoNiDe;

public class TiDaoNiDaAdapter extends BaseAdapter{
	Context context;
	List<TiDaoNiDe> tidaonideList;
	LayoutInflater inflater;
	int item;
	int[] id;
	
	
	public TiDaoNiDaAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public TiDaoNiDaAdapter(Context context, List<TiDaoNiDe> tidaonideList,
			int item, int[] id) {
		super();
		this.context = context;
		this.tidaonideList = tidaonideList;
		this.item = item;
		this.id = id;
		inflater=LayoutInflater.from(context);
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return tidaonideList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return tidaonideList.get(position);
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
			ImageView OthersImage=(ImageView)convertView.findViewById(id[0]);
			TextView OthersName=(TextView)convertView.findViewById(id[1]);
			TextView tidao=(TextView)convertView.findViewById(id[2]);
			TextView ni=(TextView)convertView.findViewById(id[3]);
			TextView ait=(TextView)convertView.findViewById(id[4]);
			TextView OthersWords=(TextView)convertView.findViewById(id[5]);
			ImageView userImage=(ImageView)convertView.findViewById(id[6]);
			TextView userName=(TextView)convertView.findViewById(id[7]);
			TextView userWords=(TextView)convertView.findViewById(id[8]);
			TextView time=(TextView)convertView.findViewById(id[9]);
			LinearLayout dongtai=(LinearLayout)convertView.findViewById(R.id.tidao_linear);
			TiDaoNiDe tidaonide=tidaonideList.get(position);
			OthersImage.setImageResource(tidaonide.getOthersImage());
			OthersName.setText(tidaonide.getOthersName());
			tidao.setText(tidaonide.getTidao());
			ni.setText(tidaonide.getNi());
			ait.setText(tidaonide.getAit());
			OthersWords.setText(tidaonide.getOthersWords());
			userImage.setImageResource(tidaonide.getUserImage());
			userName.setText(tidaonide.getUserName());
			userWords.setText(tidaonide.getUserWords());
			time.setText(tidaonide.getTime());
			OthersImage.setOnClickListener(onClickListener);
			dongtai.setOnClickListener(onClickListener);
		return convertView;
	}
OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			
			case R.id.tidao_otherImage:
				Toast.makeText(context, "要跳转页面", Toast.LENGTH_LONG).show();
				break;
			case R.id.tidao_linear:
				Toast.makeText(context, "要跳转页面", Toast.LENGTH_LONG).show();
				break;
				default:
					break;
			}
			
		}
	};
}
