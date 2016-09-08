package com.example.xuactivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.dsw.datepicker.MonthDateView;
import com.dsw.datepicker.MonthDateView.DateClick;
import com.example.zuji.BottonNavigationActivity;
import com.example.zuji.R;


public class TimefusiondeletesActivity extends Activity implements
		OnClickListener {
	CheckBox pull_down;
	TextView shijian;
	ImageButton btfhmine;
	ImageView ivxiugai;
	Button bt_inpast;
	ListView time_listviews;
	SimpleAdapter simpleAdapter;
	List<Map<String, Object>> list;
	Uri uri;
	LayoutInflater inflater;
	SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日"); 
	Date curDate = new Date(System.currentTimeMillis());//获取当前时间 
	String str = formatter.format(curDate); 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.time_fusiondeletes);
		inflater=this.getLayoutInflater();
		intView();
		time_listviews.setOnItemClickListener(itemClickListener);
	}

	// 初始化
	public void intView() {
		pull_down=(CheckBox) findViewById(R.id.pull_down);
		shijian=(TextView)findViewById(R.id.cltime);
		shijian.setText(str);
		pull_down.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (pull_down.isChecked()) {
					initPopWindow();
				}else{
					if(popWindow!=null){
						popWindow.dismiss();
					}
				}
			}
		});
		btfhmine = (ImageButton) findViewById(R.id.btfhmine);
		btfhmine.setOnClickListener(this);
		bt_inpast = (Button) findViewById(R.id.bt_inpast);
		bt_inpast.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				startActivity(new Intent(TimefusiondeletesActivity.this,
						Timeinthepast_activity.class));
			}
		});
		time_listviews = (ListView) findViewById(R.id.time_listviews);
		String[] from = { "times", "mothday", "timelife" };
		int[] to = { R.id.times, R.id.mothday, R.id.timelife };

		simpleAdapter = new SimpleAdapter(this, data(),
				R.layout.time_fusiondeletes_listview, from, to);
		time_listviews.setAdapter(simpleAdapter);

	}


	OnItemClickListener itemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			TextView timeshare = (TextView) arg1.findViewById(R.id.timeshare);
			TextView timepaizhao = (TextView) arg1
					.findViewById(R.id.timepaizhao);
			ivxiugai = (ImageView) arg1.findViewById(R.id.ivxiugai);
			TextView timedelete = (TextView) arg1.findViewById(R.id.timedelete);
			final int a = arg2;
			Toast.makeText(TimefusiondeletesActivity.this, "" + arg2,
					Toast.LENGTH_SHORT).show();
			timeshare.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {// 分享
					Toast.makeText(TimefusiondeletesActivity.this, "分享成功",
							Toast.LENGTH_SHORT).show();
					share();
					//startActivity(new Intent(TimefusiondeletesActivity.this,Mine_collect_activity.class));
				}
			});
			timepaizhao.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					getPhoto(v);
					
				}
			});
			timedelete.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					list.remove(a);
					simpleAdapter.notifyDataSetChanged();
					Toast.makeText(TimefusiondeletesActivity.this, "删除成功" + a,
							Toast.LENGTH_SHORT).show();
				}
			});
		}
	};
	/**
	 * 安装包地址
	 */
	String linkPath = "https://github.com/maomao123456/Pet.git";
	// 分享
	public void share() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/*");
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, linkPath);
		intent.putExtra(Intent.EXTRA_TEXT, linkPath);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(Intent.createChooser(intent, getTitle()));
	}

		
	private ImageView iv_left;
	private ImageView iv_right;
	private TextView tv_date;
	private TextView tv_week;
	private TextView tv_today;
	private MonthDateView monthDateView;
	PopupWindow popWindow;
	public void initPopWindow(){//日历
		View view = inflater.inflate(R.layout.activity_date, null);
		iv_left = (ImageView)view. findViewById(R.id.iv_left);
		iv_right = (ImageView) view.findViewById(R.id.iv_right);
		monthDateView = (MonthDateView) view. findViewById(R.id.monthDateView);
		tv_date = (TextView) view. findViewById(R.id.date_text);
		tv_week  =(TextView) view. findViewById(R.id.week_text);
		tv_today = (TextView) view. findViewById(R.id.tv_today);
		monthDateView.setTextView(tv_date,tv_week);
		popWindow = new PopupWindow(view,
               LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
		  popWindow.setOutsideTouchable(true);
		  popWindow.setBackgroundDrawable(new BitmapDrawable());
		  popWindow.showAsDropDown(pull_down, 0, 0);//气泡的位置
		  //日历的点击位置
		  popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
			@Override
			public void onDismiss() {
				pull_down.setChecked(false);
			}
		});
		  monthDateView.setDateClick(new DateClick() {
				@Override
				public void onClickOnDate() {
					int numb=monthDateView.getmSelDay();
					if(numb!=0){
						shijian.setText(tv_date.getText().toString()+numb+"日");
					}
				}
			});
			setOnlistener();
	}
	private void setOnlistener(){
		 iv_left.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					monthDateView.onLeftClick();
				}
			});
			iv_right.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					monthDateView.onRightClick();
				}
			});
			tv_today.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					monthDateView.setTodayToView();
			
				}
			});
	}
	// 调用相机功能照相
	public void getPhoto(View v) {
		String path = Environment.getExternalStorageDirectory()
				+ File.separator + "image.png";
		File file = new File(path);
		uri = Uri.fromFile(file);
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 定义调用相机并取回图片的Intent意图
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
		intent.putExtra("return-data", true);
		// 将图片保存到指定的存储路径 // 将图片保存到指定的存储路径
		this.startActivityForResult(intent, 1);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == Activity.RESULT_OK) {
			Bitmap bitmap;
			try {
				bitmap = BitmapFactory.decodeStream(getContentResolver()
						.openInputStream(uri));
				simpleAdapter.notifyDataSetChanged();
				ivxiugai.setImageBitmap(bitmap);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Bitmap bitmap=(Bitmap)data.getExtras().get("data");
			

		}

		else {
			finish();
		}
	}

	// simpleAdapter的数据
	private List<Map<String, Object>> data() {
		list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("times", "2016");
		map.put("mothday", "02.10");
		map.put("timelife", "生命，是一个过程，可悲的是它不能重来，可喜的是它也不需要重来。");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("times", "2016");
		map.put("mothday", "02.10");
		map.put("timelife", "生命，是一个过程，可悲的是它不能重来，可喜的是它也不需要重来。");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("times", "2016");
		map.put("mothday", "02.10");
		map.put("timelife", "生命，是一个过程，可悲的是它不能重来，可喜的是它也不需要重来。");
		list.add(map);
		return list;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btfhmine:
			startActivity(new Intent(TimefusiondeletesActivity.this,
					BottonNavigationActivity.class));
			break;

		default:
			break;
		}

	}

}
