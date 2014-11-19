package com.roger.zoomviewpager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.roger.zoomviewpager.R;
import com.nineoldandroids.view.ViewHelper;
import com.roger.zoomviewpager.library.OutlineContainer;
import com.roger.zoomviewpager.library.ZoomViewPager;

public class MainActivity extends Activity {

	private ZoomViewPager mZoom_pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mZoom_pager = (ZoomViewPager) findViewById(R.id.Zoom_pager);
		mZoom_pager.setAdapter(new MainAdapter());
		mZoom_pager.setOffscreenPageLimit(3);
		mZoom_pager.setPageMargin(5);
	}

	private class MainAdapter extends PagerAdapter {
		boolean isFirstLoad;

		@Override
		public Object instantiateItem(ViewGroup container, final int position) {
			TextView text = new TextView(MainActivity.this);
			text.setGravity(Gravity.CENTER);
			text.setTextSize(30);
			text.setTextColor(Color.WHITE);
			text.setText("Page " + position);
			text.setPadding(30, 30, 30, 30);
			int bg = Color.rgb((int) Math.floor(Math.random() * 128) + 64, (int) Math.floor(Math.random() * 128) + 64, (int) Math.floor(Math.random() * 128) + 64);
			text.setBackgroundColor(bg);
			container.addView(text, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			mZoom_pager.setObjectForPosition(text, position);// 设置对象
			if (position != 0) {// 加载页面时候将其初始化大小，第一个View不需要
				ViewHelper.setScaleX(text, 0.8f);
				ViewHelper.setScaleY(text, 0.8f);
				isFirstLoad = true;
			}
			if (position == 0 && isFirstLoad) {// 回划到第一个view的时候也要初始化大小
				ViewHelper.setScaleX(text, 0.8f);
				ViewHelper.setScaleY(text, 0.8f);
			}
			return text;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object obj) {
			container.removeView(mZoom_pager.findViewFromObject(position));
		}

		@Override
		public int getCount() {
			return 10;
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			if (view instanceof OutlineContainer) {
				return ((OutlineContainer) view).getChildAt(0) == obj;
			} else {
				return view == obj;
			}
		}
	}
}
