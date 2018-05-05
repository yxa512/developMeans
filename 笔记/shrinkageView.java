package com.example.example;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 自定义收缩栏，提供标题和右边view修改方法
 * 继承LinearLayout，默认上下布局，把想要收缩的组件添加到应用xml即可
 * @Description: TODO
 *
 * @author yxa512
 * @date 2015-11-15 下午6:34:50
 */
public class shrinkageView extends LinearLayout{

	private TextView titleTV;//left
	private TextView adddTV;//right
	private boolean isOpen = false;//默认收缩
	private LinearLayout.LayoutParams lParams;//布局大小
	private LinearLayout mlinearLayout;//标题栏
	
	public shrinkageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		setOrientation(VERTICAL);//默认上下布局
		
		lParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		lParams.setMargins(7, 7, 7, 7);
		
		mlinearLayout = new LinearLayout(context);
		mlinearLayout.setGravity(Gravity.CENTER_VERTICAL);
		titleTV = new TextView(context);
		titleTV.setText("尚未添加标题");
		mlinearLayout.addView(titleTV);
		
		adddTV = new TextView(context);
		adddTV.setText("添加");
		adddTV.setTextSize(50);
		adddTV.setGravity(Gravity.RIGHT | Gravity.CLIP_VERTICAL);
		mlinearLayout.addView(adddTV,lParams);
		
		mlinearLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(isOpen){
					setVisibility(View.GONE);
					
				}else{
					setVisibility(View.VISIBLE);
				}
				isOpen = !isOpen;
			}
		});
		
		addView(mlinearLayout);
		
	}
	
	/**
	 * 加载完全部view后进行隐藏部分View
	 */
	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
		setVisibility(View.GONE);
	}

	/**
	 * 重写了隐藏方法
	 */
	@Override
	public void setVisibility(int visibility) {
		// TODO Auto-generated method stub
		//super.setVisibility(visibility);
		for(int i = 1 ;i < getChildCount();i++){
			getChildAt(i).setVisibility(visibility);
		}
	}
	
	/**
	 * 更改左边TextView的样式
	 * @return
	 */
	public TextView getTitleView(){
		return this.titleTV;
	}
	
	/**
	 * 更改右边View
	 * @param view
	 */
	public void setRightView(View view){
		mlinearLayout.removeViewAt(1);
		mlinearLayout.addView(view,lParams);
	}
}
