package com.mouqukeji.zhailushop.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.ui.widget.StarBar;
import java.util.List;
public class GoodInfoRecyclerviewAdapter extends BaseQuickAdapter {
    public GoodInfoRecyclerviewAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId,data);
    }
    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        StarBar starBar=helper.getView(R.id.starBar);
        starBar.setStarRating(100);
        Glide.with(mContext).load("https://img.zcool.cn/community/0186695c91ca95a801214168a5ac01.jpg@1280w_1l_2o_100sh.jpg").into((ImageView) helper.getView(R.id.adapter_good_iv));
    }
}
