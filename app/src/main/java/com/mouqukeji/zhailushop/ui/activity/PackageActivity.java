package com.mouqukeji.zhailushop.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;
import com.mouqukeji.zhailushop.contract.PackageContract;
import com.mouqukeji.zhailushop.modle.PackageModel;
import com.mouqukeji.zhailushop.presenter.PackagePresenter;
import com.mouqukeji.zhailushop.ui.fragment.ConsumptionListFragment;
import com.mouqukeji.zhailushop.ui.fragment.PreferentialListFragment;
import com.mouqukeji.zhailushop.ui.fragment.RechangeListFragment;

import butterknife.BindView;

public class PackageActivity extends BaseActivity<PackagePresenter, PackageModel> implements PackageContract.View ,View.OnClickListener  {
    @BindView(R.id.package_balance)
    TextView packageBalance;
    @BindView(R.id.package_rechange_list)
    LinearLayout packageRechangeList;
    @BindView(R.id.package_consumption_list)
    LinearLayout packageConsumptionList;
    @BindView(R.id.package_preferential)
    LinearLayout packagePreferential;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_package;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("钱包");
        //点击事件
        initListener();
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }


    private void initListener() {
        actionBack.setOnClickListener(this);
        packageRechangeList.setOnClickListener(this);
        packagePreferential.setOnClickListener(this);
        packageConsumptionList.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action_back:
                finish();
                break;
            case R.id.package_rechange_list://充值明细
                framelayout.setVisibility(View.VISIBLE);
                loadRootFragment(R.id.framelayout, new RechangeListFragment());
                break;
            case R.id.package_preferential://优惠券
                framelayout.setVisibility(View.VISIBLE);
                loadRootFragment(R.id.framelayout, new PreferentialListFragment());
                break;
            case R.id.package_consumption_list://消费明细
                framelayout.setVisibility(View.VISIBLE);
                loadRootFragment(R.id.framelayout, new ConsumptionListFragment());
                break;
        }
    }
}
