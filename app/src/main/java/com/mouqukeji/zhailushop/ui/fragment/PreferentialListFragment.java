package com.mouqukeji.zhailushop.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.contract.PreferentialListContract;
import com.mouqukeji.zhailushop.modle.PreferentialListModel;
import com.mouqukeji.zhailushop.presenter.PreferentialListPresenter;

import butterknife.BindView;
import butterknife.Unbinder;

public class PreferentialListFragment extends BaseFragment<PreferentialListPresenter, PreferentialListModel> implements PreferentialListContract.View ,View.OnClickListener  {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.preferential_recyclerview)
    RecyclerView preferentialRecyclerview;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_preferential_list;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("优惠券");
        //点击事件
        initListener();
    }

    private void initListener() {
        actionBack.setOnClickListener(this);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action_back:
                pop();
                break;
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        pop();
        return  true;
    }
}
