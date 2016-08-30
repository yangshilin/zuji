package com.example.zuji;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

public class GeRenTouXiangActivity extends Activity {
	private final int paizhao = 0;
	private final int xuanze = 1;
	private final int baocun = 2;
	private final int quxiao = 3;
	ImageButton touxiangReturn;
	LinearLayout xuanzedialog;
	GridView gridview;
	ImageView touxiangImage;
	Uri uri;

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
				showMenu();

				break;

			default:
				break;
			}
		}
	};

	

	public void showMenu() {
		gridview = (GridView) findViewById(R.id.touxiang_griview);
		gridview.setGravity(Gravity.BOTTOM);
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ItemText", "拍照");
		list.add(map);
		SimpleAdapter adapter = new SimpleAdapter(this, list,
				R.layout.gerentouxiang_menu, new String[] { "ItemText" },
				new int[] { R.id.paizhao_touxiang });
		gridview.setAdapter(adapter);
		gridview.setOnItemClickListener(onItemClickListener);
	}

	OnItemClickListener onItemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View V, int position,
				long id) {
			// TODO Auto-generated method stub
			switch (position) {
			case paizhao:
				getPhoto(V);
				break;
			case xuanze:
				Intent intent2 = new Intent(GeRenTouXiangActivity.this,
						SheZhiActivity.class);
				startActivity(intent2);
				break;
			case baocun:
				Intent intent3 = new Intent(GeRenTouXiangActivity.this,
						SheZhiActivity.class);
				startActivity(intent3);
				break;
			case quxiao:
				Intent intent4 = new Intent(GeRenTouXiangActivity.this,
						SheZhiActivity.class);
				startActivity(intent4);
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