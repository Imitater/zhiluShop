package com.mouqukeji.zhailushop.ui.fragment;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.ui.activity.StoreActivity;
import com.mouqukeji.zhailushop.ui.adapter.FocusHaveRecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FocusHaveFragment extends BaseFragment {
    @BindView(R.id.focus_have_recyclerview)
    RecyclerView focusHaveRecyclerview;
    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_focus_have;
    }

    @Override
    protected void setUpView() {
        List list=new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        focusHaveRecyclerview.setLayoutManager(new LinearLayoutManager(getMContext()));
        FocusHaveRecyclerviewAdapter focusHaveRecyclerviewAdapter = new FocusHaveRecyclerviewAdapter(R.layout.adapter_focus_have_layout,list);
        focusHaveRecyclerview.setAdapter(focusHaveRecyclerviewAdapter);
        focusHaveRecyclerviewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getMContext(), StoreActivity.class);
                getMContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void setUpData() {

    }

}
