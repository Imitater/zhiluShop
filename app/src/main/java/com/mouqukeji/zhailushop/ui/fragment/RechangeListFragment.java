package com.mouqukeji.zhailushop.ui.fragment;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.contract.RechangeListContract;
import com.mouqukeji.zhailushop.modle.RechangListModel;
import com.mouqukeji.zhailushop.presenter.RechangeListPresenter;
import com.mouqukeji.zhailushop.ui.adapter.RechangeListRecyclerviewAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

public class RechangeListFragment extends BaseFragment<RechangeListPresenter, RechangListModel> implements RechangeListContract.View, View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.rechange_list_recyclerview)
    RecyclerView rechangeListRecyclerview;
    @BindView(R.id.refreshlayout)
    TwinklingRefreshLayout refreshlayout;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_rechangelist;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("充值明细");
        List list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        rechangeListRecyclerview.setLayoutManager(new LinearLayoutManager(getMContext()));
        RechangeListRecyclerviewAdapter rechangeListRecyclerviewAdapter = new RechangeListRecyclerviewAdapter(R.layout.adapter_rechange_list_item, list);
        rechangeListRecyclerview.setAdapter(rechangeListRecyclerviewAdapter);
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
