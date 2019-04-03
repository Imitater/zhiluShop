package com.mouqukeji.zhailushop.ui.fragment;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseLazyFragment;
import com.mouqukeji.zhailushop.contract.AllOrderContract;
import com.mouqukeji.zhailushop.modle.AllOrderModel;
import com.mouqukeji.zhailushop.presenter.AllOrderPresenter;
import com.mouqukeji.zhailushop.ui.activity.OrderInfoActivity;
import com.mouqukeji.zhailushop.ui.adapter.AllorderRecyclerviewAdapter;
import com.mouqukeji.zhailushop.utils.MultipleItem;
import com.mouqukeji.zhailushop.utils.MultipleOrderItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class AllOrderFragment extends BaseLazyFragment<AllOrderPresenter, AllOrderModel> implements AllOrderContract.View, View.OnClickListener {


    @BindView(R.id.allorder_recyclerview)
    RecyclerView allorderRecyclerview;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_allorder;
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData() {

    }


    @Override
    public void onClick(View v) {

    }

    private void setUpLoad() {
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
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
    protected void loadData() {
       setRecyclerview();
    }


    private void setRecyclerview() {
        allorderRecyclerview.setLayoutManager(new LinearLayoutManager(getMContext()));
        //设置 多布局type
        List list=new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            MultipleOrderItem multipleItem = new MultipleOrderItem(i,i);
            list.add(multipleItem);
        }
        AllorderRecyclerviewAdapter allorderRecyclerviewAdapter = new AllorderRecyclerviewAdapter(list);
        allorderRecyclerview.setAdapter(allorderRecyclerviewAdapter);
        allorderRecyclerviewAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);//设置recyclerview 动画
        allorderRecyclerviewAdapter.isFirstOnly(false);//设置动画一直使用
        setUpLoad();
    }



}
