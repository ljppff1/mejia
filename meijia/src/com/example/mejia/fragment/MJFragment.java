package com.example.mejia.fragment;import java.util.ArrayList;import java.util.List;import com.example.meijia.R;import com.example.mejia.adapter.ViewPagerAdapter;import com.example.mejia.ui.ChooseCity;import com.example.mejia.util.BitmapUtils;import com.example.mejia.util.Context;import android.app.Activity;import android.app.AlertDialog;import android.content.Intent;import android.graphics.BitmapFactory;import android.os.Bundle;import android.support.annotation.Nullable;import android.support.v4.app.Fragment;import android.support.v4.view.ViewPager;import android.support.v4.view.ViewPager.OnPageChangeListener;import android.view.LayoutInflater;import android.view.View;import android.view.Window;import android.view.View.OnClickListener;import android.view.ViewGroup;import android.widget.ImageView;import android.widget.LinearLayout;import android.widget.RelativeLayout;import android.widget.TextView;public class MJFragment extends Fragment implements OnPageChangeListener, OnClickListener{	private ViewPager vp;	private ViewPagerAdapter vpAdapter;	private List<View> views;	private int width;	private int height;		private RelativeLayout relativeLayout;		private static final int[] pics = { R.drawable.home1, R.drawable.home2,			R.drawable.home3, R.drawable.home4 };	private ImageView[] dots;	private int currentIndex;	private View view;	private TextView mTvlocal;	@Override	public void onCreate(Bundle savedInstanceState) {		super.onCreate(savedInstanceState);			}			@Override	public void onResume() {		 mTvlocal.setText(Context.city);			 super.onResume();		 	}		@Override	public View onCreateView(final LayoutInflater inflater, ViewGroup container,			Bundle savedInstanceState) {		 view			=  inflater.inflate(R.layout.index, container, false);		 width	= getActivity().getWindowManager().getDefaultDisplay().getWidth();		 height	 =getActivity().getWindow().getWindowManager()			.getDefaultDisplay().getHeight() /4;		 mTvlocal=   (TextView)view.findViewById(R.id.mTvlocal);		 mTvlocal.setText(Context.city);		 mTvlocal.setOnClickListener(new OnClickListener() {						@Override			public void onClick(View v) {				         startActivity(new Intent(getActivity(), ChooseCity.class));			}		});		 relativeLayout			=(RelativeLayout) view.findViewById(R.id.relative);		 LinearLayout.LayoutParams layoutParams	= (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();		 layoutParams.width			=width;		 layoutParams.height		=height;		 relativeLayout.setLayoutParams(layoutParams);		 		views = new ArrayList<View>();		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(				LinearLayout.LayoutParams.WRAP_CONTENT,				LinearLayout.LayoutParams.WRAP_CONTENT);		for (int i = 0; i < pics.length; i++) {			ImageView iv = new ImageView(getActivity());			iv.setLayoutParams(mParams);			iv.setImageBitmap(BitmapUtils.zoomImage(BitmapFactory.decodeResource(getResources(), pics[i]), width, height));			views.add(iv);		}		vp = (ViewPager) view.findViewById(R.id.viewpager);				RelativeLayout.LayoutParams params		= new RelativeLayout.LayoutParams(width, height);		params.leftMargin=10;		params.topMargin=10;		params.rightMargin=10;		vp.setLayoutParams(params);				vpAdapter = new ViewPagerAdapter(views);		vp.setAdapter(vpAdapter);		vp.setOnPageChangeListener(this);		initDots();		return view;	}		private void initDots() {		LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll);		dots = new ImageView[pics.length];		for (int i = 0; i < pics.length; i++) {			dots[i] = (ImageView) ll.getChildAt(i);			dots[i].setEnabled(true);			dots[i].setOnClickListener(this);			dots[i].setTag(i);		}		currentIndex = 0;		dots[currentIndex].setEnabled(false);	}	private void setCurView(int position) {		if (position < 0 || position >= pics.length) {			return;		}		vp.setCurrentItem(position);	}	private void setCurDot(int positon) {		if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {			return;		}		dots[positon].setEnabled(false);		dots[currentIndex].setEnabled(true);		currentIndex = positon;	}	@Override	public void onPageScrollStateChanged(int arg0) {	}	@Override	public void onPageScrolled(int arg0, float arg1, int arg2) {		vp.requestDisallowInterceptTouchEvent(true);	}	@Override	public void onPageSelected(int arg0) {		setCurDot(arg0);	}	@Override	public void onClick(View view) {		int position = (Integer) view.getTag();		setCurView(position);		setCurDot(position);	}		}