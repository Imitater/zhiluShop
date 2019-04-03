package com.mouqukeji.zhailushop.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.ui.widget.SmoothCheckBox;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class CarItemRecyclerviewAdapter extends BaseQuickAdapter {


    private SmoothCheckBox smoothCheckBox;

    public CarItemRecyclerviewAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId,data);
    }
    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        Glide.with(mContext).load("https://img.zcool.cn/community/01abe5554941120000019ae98b7732.jpg@1280w_1l_2o_100sh.jpg")
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(10, 0))).into((ImageView) helper.getView(R.id.car_item_iv));
        smoothCheckBox = helper.getView(R.id.car_item_checkbox);
    }
    public void setSmoothCheckBoxCheck(boolean flag){
        smoothCheckBox.setChecked(flag,true);
    }
}
