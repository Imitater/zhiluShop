package com.mouqukeji.zhailushop.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;
import com.mouqukeji.zhailushop.contract.CollectionContract;
import com.mouqukeji.zhailushop.modle.CollectionModel;
import com.mouqukeji.zhailushop.presenter.CollectionPresenter;
import com.mouqukeji.zhailushop.ui.fragment.CollectionHaveFragment;
import butterknife.BindView;

public class CollectionActivity extends BaseActivity<CollectionPresenter, CollectionModel> implements CollectionContract.View, View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.collection_framelayout)
    FrameLayout collectionFramelayout;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_collection;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("我的收藏");
        actionBack.setOnClickListener(this);
        loadRootFragment(R.id.collection_framelayout, new CollectionHaveFragment());
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action_back:
                finish();
                break;
        }
    }


}
