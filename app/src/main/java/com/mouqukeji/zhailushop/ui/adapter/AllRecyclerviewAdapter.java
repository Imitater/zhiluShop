package com.mouqukeji.zhailushop.ui.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.ui.activity.GoodInfoActivity;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class AllRecyclerviewAdapter extends BaseQuickAdapter {
    String[] s = {"https://img.zcool.cn/community/019ae0554989070000019ae9c8116f.jpg@1280w_1l_2o_100sh.jpg"
            , "https://img.zcool.cn/community/015626554b28fd000001bf72f1b67f.jpg@1280w_1l_2o_100sh.jpg"
            , "https://img.zcool.cn/community/0176b5554b28fc000001bf72c0db05.jpg@1280w_1l_2o_100sh.jpg"
            , "https://img.zcool.cn/community/01172c554b2906000001bf72813920.jpg@1280w_1l_2o_100sh.jpg"
            , "https://img.zcool.cn/community/0137ea55494a700000019ae9d82dc9.jpg@1280w_1l_2o_100sh.jpg"};

    public AllRecyclerviewAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
        List images = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            images.add(s[i]);
        }
        RecyclerView allItemRecyclerview = helper.getView(R.id.all_item_recyclerview);
        allItemRecyclerview.setLayoutManager(gridLayoutManager);
        AllItemRecyclerviewAdapter allItemRecyclerviewAdapter = new AllItemRecyclerviewAdapter(R.layout.adapter_all_item,images);
        allItemRecyclerview.setAdapter(allItemRecyclerviewAdapter);
        allItemRecyclerviewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, GoodInfoActivity.class);
                mContext.startActivity(intent);
            }
        });
        //商家头像
        Glide.with(mContext).load("https://img.zcool.cn/community/0185535c89bd39a801214168eaaef7.jpg@1280w_1l_2o_100sh.jpg")
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(10, 0)))
                .into((ImageView) helper.getView(R.id.all_head_iv));
    }
}
