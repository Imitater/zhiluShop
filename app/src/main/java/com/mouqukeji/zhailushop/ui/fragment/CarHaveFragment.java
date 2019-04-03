package com.mouqukeji.zhailushop.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.ui.activity.GoodInfoActivity;
import com.mouqukeji.zhailushop.ui.adapter.CarHaveRecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CarHaveFragment extends BaseFragment {

    @BindView(R.id.car_have_recyclerview)
    RecyclerView carHaveRecyclerview;
    List list=new ArrayList<Integer>();
    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_car_have;
    }

    @Override
    protected void setUpView() {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        carHaveRecyclerview.setLayoutManager(new LinearLayoutManager(getMContext()));
        CarHaveRecyclerviewAdapter carHaveRecyclerviewAdapter = new CarHaveRecyclerviewAdapter(R.layout.adapter_car_have,list);
        carHaveRecyclerview.setAdapter(carHaveRecyclerviewAdapter);
        carHaveRecyclerviewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
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
