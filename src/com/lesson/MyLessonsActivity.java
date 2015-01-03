package com.lesson;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyLessonsActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉应用的标题栏
		this.setRequestedOrientation(1);
		
		
		String date[];
		Resources res = getResources();
		date = res.getStringArray(R.array.city);

		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(1);
		ll.setGravity(Gravity.CENTER);

		for (int i = 0; i < date.length; i++) {
			final TextView tv = new TextView(this);

			final String temp = date[i];

			tv.setText("星期" + (i + 1));
			tv.setTextSize(50);
			tv.setGravity(Gravity.CENTER);

			tv.setBackgroundColor(Color.BLACK);
			tv.setTextColor(Color.WHITE);
			
			tv.setOnTouchListener(new OnTouchListener() {
				public boolean onTouch(View v, MotionEvent event) {
					if (event.getAction() == MotionEvent.ACTION_DOWN) {
						v.setBackgroundColor(Color.WHITE);
						tv.setTextColor(Color.BLACK);
					} else if (event.getAction() == MotionEvent.ACTION_UP) {
						v.setBackgroundColor(Color.BLACK);
						tv.setTextColor(Color.WHITE);
					}
					return false;
				}
			});
			
			
			tv.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
//					Toast.makeText(MyLessonsActivity.this, temp,
//							Toast.LENGTH_LONG).show();
					
					
					Intent intent = new Intent();
					intent .setClass(MyLessonsActivity.this,ShowASingleDay.class);
					
					intent.putExtra("info", temp);
					MyLessonsActivity.this.startActivity(intent);
					
					
				}
			});

			ll.addView(tv);
		}

		setContentView(ll);
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			exit();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	private void exit() {
		AlertDialog.Builder builder = new Builder(MyLessonsActivity.this);
		builder.setMessage("确认退出吗？");
		builder.setTitle("提示");
		builder.setPositiveButton("确认",
				new android.content.DialogInterface.OnClickListener() {

					public void onClick(DialogInterface arg0, int arg1) {
						MyLessonsActivity.this.finish();
						android.os.Process.killProcess(android.os.Process
								.myPid());
					}
				});
		builder.setNegativeButton("取消",
				new android.content.DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
		builder.create().show();

	}
}