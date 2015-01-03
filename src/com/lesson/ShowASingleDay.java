package com.lesson;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ShowASingleDay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// ȥ��Ӧ�õı�����
		this.setRequestedOrientation(1);

		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(1);

		ScrollView sv = new ScrollView(this);
		sv.setVerticalFadingEdgeEnabled(false);

		LinearLayout ll_in = new LinearLayout(this);
		ll_in.setOrientation(1);

		String temp[] = getIntent().getStringExtra("info").split("\\|");

		TextView tv_day = new TextView(this);
		tv_day.setText("����" + temp[0]);
		tv_day.setTextSize(35);
		tv_day.setTextColor(Color.BLACK);
		tv_day.setBackgroundColor(Color.WHITE);
		tv_day.setGravity(Gravity.CENTER);

		String lesson = temp[0];

		int colorBkg[] = { Color.BLACK, Color.LTGRAY };
		int color[] = { Color.WHITE, Color.BLACK };
		ll.addView(tv_day);
		for (int i = 1, j = 0; i < temp.length; i++) {

			final String singleLesson[] = temp[i].split("#");

			TextView tv = new TextView(this);
			tv.setTextSize(25);
			try {

				if (singleLesson.length > 5) {
					tv.setText("��" + i + "��\n\t\t\t" + singleLesson[0]
							+ "\n\t\t\t\t\t\t����:" + singleLesson[3]
							+ "\n\t\t\t\t\t\tʱ��:" + singleLesson[1]
							+ "\n\t\t\t\t\t\t��ʦ:" + singleLesson[2]
							+ "\n\t\t\t" + singleLesson[6]
							+ "\n\t\t\t\t\t\t����:" + singleLesson[9]
							+ "\n\t\t\t\t\t\tʱ��:" + singleLesson[7]
							+ "\n\t\t\t\t\t\t��ʦ:" + singleLesson[8]);
				} else {
					tv.setText("��" + i + "��\n\t\t\t" + singleLesson[0]
							+ "\n\t\t\t\t\t\t����:" + singleLesson[3]
							+ "\n\t\t\t\t\t\tʱ��:" + singleLesson[1]
							+ "\n\t\t\t\t\t\t��ʦ:" + singleLesson[2]);

				}

			} catch (ArrayIndexOutOfBoundsException e) {
				tv.setText("��" + i + "��\n\t\t\t��");

			}
			if (temp[i].endsWith(lesson)) {
				tv.setTextColor(color[j % 2]);
				tv.setBackgroundColor(colorBkg[j % 2]);

				if (lesson.equals("��")) {
					tv.setText("��" + i + "��\n\t\t\t��");
				} else {
					tv.setText("��" + i + "��\n\t\t\tͬ��");
				}

			} else {
				j++;
				tv.setTextColor(color[j % 2]);
				tv.setBackgroundColor(colorBkg[j % 2]);
			}

			if (i == 1) {
				TextView tv2 = new TextView(this);
				tv2.setText("����8:00");
				tv2.setTextSize(25);
				tv2.setGravity(Gravity.CENTER);
				tv2.setBackgroundColor(Color.RED);
				tv2.setTextColor(Color.YELLOW);
				ll_in.addView(tv2);

			}

			if (i == 5) {
				TextView tv2 = new TextView(this);
				tv2.setText("����1:30");
				tv2.setTextSize(25);
				tv2.setGravity(Gravity.CENTER);
				tv2.setBackgroundColor(Color.RED);
				tv2.setTextColor(Color.YELLOW);
				
				ll_in.addView(tv2);

			}
			
			if (i == 9) {
				TextView tv2 = new TextView(this);
				tv2.setText("����6:30");
				tv2.setTextSize(25);
				tv2.setGravity(Gravity.CENTER);
				tv2.setBackgroundColor(Color.RED);
				tv2.setTextColor(Color.YELLOW);
				
				ll_in.addView(tv2);

			}
			
			

			lesson = temp[i];

			ll_in.addView(tv);

		}

		sv.addView(ll_in);
		ll.addView(sv);
		setContentView(ll);
	}
}
