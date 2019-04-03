package com.mouqukeji.zhailushop.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;
import com.mouqukeji.zhailushop.contract.AddressContract;
import com.mouqukeji.zhailushop.modle.AddressModel;
import com.mouqukeji.zhailushop.presenter.AddressPresenter;
import com.mouqukeji.zhailushop.ui.adapter.AddressRecyclerviewAdapter;
import com.mouqukeji.zhailushop.ui.fragment.AddressEditFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddressActivity extends BaseActivity<AddressPresenter, AddressModel> implements AddressContract.View, View.OnClickListener {
    @BindView(R.id.address_recyclerview)
    RecyclerView addressRecyclerview;
    @BindView(R.id.address_framelayout)
    FrameLayout addressFramelayout;
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.address_add)
    Button addressAdd;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_address;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("管理地址");
        //点击事件
        initListener();
        //设置recyclervie
        setRecyclerview();
    }

    private void setRecyclerview() {
        List list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        addressRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        AddressRecyclerviewAdapter addressRecyclerviewAdapter = new AddressRecyclerviewAdapter(R.layout.adapter_address_layout, list);
        addressRecyclerview.setAdapter(addressRecyclerviewAdapter);
        addressRecyclerviewAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                //编辑
                addressFramelayout.setVisibility(View.VISIBLE);
                loadRootFragment(R.id.address_framelayout, new AddressEditFragment());
            }
        });
    }

    private void initListener() {
        actionBack.setOnClickListener(this);
        addressAdd.setOnClickListener(this);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_back:
                finish();
                break;
            case R.id.address_add:
                addressFramelayout.setVisibility(View.VISIBLE);
                loadRootFragment(R.id.address_framelayout, new AddressEditFragment());
                break;
        }
    }

}
