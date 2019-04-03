package com.mouqukeji.zhailushop.ui.adapter;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;
import java.util.List;

public class GoodInfoListRecyclerviewAdapter extends BaseQuickAdapter {

    private BaseViewHolder baseViewHolder;

    public GoodInfoListRecyclerviewAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId,data);
     }
    @Override
    protected void convert(final BaseViewHolder helper, Object item) {
       Glide.with(mContext).load("https://img.zcool.cn/community/01e7025549a1fe0000019ae985d443.jpg@1280w_1l_2o_100sh.jpg").into((ImageView) helper.getView(R.id.adapter_good_list_iv));
        baseViewHolder = helper;
    }

    public BaseViewHolder getBaseViewHolder() {
        return baseViewHolder;
    }
}
