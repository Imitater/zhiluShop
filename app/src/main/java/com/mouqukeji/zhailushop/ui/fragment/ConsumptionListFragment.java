package com.mouqukeji.zhailushop.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.contract.ConsumptionListContract;
import com.mouqukeji.zhailushop.modle.ConsumptionListModel;
import com.mouqukeji.zhailushop.presenter.ConsumptionListPresenter;
import com.mouqukeji.zhailushop.ui.adapter.ConsmptionListRecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

public class ConsumptionListFragment extends BaseFragment<ConsumptionListPresenter, ConsumptionListModel> implements ConsumptionListContract.View, View.OnClickListener {
    @BindView(R.id.consumptionlist_recyclerview)
    RecyclerView consumptionlistRecyclerview;
    Unbinder unbinder;
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.consumption_count)
    TextView consumptionCount;
    @BindView(R.id.refreshlayout)
    TwinklingRefreshLayout refreshlayout;
    private ConsmptionListRecyclerviewAdapter consumptionListRecyclerviewAdapter;

    @Override
    protected void initViewAndEvents() {
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_consumptionlist;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("消费明细");
        List list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext());
        consumptionlistRecyclerview.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        consumptionListRecyclerviewAdapter = new ConsmptionListRecyclerviewAdapter(R.layout.adapter_consumption_list_item, list);
        consumptionlistRecyclerview.setAdapter(consumptionListRecyclerviewAdapter);
        consumptionListRecyclerviewAdapter.disableLoadMoreIfNotFullPage(consumptionlistRecyclerview);

        //点击事件
        initListener();
        //上拉加载  下拉刷新
        setUpLoad();
    }

    private void initListener() {
        actionBack.setOnClickListener(this);
    }

    @Override
    protected void setUpData() {

    }
    private void setUpLoad() {
        refreshlayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefreshing();
                    }
                }, 2000);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_back:
                pop();
                break;
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }


}
