package com.example.zuji;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zuji.adapter.XiaoXiAdapter;
import com.example.zuji.javaclass.XiaoXi;

public class Fragment_XiaoXi extends Fragment {
	View header;
	ListView listview;
	int[] id = { R.id.xiaoxi_touxiang, R.id.name_xiaoxi, R.id.text_xiaoxi };
	XiaoXiAdapter adapter;
	List<XiaoXi> xiaoxiList;

	ImageButton xiaoxiReturn, btn1, btn2, btn3, btn4;
	LinearLayout pinglunText, dianzantext, tongzhitext, tidaotext;
	TextView zuijin;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.xiaoxi, null);
		xiaoxiReturn = (ImageButton) v.findViewById(R.id.return_xiaoxi);
		listview = (ListView) v.findViewById(R.id.listview_xiaoxi);

		header = View.inflate(getActivity(), R.layout.xiaoxi_listview_head,
				null);
		pinglunText = (LinearLayout) header.findViewById(R.id.pinglun_xiaoxi);
		dianzantext = (LinearLayout) header.findViewById(R.id.dianzan_xiaoxi);
		tongzhitext = (LinearLayout) header.findViewById(R.id.tongzhi_xiaoxi);
		tidaotext = (LinearLayout) header.findViewById(R.id.tidao_xiaoxi);
		//tidaotext = (LinearLayout) header.findViewById(R.id.tidao_xiaoxi);
		btn1 = (ImageButton) header.findViewById(R.id.btn1);
		btn2 = (ImageButton) header.findViewById(R.id.btn2);
		btn3 = (ImageButton) header.findViewById(R.id.btn3);
		btn4 = (ImageButton) header.findViewById(R.id.btn4);
		listview.addHeaderView(header);// 添加头视图
		getData();
		adapter = new XiaoXiAdapter(getActivity(), xiaoxiList,
				R.layout.xiaoxi_listview_item, id);
		listview.setAdapter(adapter);
		pinglunText.setOnClickListener(onClickListener);
		dianzantext.setOnClickListener(onClickListener);
		tongzhitext.setOnClickListener(onClickListener);
		tidaotext.setOnClickListener(onClickListener);
		xiaoxiReturn.setOnClickListener(onClickListener);
		listview.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getActivity(),ZuJiActivity.class);
				startActivity(intent);
			}
			});
		return v;
	}

	public void getData() {
		xiaoxiList = new ArrayList<XiaoXi>();
		XiaoXi xiaoxi = new XiaoXi();
		xiaoxi.setXiaoxiImage(R.drawable.praise_friend_head);
		xiaoxi.setXiaoxiName(getResources().getString(R.string.zuji));
		xiaoxi.setXiaoxiText(getResources().getString(R.string.duihua));
		xiaoxiList.add(xiaoxi);

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.return_xiaoxi:
				Intent intent1 = new Intent(getActivity(),
						PingLunActivity.class);
				startActivity(intent1);
				break;
			case R.id.pinglun_xiaoxi:
				Intent intent2 = new Intent(getActivity(),
						PingLunActivity.class);
				startActivity(intent2);
				break;
			case R.id.dianzan_xiaoxi:
				Intent intent3 = new Intent(getActivity(),
						DianZanActivity.class);
				startActivity(intent3);
				break;
			case R.id.tongzhi_xiaoxi:
				Intent intent4 = new Intent(getActivity(),
						TongZhiActivity.class);
				startActivity(intent4);
				break;
			case R.id.tidao_xiaoxi:
				Intent intent5 = new Intent(getActivity(), TiDaoActivity.class);
				startActivity(intent5);
				break;
			/*
			 * case R.id.zuji_xiaozi: Intent intent6 = new
			 * Intent(XiaoXiActivity.this, ZuJiActivity.class);
			 * startActivity(intent6); break;
			 */
			default:
				break;

			}
		}

	};
}
