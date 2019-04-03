package com.mouqukeji.zhailushop.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;
import com.mouqukeji.zhailushop.contract.MainContract;
import com.mouqukeji.zhailushop.modle.MainModel;
import com.mouqukeji.zhailushop.presenter.MainPresenter;
import com.mouqukeji.zhailushop.ui.adapter.MainPageAdapter;
import com.mouqukeji.zhailushop.ui.fragment.CarFragment;
import com.mouqukeji.zhailushop.ui.fragment.HomeFragment;
import com.mouqukeji.zhailushop.ui.fragment.MyFragment;
import com.mouqukeji.zhailushop.ui.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainContract.View, View.OnClickListener {

    @BindView(R.id.app_iv_tab_main)
    ImageView appIvTabMain;
    @BindView(R.id.app_tv_tab_main)
    TextView appTvTabMain;
    @BindView(R.id.app_rl_tab_main)
    RelativeLayout appRlTabMain;
    @BindView(R.id.app_iv_tab_car)
    ImageView appIvTabCar;
    @BindView(R.id.app_tv_tab_car)
    TextView appTvTabCar;
    @BindView(R.id.app_rl_tab_car)
    RelativeLayout appRlTabCar;
    @BindView(R.id.app_iv_tab_my)
    ImageView appIvTabMy;
    @BindView(R.id.app_tv_tab_my)
    TextView appTvTabMy;
    @BindView(R.id.app_rl_tab_my)
    RelativeLayout appRlTabMy;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.fl_container)
    CustomViewPager flContainer;
    private List fragmentList;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpView() {
        initData();
        initListener();
        MainPageAdapter mainPageAdapter = new MainPageAdapter(getSupportFragmentManager(), fragmentList);
        flContainer.setAdapter(mainPageAdapter);
        flContainer.setOffscreenPageLimit(2);
    }

    private void initData() {
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CarFragment());
        fragmentList.add(new MyFragment());
    }

    private void initListener() {
        appRlTabMain.setOnClickListener(this);
        appRlTabCar.setOnClickListener(this);
        appRlTabMy.setOnClickListener(this);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_rl_tab_main://首页
                appTvTabMain.setTextColor(getResources().getColor(R.color.black));
                appTvTabCar.setTextColor(getResources().getColor(R.color.main_gray));
                appTvTabMy.setTextColor(getResources().getColor(R.color.main_gray));
                flContainer.setCurrentItem(0);
                break;
            case R.id.app_rl_tab_car://购物车
                appTvTabMain.setTextColor(getResources().getColor(R.color.main_gray));
                appTvTabCar.setTextColor(getResources().getColor(R.color.black));
                appTvTabMy.setTextColor(getResources().getColor(R.color.main_gray));
                flContainer.setCurrentItem(1);
                break;
            case R.id.app_rl_tab_my://我的
                appTvTabMain.setTextColor(getResources().getColor(R.color.main_gray));
                appTvTabCar.setTextColor(getResources().getColor(R.color.main_gray));
                appTvTabMy.setTextColor(getResources().getColor(R.color.black));
                flContainer.setCurrentItem(2);
                break;
        }
    }


}
