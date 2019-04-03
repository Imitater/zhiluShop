package com.mouqukeji.zhailushop.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.contract.MyContract;
import com.mouqukeji.zhailushop.modle.MyModel;
import com.mouqukeji.zhailushop.presenter.MyPresenter;
import com.mouqukeji.zhailushop.ui.activity.AddressActivity;
import com.mouqukeji.zhailushop.ui.activity.AdviceActivity;
import com.mouqukeji.zhailushop.ui.activity.CollectionActivity;
import com.mouqukeji.zhailushop.ui.activity.FocusActivity;
import com.mouqukeji.zhailushop.ui.activity.HelpActivity;
import com.mouqukeji.zhailushop.ui.activity.MyInfoActivity;
import com.mouqukeji.zhailushop.ui.activity.OrderActivity;
import com.mouqukeji.zhailushop.ui.activity.PackageActivity;
import com.mouqukeji.zhailushop.ui.widget.GlideBlurformation;
import com.mouqukeji.zhailushop.utils.EventBusUtils;
import com.mouqukeji.zhailushop.utils.EventCode;
import com.mouqukeji.zhailushop.utils.EventMessage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import developer.shivam.crescento.CrescentoContainer;

public class MyFragment extends BaseFragment<MyPresenter, MyModel> implements MyContract.View, View.OnClickListener {
    @BindView(R.id.my_top_image)
    ImageView myTopImage;
    @BindView(R.id.circle_head)
    CircleImageView circleHead;
    @BindView(R.id.my_nickname)
    TextView myNickname;
    @BindView(R.id.my_number)
    TextView myNumber;
    @BindView(R.id.crescentoContainer)
    CrescentoContainer crescentoContainer;
    @BindView(R.id.my_order)
    TextView myOrder;
    @BindView(R.id.my_topay_iv)
    ImageView myTopayIv;
    @BindView(R.id.my_topay)
    LinearLayout myTopay;
    @BindView(R.id.my_to_send_iv)
    ImageView myToSendIv;
    @BindView(R.id.my_to_send)
    LinearLayout myToSend;
    @BindView(R.id.my_totalk_iv)
    ImageView myTotalkIv;
    @BindView(R.id.my_totalk)
    LinearLayout myTotalk;
    @BindView(R.id.my_backmoney_iv)
    ImageView myBackmoneyIv;
    @BindView(R.id.my_backmoney)
    LinearLayout myBackmoney;
    @BindView(R.id.my_package)
    LinearLayout myPackage;
    @BindView(R.id.my_fouce)
    LinearLayout myFouce;
    @BindView(R.id.my_collection)
    LinearLayout myCollection;
    @BindView(R.id.my_address)
    LinearLayout myAddress;
    @BindView(R.id.my_help)
    LinearLayout myHelp;
    @BindView(R.id.my_setting)
    LinearLayout mySetting;
    @BindView(R.id.my_info)
    LinearLayout myInfo;
    Unbinder unbinder;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void setUpView() {
        Glide.with(getMContext()).load("https://img.zcool.cn/community/0186695c91ca95a801214168a5ac01.jpg@1280w_1l_2o_100sh.jpg")
                .apply(RequestOptions.bitmapTransform(new GlideBlurformation(getMContext()))).into(myTopImage);
        Glide.with(getMContext()).load("https://img.zcool.cn/community/0186695c91ca95a801214168a5ac01.jpg@1280w_1l_2o_100sh.jpg").into(circleHead);
        //点击事件
        initListener();
    }

    private void initListener() {
        myPackage.setOnClickListener(this);
        myFouce.setOnClickListener(this);
        myCollection.setOnClickListener(this);
        myAddress.setOnClickListener(this);
        myHelp.setOnClickListener(this);
        mySetting.setOnClickListener(this);
        myInfo.setOnClickListener(this);
        myOrder.setOnClickListener(this);
        myTopay.setOnClickListener(this);
        myToSend.setOnClickListener(this);
        myTotalk.setOnClickListener(this);
        myBackmoney.setOnClickListener(this);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_package://钱包
                Intent intent = new Intent(getMContext(), PackageActivity.class);
                startActivity(intent);
                break;
            case R.id.my_fouce:
                Intent intent1 = new Intent(getMContext(), FocusActivity.class);
                startActivity(intent1);
                break;
            case R.id.my_collection:
                Intent intent2 = new Intent(getMContext(), CollectionActivity.class);
                startActivity(intent2);
                break;
            case R.id.my_address:
                Intent intent3 = new Intent(getMContext(), AddressActivity.class);
                startActivity(intent3);
                break;
            case R.id.my_help:
                Intent intent5 = new Intent(getMContext(), AdviceActivity.class);
                startActivity(intent5);
                break;
            case R.id.my_setting:
                Intent intent4 = new Intent(getMContext(), HelpActivity.class);
                startActivity(intent4);
                break;
            case R.id.my_info:
                Intent intent6 = new Intent(getMContext(), MyInfoActivity.class);
                startActivity(intent6);
                break;
            case R.id.my_order:
                Intent intent7 = new Intent(getMContext(), OrderActivity.class);
                startActivity(intent7);
                break;
            case R.id.my_topay:
                //待支付
                Intent intent8 = new Intent(getMContext(), OrderActivity.class);
                intent8.putExtra("item",1);
                startActivity(intent8);
                break;
            case R.id.my_to_send:
                //待送达
                Intent intent9 = new Intent(getMContext(), OrderActivity.class);
                intent9.putExtra("item",2);
                startActivity(intent9);
                break;
            case R.id.my_totalk:
                //待评价
                Intent intent10 = new Intent(getMContext(), OrderActivity.class);
                intent10.putExtra("item",3);
                startActivity(intent10);
                break;
            case R.id.my_backmoney:
                //退款
                Intent intent11 = new Intent(getMContext(), OrderActivity.class);
                intent11.putExtra("item",4);
                startActivity(intent11);
                break;

        }
    }

}
