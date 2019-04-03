package com.mouqukeji.zhailushop.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class FocusHaveRecyclerviewAdapter extends BaseQuickAdapter {
    public FocusHaveRecyclerviewAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        Glide.with(mContext).load("https://img.zcool.cn/community/0163435909862ba8012145507ccc90.jpg@1280w_1l_2o_100sh.jpg")
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(13, 0))).into((ImageView) helper.getView(R.id.adapter_iv));
    }
}
