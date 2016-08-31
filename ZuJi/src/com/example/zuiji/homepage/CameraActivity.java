package com.example.zuiji.homepage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zuji.BottonNavigationActivity;
import com.example.zuji.R;

public class CameraActivity extends Activity{
	ImageButton fanhui;
	ImageButton xiangce;
	ImageButton	dengguang;
	ImageButton jingtou;
	ImageButton chongpai;
	ImageButton paizhao;
	ImageButton xiushi;
	ImageView view;
	Uri uri;//文件
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.activity_camera);
	fanhui = (ImageButton)findViewById(R.id.camera_quxiao_btn);
	 xiangce = (ImageButton)findViewById(R.id.camera_xiangce_btn);
	 dengguang = (ImageButton)findViewById(R.id.camera_flashlight_btn);
	 jingtou = (ImageButton)findViewById(R.id.camera_transform_btn);
	 chongpai = (ImageButton)findViewById(R.id.camera_chongpai_btn);
	 paizhao = (ImageButton)findViewById(R.id.camera_photograph_btn);
	 xiushi = (ImageButton)findViewById(R.id.camera_xiushi_btn);
	 
	fanhui.setOnClickListener(onClickListener);
	paizhao.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.camera_quxiao_btn:
				Intent intent = new Intent(CameraActivity.this,BottonNavigationActivity.class);
				startActivity(intent);// start开始 执行Intent意图【跳转】
				break;
			case R.id.camera_photograph_btn:
				Intent paizhao = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//调用相机功能
				paizhao.putExtra(MediaStore.EXTRA_OUTPUT,uri);//输出
				startActivityForResult(paizhao,1);
			case R.id.camera_xiangce_btn:
				Intent xiangce = new Intent(Intent.ACTION_GET_CONTENT);
				xiangce.addCategory(Intent.CATEGORY_OPENABLE);
				xiangce.setType("image/*");
				xiangce.putExtra("crop", "true");
				xiangce.putExtra("outputX",230);
				xiangce.putExtra("outputY", 230);
				xiangce.putExtra("return-data", true);
				startActivityForResult(xiangce, 1);
			default:
				break;
			}
		}	
	};
	 /**
	   * 相机
	   */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {  
            String sdStatus = Environment.getExternalStorageState();  
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用  
                Log.i("TestFile",  
                        "SD card is not avaiable/writeable right now.");  
                return;  
            }  
            new DateFormat();  
            String name = DateFormat.format("yyyyMMdd_hhmmss",Calendar.getInstance(Locale.CHINA)) + ".jpg";   
            Toast.makeText(this, name, Toast.LENGTH_LONG).show();  
            Bundle bundle = data.getExtras();  
            Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式  
            FileOutputStream b = null;           
            File file = new File("/sdcard/Image/");  
            file.mkdirs();// 创建文件夹  
            String fileName = "/sdcard/Image/"+name;  
  
            try {  
                b = new FileOutputStream(fileName);  
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
            } finally {  
                try {  
                    b.flush();  
                    b.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            try  
            {  
                view.setImageBitmap(bitmap);// 将图片显示在ImageView里  
            }
            catch(Exception e)  
            {  
                Log.e("error", e.getMessage());  
            }  
              
        }  
	};
	
}
