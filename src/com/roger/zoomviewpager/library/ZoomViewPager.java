package com.roger.zoomviewpager.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class ZoomViewPager extends RelativeLayout {

	public ZoomViewPager(Context context) {
		super(context);
		init();
		// TODO Auto-generated constructor stub
	}

	public ZoomViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private JazzyViewPager mJazzy;

	@SuppressLint({ "InlinedApi", "NewApi" })
	private void init() {
		this.setClipChildren(false);
		mJazzy = new JazzyViewPager(getContext());
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		params.setMargins(Util.dpToPx(getResources(), 300), 0, Util.dpToPx(getResources(), 300), 0);
		mJazzy.setLayoutParams(params);
		this.addView(mJazzy);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		mJazzy.onTouchEvent(event);
		return true;
	}

	public void setAdapter(PagerAdapter arg0) {
		mJazzy.setAdapter(arg0);
	}

	public void setOffscreenPageLimit(int arg0) {
		mJazzy.setOffscreenPageLimit(arg0);
	}

	public void setPageMargin(int px) {
		mJazzy.setPageMargin(px);
	}

	public void setObjectForPosition(Object obj, int position) {
		mJazzy.setObjectForPosition(obj, position);
	}

	public View findViewFromObject(int position) {
		return mJazzy.findViewFromObject(position);
	}

}