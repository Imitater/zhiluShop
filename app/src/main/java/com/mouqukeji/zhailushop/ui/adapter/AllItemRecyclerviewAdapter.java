package com.mouqukeji.zhailushop.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class AllItemRecyclerviewAdapter extends BaseQuickAdapter {
    public AllItemRecyclerviewAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId,data);
    }
    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        Glide.with(mContext).load(getData().get(helper.getLayoutPosition()))
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(10, 0)))
                .into((ImageView) helper.getView(R.id.adapter_iv));
    }
}
