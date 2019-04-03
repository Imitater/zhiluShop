package com.mouqukeji.zhailushop.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
 import android.view.View;
import android.widget.TextView;

import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;
import com.mouqukeji.zhailushop.contract.OrderContract;
import com.mouqukeji.zhailushop.modle.OrderModel;
import com.mouqukeji.zhailushop.presenter.OrderPresenter;
import com.mouqukeji.zhailushop.ui.adapter.OrderAdapter;
import com.mouqukeji.zhailushop.ui.fragment.AllOrderFragment;
import com.mouqukeji.zhailushop.ui.fragment.OngoingOrderFragment;
import com.mouqukeji.zhailushop.ui.fragment.ReturnGoodFragment;
import com.mouqukeji.zhailushop.ui.fragment.ToEvaluateFragment;
import com.mouqukeji.zhailushop.ui.fragment.ToPayFragment;
import com.mouqukeji.zhailushop.utils.EventCode;
import com.mouqukeji.zhailushop.utils.EventMessage;

import java.util.ArrayList;

import butterknife.BindView;

public class OrderActivity extends BaseActivity<OrderPresenter, OrderModel> implements OrderContract.View, View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.order_tablayout)
    TabLayout orderTablayout;
    @BindView(R.id.order_viewpager)
    ViewPager orderViewpager;
    private ArrayList<String> titleList =new ArrayList<>();
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    @Override
    protected void initViewAndEvents() {}

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_order;
    }

    @Override
    protected void setUpView() {
        Intent intent = getIntent();
        int item = intent.getIntExtra("item", 0);
        actionTitle.setText("我的订单");
        initAdapter();
        setViewpager();
        actionBack.setOnClickListener(this);
        orderViewpager.setCurrentItem(item);
    }
    //初始化Viewpager和TabLayout的tab标签和fragment
    public void initAdapter(){
        titleList.add("全部");
        titleList.add("待支付");
        titleList.add("待送达");
        titleList.add("待评价");
        titleList.add("退/换货");

        fragmentList.add(new AllOrderFragment());
        fragmentList.add(new ToPayFragment());
        fragmentList.add(new OngoingOrderFragment());
        fragmentList.add(new ToEvaluateFragment());
        fragmentList.add(new ReturnGoodFragment());
    }

    //Viewpager的初始化和相关加载
    private void setViewpager(){
        OrderAdapter orderAdapter = new OrderAdapter(getSupportFragmentManager(), titleList,fragmentList);
        orderViewpager.setAdapter(orderAdapter);
        orderTablayout.setupWithViewPager(orderViewpager);
        orderViewpager.setOffscreenPageLimit(1);//ViewPager设置预加载页面的个数方法
    }
    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action_back:
                OrderActivity.this.finish();
                break;
        }
    }
}
