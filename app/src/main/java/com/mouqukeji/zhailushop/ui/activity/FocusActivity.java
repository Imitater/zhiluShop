package com.mouqukeji.zhailushop.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;
import com.mouqukeji.zhailushop.contract.FocusContract;
import com.mouqukeji.zhailushop.modle.FocusModel;
import com.mouqukeji.zhailushop.presenter.FocusPresenter;
import com.mouqukeji.zhailushop.ui.fragment.FocusHaveFragment;
import com.mouqukeji.zhailushop.ui.fragment.PreferentialListFragment;

import butterknife.BindView;

public class FocusActivity extends BaseActivity<FocusPresenter, FocusModel> implements FocusContract.View ,View.OnClickListener  {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.focus_framelayout)
    FrameLayout focusFramelayout;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_focus;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("关注店铺");
        //点击事件
        initListener();
    }

    private void initListener() {
        actionBack.setOnClickListener(this);
        loadRootFragment(R.id.focus_framelayout, new FocusHaveFragment());
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action_back:
                finish();
                break;
        }
    }
}
