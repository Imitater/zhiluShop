package com.mouqukeji.zhailushop.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.contract.CarContract;
import com.mouqukeji.zhailushop.modle.CarModel;
import com.mouqukeji.zhailushop.presenter.CarPresenter;
import com.mouqukeji.zhailushop.ui.adapter.CarRecyclerviewAdapter;
import com.mouqukeji.zhailushop.ui.widget.SmoothCheckBox;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CarFragment extends BaseFragment<CarPresenter, CarModel> implements CarContract.View {
    @BindView(R.id.car_list_framelayout)
    FrameLayout carListFramelayout;
    @BindView(R.id.car_recyclerview)
    RecyclerView carRecyclerview;
    @BindView(R.id.car_have_checkbox)
    SmoothCheckBox carHaveCheckbox;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_beauty;
    }

    @Override
    protected void setUpView() {
        setRecyclerview();
        loadRootFragment(R.id.car_list_framelayout, new CarHaveFragment()); //activity初始加载HomeFragment
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

    private void setRecyclerview() {
        List list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        carRecyclerview.setLayoutManager(new GridLayoutManager(getMContext(), 2));
        CarRecyclerviewAdapter carRecyclerviewAdapter = new CarRecyclerviewAdapter(R.layout.adapter_car_layout, list);
        carRecyclerview.setAdapter(carRecyclerviewAdapter);
    }

    @Override
    protected void setUpData() {

    }

}
