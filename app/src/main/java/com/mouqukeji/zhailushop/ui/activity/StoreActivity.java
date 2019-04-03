package com.mouqukeji.zhailushop.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;
import com.mouqukeji.zhailushop.contract.StoreContract;
import com.mouqukeji.zhailushop.modle.StoreModel;
import com.mouqukeji.zhailushop.presenter.StorePresenter;
import com.mouqukeji.zhailushop.ui.adapter.StoreRecyclerviewAdapter;
import com.varunest.sparkbutton.SparkButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class StoreActivity extends BaseActivity<StorePresenter, StoreModel> implements StoreContract.View, View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.store_background_iv)
    ImageView storeBackgroundIv;
    @BindView(R.id.store_iv)
    ImageView storeIv;
    @BindView(R.id.store_spark_button)
    SparkButton storeSparkButton;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.store_nestedscrollview)
    NestedScrollView storeNestedscrollview;
    @BindView(R.id.store_recyclerview)
    RecyclerView storeRecyclerview;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_store;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("YC的小店");
        //点击事件
        initlistener();
        //背景图
        Glide.with(this).load("https://img.zcool.cn/community/01a88c5bcdc3cea8012099c85dccdc.jpg@1280w_1l_2o_100sh.jpg").into(storeBackgroundIv);
        //店铺
        Glide.with(this).load("https://img.zcool.cn/community/01d2a15b6904d8a801215c8feed523.jpg@1280w_1l_2o_100sh.jpg")
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(20, 0))).into(storeIv);
        //设置recyclerview
        setRecyclerview();
    }

    private void setRecyclerview() {
        List list=new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        storeRecyclerview.setLayoutManager(new GridLayoutManager(this,2));
        StoreRecyclerviewAdapter storeRecyclerviewAdapter = new StoreRecyclerviewAdapter(R.layout.adapter_store_layout,list);
        storeRecyclerview.setAdapter(storeRecyclerviewAdapter);
    }

    private void initlistener() {
        actionBack.setOnClickListener(this);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_back:
                StoreActivity.this.finish();
                break;
        }
    }

}
