package com.mouqukeji.zhailushop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class ApplyForInfoFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.apply_for_info_send_info)
    TextView applyForInfoSendInfo;
    @BindView(R.id.apply_for_info_iv)
    ImageView applyForInfoIv;
    @BindView(R.id.apply_for_info_framelayout)
    FrameLayout applyForInfoFramelayout;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_apply_for_info;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("退款详情");
        Glide.with(getMContext()).load("https://img.zcool.cn/community/019f475549a2080000019ae9b41fd8.jpg@1280w_1l_2o_100sh.jpg")
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(40, 0))).into(applyForInfoIv);
        //点击事件
        initListener();
    }

    private void initListener() {
        actionBack.setOnClickListener(this);
        applyForInfoSendInfo.setOnClickListener(this);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_back:
                pop();
                break;
            case R.id.apply_for_info_send_info:
                //物流
                applyForInfoFramelayout.setVisibility(View.VISIBLE);
                loadRootFragment(R.id.apply_for_info_framelayout, new LogisticsFragment());
                break;
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }

}
