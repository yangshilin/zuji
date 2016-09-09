package com.example.zuji;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.xuactivity.Mine_Fragment;
import com.example.zuiji.homepage.CameraActivity;
import com.example.zuiji.homepage.HomepageFragment;

@SuppressLint("NewApi")
public class BottonNavigationActivity extends FragmentActivity {
	private int backPressedTimes = 0;
	RadioGroup radioGroup;
	RadioButton btn_homepage;// 首页
	RadioButton btn_community;// 社交
	RadioButton btn_message;// 消息
	RadioButton btn_my;// 我
	LinearLayout replace_layout;
	SheQu_Fragment shequ_fragment = new SheQu_Fragment();
	Fragment_XiaoXi fragment_XiaoXi = new Fragment_XiaoXi();
	Mine_Fragment mine_Fragment = new Mine_Fragment();
	HomepageFragment homepageFragment = new HomepageFragment();
	FragmentManager fm = getSupportFragmentManager();
	ImageButton camera;// 相机

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题拦
		setContentView(R.layout.activity_botton_navigation);
		// setFragment(R.id.btn_homepage);

		replace_layout = (LinearLayout) findViewById(R.id.replace_layout);
		radioGroup = (RadioGroup) findViewById(R.id.navigation_radiogroup);
		radioGroup.setOnCheckedChangeListener(CheckedChangeListener);// 选中改变的监听
		btn_homepage = (RadioButton) findViewById(R.id.btn_homepage);
		btn_community = (RadioButton) findViewById(R.id.btn_community);
		btn_message = (RadioButton) findViewById(R.id.btn_message);
		btn_my = (RadioButton) findViewById(R.id.btn_my);
		camera = (ImageButton) findViewById(R.id.navigation_camera_btn);
		camera.setOnClickListener(xiangji);
		setFragment(R.id.btn_homepage);
		setchecked(R.id.btn_homepage);
	}

	OnCheckedChangeListener CheckedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			setFragment(checkedId);// 自定义生成Fragment判断方法——用于判断Fragment切换
			setchecked(checkedId);// 自定义生成【选中】方法 ——此处用于字体切换
			switch (checkedId) {

			default:
				break;
			}
		}

	};

	private void setchecked(int Id) {
		switch (Id) {
		case R.id.btn_homepage:
			btn_homepage.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.homepage_ischeck),
					null, null);// 选中图片更换为 靓图
			btn_community.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.shequ), null, null);
			btn_message.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.message), null, null);
			btn_my.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
					.getDrawable(R.drawable.my), null, null);
			btn_homepage
					.setTextColor(getResources().getColor(R.color.deegreen));// 选中为深蓝色
			btn_community.setTextColor(getResources().getColor(R.color.black));// 未选中为黑色
			btn_message.setTextColor(getResources().getColor(R.color.black));
			btn_my.setTextColor(getResources().getColor(R.color.black));
			break;
		case R.id.btn_community:
			btn_homepage
					.setCompoundDrawablesWithIntrinsicBounds(null,
							getResources().getDrawable(R.drawable.homepage),
							null, null);
			btn_community.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.shequ_ischeck), null,
					null);
			btn_message.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.message), null, null);
			btn_my.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
					.getDrawable(R.drawable.my), null, null);

			btn_homepage.setTextColor(getResources().getColor(R.color.black));
			btn_community.setTextColor(getResources()
					.getColor(R.color.deegreen));
			btn_message.setTextColor(getResources().getColor(R.color.black));
			btn_my.setTextColor(getResources().getColor(R.color.black));
			break;
		case R.id.btn_message:
			btn_homepage
					.setCompoundDrawablesWithIntrinsicBounds(null,
							getResources().getDrawable(R.drawable.homepage),
							null, null);
			btn_community.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.shequ), null, null);
			btn_message.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.message_ischeck),
					null, null);
			btn_my.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
					.getDrawable(R.drawable.my), null, null);

			btn_homepage.setTextColor(getResources().getColor(R.color.black));
			btn_community.setTextColor(getResources().getColor(R.color.black));
			btn_message.setTextColor(getResources().getColor(R.color.deegreen));
			btn_my.setTextColor(getResources().getColor(R.color.black));
			break;
		case R.id.btn_my:
			btn_homepage
					.setCompoundDrawablesWithIntrinsicBounds(null,
							getResources().getDrawable(R.drawable.homepage),
							null, null);
			btn_community.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.shequ), null, null);
			btn_message.setCompoundDrawablesWithIntrinsicBounds(null,
					getResources().getDrawable(R.drawable.message), null, null);
			btn_my.setCompoundDrawablesWithIntrinsicBounds(null, getResources()
					.getDrawable(R.drawable.my_ischeck), null, null);

			btn_homepage.setTextColor(getResources().getColor(R.color.black));
			btn_community.setTextColor(getResources().getColor(R.color.black));
			btn_message.setTextColor(getResources().getColor(R.color.black));
			btn_my.setTextColor(getResources().getColor(R.color.deegreen));
			break;

		default:
			break;
		}

	}

	private void setFragment(int R_id) {
		// 碎片Manager管理人员——获得Support支持碎片管理
		FragmentTransaction ft = fm.beginTransaction();// 碎片管理begin开始处理Transaction事物
		switch (R_id) {
		case R.id.btn_homepage:
			ft.replace(R.id.replace_layout, homepageFragment);// replace替换——【Fragment替换viewoager内容】
			ft.commit();// commit委托
			break;
		case R.id.btn_community:
			ft.replace(R.id.replace_layout, shequ_fragment);
			ft.commit();
			break;
		case R.id.btn_message:
			ft.replace(R.id.replace_layout, fragment_XiaoXi);
			ft.commit();
			break;
		case R.id.btn_my:
			ft.replace(R.id.replace_layout, mine_Fragment);
			ft.commit();
			break;
		default:
			break;
		}
	}

	OnClickListener xiangji = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.navigation_camera_btn:
				Intent intent = new Intent(BottonNavigationActivity.this,
						CameraActivity.class);
				startActivity(intent);
				break;

			default:
				break;
			}
		}

	};

	@Override
	public void onBackPressed() {
		if (backPressedTimes == 0) {
			Toast.makeText(BottonNavigationActivity.this, "再按一次退出程序", 1).show();
			backPressedTimes = 1;
			new Thread() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						this.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						backPressedTimes = 0;
					}

				}
			}.start();
			return;
		} else {
			finish();
			System.exit(0);
		}

	}

}
