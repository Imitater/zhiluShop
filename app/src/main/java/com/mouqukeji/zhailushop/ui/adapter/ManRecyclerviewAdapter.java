package com.mouqukeji.zhailushop.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;
import java.util.List;


public class ManRecyclerviewAdapter extends BaseQuickAdapter {


    public ManRecyclerviewAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
     }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        Glide.with(mContext).load(getData().get(helper.getLayoutPosition()))
                .thumbnail((float) 0.5).into((ImageView) helper.getView(R.id.adapter_iv));
    }
}
