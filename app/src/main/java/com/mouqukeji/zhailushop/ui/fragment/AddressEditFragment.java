package com.mouqukeji.zhailushop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.contract.AddressEditContract;
import com.mouqukeji.zhailushop.modle.AddressEditModel;
import com.mouqukeji.zhailushop.presenter.AddressEditPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AddressEditFragment extends BaseFragment<AddressEditPresenter, AddressEditModel> implements AddressEditContract.View, View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.address_edit_name)
    EditText addressEditName;
    @BindView(R.id.address_edit_number)
    EditText addressEditNumber;
    @BindView(R.id.address_edit_location)
    TextView addressEditLocation;
    @BindView(R.id.address_edit_location_info)
    EditText addressEditLocationInfo;
    @BindView(R.id.address_edit_bt)
    Button addressEditBt;
    @BindView(R.id.address_edit_framlayout)
    FrameLayout addressEditFramlayout;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_address_edit;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("管理地址");
        //点击事件
        initListener();
    }

    private void initListener() {
        actionBack.setOnClickListener(this);
        addressEditLocation.setOnClickListener(this);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_back:
                pop();
                break;
            case R.id.address_edit_location:
                //地址区域选择
                addressEditFramlayout.setVisibility(View.VISIBLE);
                loadRootFragment(R.id.address_edit_framlayout, new SelectLocationFragment());
                break;
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }


}
