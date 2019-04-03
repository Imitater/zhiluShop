package com.mouqukeji.zhailushop.ui.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.ui.activity.OrderInfoActivity;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class ReturnGoodRecyclerviewAdapter extends BaseQuickAdapter {
    public ReturnGoodRecyclerviewAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId,data);
    }
    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        List list=new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            list.add(i);
        }
        RecyclerView recyclerview=helper.getView(R.id.adapter_all_order_recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        AdapterAllOrderAdapter adapter = new AdapterAllOrderAdapter(R.layout.adapter_all_order_layout,list);
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, OrderInfoActivity.class);
                mContext.startActivity(intent);
            }
        });
    }
}
