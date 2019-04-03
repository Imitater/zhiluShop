package com.mouqukeji.zhailushop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AddressIsEmptyFragment extends BaseFragment {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.empty_address_add_bt)
    Button emptyAddressAddBt;
    Unbinder unbinder;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_address_is_empty;
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData() {

    }

}
