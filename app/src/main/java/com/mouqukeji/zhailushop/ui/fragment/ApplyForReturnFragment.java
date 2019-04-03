package com.mouqukeji.zhailushop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.ui.widget.SmoothCheckBox;
import com.mouqukeji.zhailushop.utils.DialogUtils;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class ApplyForReturnFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.apply_for_iv)
    ImageView applyForIv;
    @BindView(R.id.apply_for_select)
    LinearLayout applyForSelect;
    @BindView(R.id.car_have_checkbox)
    SmoothCheckBox carHaveCheckbox;
    @BindView(R.id.apply_for_cause_tv)
    TextView applyForCauseTv;
    @BindView(R.id.apply_for_framelayout)
    FrameLayout applyForFramelayout;
    @BindView(R.id.apply_for_bt)
    Button applyForBt;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_applyfor_return;
    }

    @Override
    protected void setUpView() {
        Glide.with(this).load("https://img.zcool.cn/community/019f475549a2080000019ae9b41fd8.jpg@1280w_1l_2o_100sh.jpg")
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(40, 0))).into(applyForIv);
        actionTitle.setText("申请退款");
        //点击事件
        initListener();
    }

    private void initListener() {
        actionBack.setOnClickListener(this);
        applyForSelect.setOnClickListener(this);
        applyForBt.setOnClickListener(this);
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
            case R.id.apply_for_select:
                //理由
                View inflate_cause = getLayoutInflater().inflate(R.layout.dialog_sex, null);
                int i = DialogUtils.showButtomCauseDialog(getMContext(), inflate_cause, true, true, applyForCauseTv);
                break;
            case R.id.apply_for_bt:
                applyForFramelayout.setVisibility(View.VISIBLE);
                loadRootFragment(R.id.apply_for_framelayout, new ApplyForInfoFragment());
                break;
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }


}
