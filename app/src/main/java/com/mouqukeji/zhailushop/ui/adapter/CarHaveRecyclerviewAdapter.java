package com.mouqukeji.zhailushop.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.ui.widget.SmoothCheckBox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class CarHaveRecyclerviewAdapter extends BaseQuickAdapter {
    public CarHaveRecyclerviewAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId,data);
    }
    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        List list=new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            list.add(i);
        }
        RecyclerView carHaveItemRecyclerview=helper.getView(R.id.car_have_item_recyclerview);
        carHaveItemRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        final CarItemRecyclerviewAdapter caritemRecyclerviewAdapter = new CarItemRecyclerviewAdapter(R.layout.adapter_car_item,list);
        carHaveItemRecyclerview.setAdapter(caritemRecyclerviewAdapter);

        SmoothCheckBox checkBox=helper.getView(R.id.car_have_checkbox);
        checkBox.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
                 if (isChecked){
                     caritemRecyclerviewAdapter.setSmoothCheckBoxCheck(true);
                }else{
                     caritemRecyclerviewAdapter.setSmoothCheckBoxCheck(false);
                 }
            }
        });

    }
}
