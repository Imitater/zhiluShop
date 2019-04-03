package com.mouqukeji.zhailushop.ui.widget;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

public class MyScrollView  extends NestedScrollView {
    private ScrollChangedListener mListener;

    public MyScrollView(Context context) {
        super(context);
    }
    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(mListener != null){
            mListener.onScrollChanged(l,t,oldl,oldt);
        }
    }

    public void setScrollChangedListener(ScrollChangedListener listener){
        mListener = listener;
    }

    public static interface ScrollChangedListener{
        void onScrollChanged(int l, int t, int oldl, int oldt);
    }
}

