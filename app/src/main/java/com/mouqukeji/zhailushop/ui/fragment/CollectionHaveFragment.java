package com.mouqukeji.zhailushop.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.ui.activity.GoodInfoActivity;
import com.mouqukeji.zhailushop.ui.adapter.CollectionHaveRecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CollectionHaveFragment extends BaseFragment {
    @BindView(R.id.collection_have_recyclerview)
    RecyclerView collectionHaveRecyclerview;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_collection_have;
    }

    @Override
    protected void setUpView() {
        List list=new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        collectionHaveRecyclerview.setLayoutManager(new LinearLayoutManager(getMContext()));
        CollectionHaveRecyclerviewAdapter collectionHaveRecyclerviewAdapter = new CollectionHaveRecyclerviewAdapter(R.layout.adapter_collectionhave_layout,list);
        collectionHaveRecyclerview.setAdapter(collectionHaveRecyclerviewAdapter);
        collectionHaveRecyclerviewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getMContext(), GoodInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void setUpData() {

    }


}
