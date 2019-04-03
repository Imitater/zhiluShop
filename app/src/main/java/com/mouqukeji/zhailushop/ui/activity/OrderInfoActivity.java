package com.mouqukeji.zhailushop.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;
import com.mouqukeji.zhailushop.contract.OrderInfoContract;
import com.mouqukeji.zhailushop.modle.OrderInfoModel;
import com.mouqukeji.zhailushop.presenter.OrderInfoPresenter;
import com.mouqukeji.zhailushop.ui.adapter.OrderInfoRecyclerviewAdapter;
import com.mouqukeji.zhailushop.ui.fragment.ApplyForReturnFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class OrderInfoActivity extends BaseActivity<OrderInfoPresenter, OrderInfoModel> implements OrderInfoContract.View, View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.order_info_iv)
    ImageView orderInfoIv;
    @BindView(R.id.order_info_recyclerview)
    RecyclerView orderInfoRecyclerview;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.order_info_bt2)
    TextView orderInfoBt2;
    @BindView(R.id.order_info_bt3)
    TextView orderInfoBt3;
    @BindView(R.id.order_info_bt1)
    TextView orderInfoBt1;
    @BindView(R.id.order_info_framelayout)
    FrameLayout orderInfoFramelayout;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.actiivty_orderinfo;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("订单详情");
        Glide.with(this).load("https://img.zcool.cn/community/01b09e5c99964ca801208f8b40c255.jpg@1280w_1l_2o_100sh.jpg")
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(20, 0))) .into(orderInfoIv);
        setRecyclerview();
        //点击事件
        initListener();
    }

    private void initListener() {
        actionBack.setOnClickListener(this);
        orderInfoBt1.setOnClickListener(this);
    }

    private void setRecyclerview() {
        List list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        orderInfoRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        OrderInfoRecyclerviewAdapter orderInfoRecyclerviewAdapter = new OrderInfoRecyclerviewAdapter(R.layout.adapter_order_info_layout, list);
        orderInfoRecyclerview.setAdapter(orderInfoRecyclerviewAdapter);
        setLoadUp();
    }

    private void setLoadUp() {
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                refreshLayout.finishRefreshing();
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishLoadmore();
                    }
                }, 2000);
            }
        });

    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_back:
                OrderInfoActivity.this.finish();
                break;
            case R.id.order_info_bt1:
                orderInfoFramelayout.setVisibility(View.VISIBLE);
                loadRootFragment(R.id.order_info_framelayout, new ApplyForReturnFragment());
                break;
        }
    }
}
