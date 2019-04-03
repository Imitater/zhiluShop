package com.mouqukeji.zhailushop.ui.adapter;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class StoreRecyclerviewAdapter extends BaseQuickAdapter {
    public StoreRecyclerviewAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId,data);
    }
    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        TextView adapterStoreDeletePrice=helper.getView(R.id.adapter_store_delete_price);
        adapterStoreDeletePrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        Glide.with(mContext).load("https://img.zcool.cn/community/01ebd95bd2a7efa8012099c8cfbc0f.jpg@1280w_1l_2o_100sh.jpg")
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(30, 0))).into((ImageView) helper.getView(R.id.adapter_iv));
    }
}
