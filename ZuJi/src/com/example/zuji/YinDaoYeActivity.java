package com.example.zuji;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class YinDaoYeActivity extends Activity{
	ViewFlipper viewFlipper;// 视图轮番器
	GestureDetector gestureDetector;
	Context YinDaoYeActivity;
	private Activity mActivity=null;
	ImageView imageView;
	private int[] images={R.drawable.guid_image1,R.drawable.guid_image2,R.drawable.guid_image3,};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yindaoye);
	
		viewFlipper = (ViewFlipper) findViewById(R.id.viewfilpper_id);
		viewFlipper.startFlipping();
		gestureDetector = new GestureDetector(onGestureListener);
		imageView = (ImageView) findViewById(R.id.Imageview_yindao);
		imageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method
				if (v.getId() == R.id.Imageview_yindao) {
					Intent intent = new Intent(YinDaoYeActivity.this,
							DengLuActivity.class);
					startActivity(intent);
				}
			}
		});

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		viewFlipper.stopFlipping();// 点击事件后，停止自动播放
		viewFlipper.setAutoStart(false);
		return gestureDetector.onTouchEvent(event);// 注册手势事件
	}

	OnGestureListener onGestureListener = new OnGestureListener() {

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			// TODO Auto-generated method stub

			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			
			return false;
		}

	};
	/*mActivity=this;
	viewFlipper = (ViewFlipper) findViewById(R.id.viewfilpper_id); 
	gestureDetector = new GestureDetector(this);     // 声明检测手势事件  

    for (int i = 0; i < images.length; i++) {          // 添加图片源  
        ImageView iv = new ImageView(this);  
        iv.setImageResource(images[i]);  
        iv.setScaleType(ImageView.ScaleType.FIT_XY);  
        viewFlipper.addView(iv, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));  
    }  
      
    viewFlipper.setAutoStart(true);         // 设置自动播放功能（点击事件，前自动播放）  
    viewFlipper.setFlipInterval(3000);  
    if(viewFlipper.isAutoStart() && !viewFlipper.isFlipping()){  
        viewFlipper.startFlipping();  
    }  

	/@Override
	public boolean onDown(MotionEvent event) {
		// TODO Auto-generated method stub
		viewFlipper.stopFlipping();// 点击事件后，停止自动播放
		viewFlipper.setAutoStart(false);
		return gestureDetector.onTouchEvent(event);// 注册手势事件
		
	}
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityYS) {
		
		// TODO Auto-generated method stub
		if (e2.getX() - e1.getX() > 1) {// 从左向右滑
			Animation rInAnim = AnimationUtils.loadAnimation(
					YinDaoYeActivity, R.anim.push_right_in);// 向右滑动左侧进入的渐变效果
			Animation rOutAnim = AnimationUtils.loadAnimation(
					YinDaoYeActivity, R.anim.push_right_out);// 向右滑动右侧滑出的渐变效果
			viewFlipper.setInAnimation(rInAnim);
			viewFlipper.setOutAnimation(rOutAnim);
			viewFlipper.showPrevious();
			return true;
		} else if (e2.getX() - e1.getX() < -1) {// 从右向左滑
			Animation lInAnim = AnimationUtils.loadAnimation(
					YinDaoYeActivity, R.anim.push_left_in);// 向左滑动左侧进入的渐变效果
			Animation lOutAnim = AnimationUtils.loadAnimation(
					YinDaoYeActivity, R.anim.push_left_out);// 向左滑动右侧滑出的渐变效果
			viewFlipper.setInAnimation(lInAnim);
			viewFlipper.setOutAnimation(lOutAnim);
			viewFlipper.showNext();
			return true;
		}
		return false;
	}
	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}*/
	
}
