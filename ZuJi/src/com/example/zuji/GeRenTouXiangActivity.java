package com.example.zuji;

import java.io.File;
import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

public class GeRenTouXiangActivity extends Activity {
	ImageButton touxiangReturn;
	LinearLayout xuanzedialog;
	ImageView touxiangImage;
	Uri uri;
	 PopupWindow popupwindow;
	LayoutInflater inflater;
	TextView Photo,xiangce,baocun,quxiao;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gerentouxiang);

		touxiangReturn = (ImageButton) findViewById(R.id.touxiang_return);
		xuanzedialog = (LinearLayout) findViewById(R.id.caidan_touxiang);
		touxiangImage = (ImageView) findViewById(R.id.touxiang_image);

		xuanzedialog.setOnClickListener(onClickListener);
		touxiangReturn.setOnClickListener(onClickListener);
		
		inflater=LayoutInflater.from(this);
		View view=inflater.inflate(R.layout.gerentouxiang_menu,null);
		Photo = (TextView)view.findViewById(R.id.paizhao_touxiang);
		xiangce = (TextView)view.findViewById(R.id.cong_touxiang);
		baocun = (TextView)view.findViewById(R.id.baocun_touxiang);
		quxiao = (TextView)view.findViewById(R.id.quxiao_touxiang);
		
		Photo.setOnClickListener(onClickListener);
		xiangce.setOnClickListener(onClickListener);
		baocun.setOnClickListener(onClickListener);
		quxiao.setOnClickListener(onClickListener);

		popupwindow=new PopupWindow(view,LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT,false);
		popupwindow.setBackgroundDrawable(new BitmapDrawable());//设置此参数，点击外边可以消失
		//popupwindow.setOutsideTouchable(true);//设置点击窗口外边，窗口消失
		popupwindow.setFocusable(true);//设置此参数获得焦点，否则无法点击
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.touxiang_return:
					Intent intent=new Intent(GeRenTouXiangActivity.this,GeRenZiLiaoActivity.class);
					startActivity(intent);
				break;
			case R.id.caidan_touxiang:
				if(popupwindow.isShowing()){
					popupwindow.dismiss();//隐藏窗口
				}else{
					popupwindow.showAtLocation(v,Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);//显示窗口
				}
				break;
			case R.id.paizhao_touxiang:
				 getPhoto(v);
				
				break;
			case R.id.cong_touxiang:
				break;
			case R.id.baocun_touxiang:
				break;
			case R.id.quxiao_touxiang:
				popupwindow.dismiss();//隐藏窗口
				break;
			default:
				break;
			}
		}
	};


	// 调用相机功能照相
	public void getPhoto(View v) {
		String path = Environment.getExternalStorageDirectory()
				+ File.separator + "image.png";
		File file = new File(path);
		uri = Uri.fromFile(file);
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 定义调用相机并取回图片的Intent意图
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
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
				touxiangImage.setImageBitmap(bitmap);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else {
			finish();
		}
	}
/*//从本地相册中选择图片
	private final String IMAGE_TYPE = "image/*";
	private final int IMAGE_CODE = 0; //这里的IMAGE_CODE是自己任意定义的
	private void setImage(){
			
			//使用intent调用系统提供的相册功能，使用startActivityForResult是为了获取用户选择的图片
			Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
			getAlbum.setType(IMAGE_TYPE);
			startActivityForResult(getAlbum, IMAGE_CODE);
			//重写onActivityResult以获得你需要的信息
			@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
				if (resultCode != RESULT_OK) { //此处的 RESULT_OK 是系统自定义得一个常量
					Log.e(TAG,"ActivityResult resultCode error");
					return;
		}
				Bitmap bm = null;
				//外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口
				ContentResolver resolver = getContentResolver();
				//此处的用于判断接收的Activity是不是你想要的那个
				if (requestCode == IMAGE_CODE) {
						Uri originalUri = data.getData(); //获得图片的uri
						bm = MediaStore.Images.Media.getBitmap(resolver, originalUri); //显得到bitmap图片
				}
		}
	}*/
}