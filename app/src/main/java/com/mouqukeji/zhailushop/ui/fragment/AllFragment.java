package com.mouqukeji.zhailushop.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
 import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.base.BaseLazyFragment;
import com.mouqukeji.zhailushop.contract.AllContract;
import com.mouqukeji.zhailushop.modle.AllModel;
import com.mouqukeji.zhailushop.presenter.AllPresenter;
import com.mouqukeji.zhailushop.ui.activity.StoreActivity;
import com.mouqukeji.zhailushop.ui.adapter.AllRecyclerviewAdapter;
import com.mouqukeji.zhailushop.ui.widget.CustomHomeViewPager;
import com.mouqukeji.zhailushop.utils.EventBusUtils;
import com.mouqukeji.zhailushop.utils.EventCode;
import com.mouqukeji.zhailushop.utils.EventMessage;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;



@SuppressLint("ValidFragment")
public class AllFragment extends BaseLazyFragment<AllPresenter, AllModel> implements AllContract.View  {
    private final CustomHomeViewPager viewPager;
    @BindView(R.id.all_recyclerview)
    RecyclerView allRecyclerview;
     private List list;
    private AllRecyclerviewAdapter allRecyclerviewAdapter;
    int page = 1;

    public AllFragment(CustomHomeViewPager viewPager) {
        this.viewPager = viewPager;
    }


    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_all;
    }

    @Override
    protected void setUpView() {
        //添加假数据
        initData();
        setRecyclerview();
    }

    private void setRecyclerview() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        allRecyclerviewAdapter = new AllRecyclerviewAdapter(R.layout.adapter_all, list);
        allRecyclerview.setLayoutManager(linearLayoutManager);
        allRecyclerview.setAdapter(allRecyclerviewAdapter);
        allRecyclerview.setNestedScrollingEnabled(false);
        allRecyclerviewAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);//设置recyclerview 动画
        allRecyclerviewAdapter.isFirstOnly(false);//设置动画一直使用
        viewPager.setObjectForPosition(getContentView(), 0);
        allRecyclerviewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //店铺
                Intent intent = new Intent(getMContext(), StoreActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void setUpData() {

    }



    private void initData() {
        list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    @Override
    protected boolean isRegisteredEventBus() {
        return true;
    }

    @Override
    public void onReceiveEvent(EventMessage event) {
        super.onReceiveEvent(event);
        if (event != null) {
            if (event.getCode() == EventCode.EVENT_A) {
                if (page<=2) {
                    page++;
                    allRecyclerviewAdapter.addData(list);
                    allRecyclerviewAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    @Override
    protected void loadData() {
        //添加假数据
        initData();
        setRecyclerview();
    }
}
