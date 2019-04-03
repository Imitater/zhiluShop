package com.mouqukeji.zhailushop.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mouqukeji.zhailushop.R;

public class MySortView extends LinearLayout implements View.OnClickListener {

    private TextView mySortDefaul;
    private TextView mySortNew;
    private LinearLayout mySortPrice;
    private ImageView mySortPriceTop;
    private ImageView mySortPriceBottom;
    private ImageView mySortDiscountTop;
    private ImageView mySortDiscountBottom;
    private LinearLayout mySortDiscount;
    private TextView mySortSelect;
    private TextView mySortPriceTv;
    private TextView mySortDiscounTv;
    private boolean discountFlag=true;
    private boolean priceFlag=true;
    public MySortView(Context context) {
        super(context);
    }

    public MySortView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySortView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init() {
        View inflate = inflate(getContext(), R.layout.my_sort, this);
        mySortDefaul = inflate.findViewById(R.id.my_sort_defaul);
        mySortNew = inflate.findViewById(R.id.my_sort_new);
        mySortPrice = inflate.findViewById(R.id.my_sort_price);
        mySortPriceTop = inflate.findViewById(R.id.my_sort_price_top);
        mySortPriceBottom = inflate.findViewById(R.id.my_sort_price_bottom);
        mySortDiscountTop = inflate.findViewById(R.id.my_sort_discount_top);
        mySortDiscountBottom = inflate.findViewById(R.id.my_sort_discount_bottom);
        mySortDiscount = inflate.findViewById(R.id.my_sort_discount);
        mySortSelect = inflate.findViewById(R.id.my_sort_select);
        mySortPriceTv = inflate.findViewById(R.id.my_sort_price_tv);
        mySortDiscounTv = inflate.findViewById(R.id.my_sort_discount_tv);
        //点击事件
        initListener();
    }

    private void initListener() {
        mySortDefaul.setOnClickListener(this);
        mySortNew.setOnClickListener(this);
        mySortPrice.setOnClickListener(this);
        mySortDiscount.setOnClickListener(this);
        mySortSelect.setOnClickListener(this);
    }

     @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_sort_defaul://默认
                mySortDefaul.setTextColor(getResources().getColor(R.color.black));
                mySortNew.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortPriceTv.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortDiscounTv.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortSelect.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortPriceTop.setBackgroundResource(R.mipmap.mipmap_gray_sort_up);
                mySortPriceBottom.setBackgroundResource(R.mipmap.mipmap_gray_sort_down);
                mySortDiscountTop.setBackgroundResource(R.mipmap.mipmap_gray_sort_up);
                mySortDiscountBottom.setBackgroundResource(R.mipmap.mipmap_gray_sort_down);
                discountFlag=true;
                priceFlag=true;
                break;
            case R.id.my_sort_discount://折扣
                mySortDefaul.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortNew.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortPriceTv.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortDiscounTv.setTextColor(getResources().getColor(R.color.black));
                mySortSelect.setTextColor(getResources().getColor(R.color.sort_gray));
                if (discountFlag) {
                    mySortDiscountTop.setBackgroundResource(R.mipmap.mipmap_black_sort_up);
                    mySortDiscountBottom.setBackgroundResource(R.mipmap.mipmap_gray_sort_down);
                    discountFlag=false;
                }else{
                    mySortDiscountTop.setBackgroundResource(R.mipmap.mipmap_gray_sort_up);
                    mySortDiscountBottom.setBackgroundResource(R.mipmap.mipmap_black_sort_down);
                    discountFlag=true;
                }
                mySortPriceTop.setBackgroundResource(R.mipmap.mipmap_gray_sort_up);
                mySortPriceBottom.setBackgroundResource(R.mipmap.mipmap_gray_sort_down);
                break;
            case R.id.my_sort_price://价格
                mySortDefaul.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortNew.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortPriceTv.setTextColor(getResources().getColor(R.color.black));
                mySortDiscounTv.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortSelect.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortDiscountTop.setBackgroundResource(R.mipmap.mipmap_gray_sort_up);
                mySortDiscountBottom.setBackgroundResource(R.mipmap.mipmap_gray_sort_down);
                if (priceFlag) {
                    mySortPriceTop.setBackgroundResource(R.mipmap.mipmap_black_sort_up);
                    mySortPriceBottom.setBackgroundResource(R.mipmap.mipmap_gray_sort_down);
                    priceFlag=false;
                }else{
                    mySortPriceTop.setBackgroundResource(R.mipmap.mipmap_gray_sort_up);
                    mySortPriceBottom.setBackgroundResource(R.mipmap.mipmap_black_sort_down);
                    priceFlag=true;
                }
                break;
            case R.id.my_sort_new://最新
                mySortDefaul.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortNew.setTextColor(getResources().getColor(R.color.black));
                mySortPriceTv.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortDiscounTv.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortSelect.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortPriceTop.setBackgroundResource(R.mipmap.mipmap_gray_sort_up);
                mySortPriceBottom.setBackgroundResource(R.mipmap.mipmap_gray_sort_down);
                mySortDiscountTop.setBackgroundResource(R.mipmap.mipmap_gray_sort_up);
                mySortDiscountBottom.setBackgroundResource(R.mipmap.mipmap_gray_sort_down);
                discountFlag=true;
                priceFlag=true;
                break;
            case R.id.my_sort_select://筛选
                mySortDefaul.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortNew.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortPriceTv.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortDiscounTv.setTextColor(getResources().getColor(R.color.sort_gray));
                mySortSelect.setTextColor(getResources().getColor(R.color.black));
                mySortPriceTop.setBackgroundResource(R.mipmap.mipmap_gray_sort_up);
                mySortPriceBottom.setBackgroundResource(R.mipmap.mipmap_gray_sort_down);
                mySortDiscountTop.setBackgroundResource(R.mipmap.mipmap_gray_sort_up);
                mySortDiscountBottom.setBackgroundResource(R.mipmap.mipmap_gray_sort_down);
                discountFlag=true;
                priceFlag=true;
                break;
        }
    }
}
