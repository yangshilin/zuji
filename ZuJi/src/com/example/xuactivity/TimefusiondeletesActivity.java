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
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

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
		 ShareSDK.initSDK(this);
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
			
			timeshare.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {// 分享
					showShare();		
					//share();
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
	
	
	private void showShare() {//分享
		 ShareSDK.initSDK(this);
		 OnekeyShare oks = new OnekeyShare();
		 //关闭sso授权
		 oks.disableSSOWhenAuthorize(); 

		// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
		 //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
		 // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
		 oks.setTitle(getString(R.string.app_version));
		 // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
		// oks.setTitleUrl("http://sharesdk.cn");
		 // text是分享文本，所有平台都需要这个字段
		 oks.setText("我是分享文本");
		 //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
		 oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
		 // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
		 //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
		 // url仅在微信（包括好友和朋友圈）中使用
		// oks.setUrl("http://sharesdk.cn");
		 // comment是我对这条分享的评论，仅在人人网和QQ空间使用
		 oks.setComment("我是测试评论文本");
		 // site是分享此内容的网站名称，仅在QQ空间使用
		 oks.setSite(getString(R.string.app_name));
		 // siteUrl是分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl("http://sharesdk.cn");

		// 启动分享GUI
		 oks.show(this);
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
		startPhotoZoom(uri);
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 定义调用相机并取回图片的Intent意图
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
		intent.putExtra("return-data", true);
		// 将图片保存到指定的存储路径 // 将图片保存到指定的存储路径
		this.startActivityForResult(intent, 1);

	}
	public void startPhotoZoom(Uri uri) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// 设置裁剪
		intent.putExtra("crop", "true");
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1.2);
		intent.putExtra("aspectY", 1);
		// outputX outputY 是裁剪图片宽高
		intent.putExtra("outputX", 50);
		intent.putExtra("outputY", 60);
		/*intent.putExtra("return-data", true);
		startActivityForResult(intent, 2);*/
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
				e.printStackTrace();
			}
			

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
