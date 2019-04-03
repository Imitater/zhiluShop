package com.mouqukeji.zhailushop.ui.fragment;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseLazyFragment;
import com.mouqukeji.zhailushop.ui.adapter.ToPayRecyclerviewAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

public class ToPayFragment extends BaseLazyFragment {
    @BindView(R.id.topay_recyclerview)
    RecyclerView topayRecyclerview;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_to_pay;
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected void loadData() {
        setRecyclerview();
    }


    private void setRecyclerview() {
        List list=new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        topayRecyclerview.setLayoutManager(new LinearLayoutManager(getMContext()));
        ToPayRecyclerviewAdapter toPayRecyclerviewAdapter=new ToPayRecyclerviewAdapter(R.layout.adapter_pay_order,list);
        topayRecyclerview.setAdapter(toPayRecyclerviewAdapter);
        toPayRecyclerviewAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);//设置recyclerview 动画
        toPayRecyclerviewAdapter.isFirstOnly(false);//设置动画一直使用
        setUpLoad();
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
}
