package com.mouqukeji.zhailushop.ui.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;
import com.mouqukeji.zhailushop.contract.GoodInfoContract;
import com.mouqukeji.zhailushop.modle.GoodInfoModel;
import com.mouqukeji.zhailushop.presenter.GoodInfoPresenter;
import com.mouqukeji.zhailushop.ui.adapter.GoodInfoLikeRecyclerviewAdapter;
import com.mouqukeji.zhailushop.ui.adapter.GoodInfoListRecyclerviewAdapter;
import com.mouqukeji.zhailushop.ui.adapter.GoodInfoRecyclerviewAdapter;
import com.mouqukeji.zhailushop.ui.widget.ButtomDialogView;
import com.mouqukeji.zhailushop.ui.widget.CenterPicDialogView;
import com.mouqukeji.zhailushop.utils.DialogUtils;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class GoodInfoActivity extends BaseActivity<GoodInfoPresenter, GoodInfoModel> implements GoodInfoContract.View, View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.good_info_xbanner)
    XBanner goodInfoXbanner;
    @BindView(R.id.good_info_share)
    RelativeLayout goodInfoShare;
    @BindView(R.id.good_info_recyclerview)
    RecyclerView goodInfoRecyclerview;
    @BindView(R.id.good_info_head_iv)
    ImageView goodInfoHeadIv;
    @BindView(R.id.good_info_name)
    TextView goodInfoName;
    @BindView(R.id.good_info_focus)
    TextView goodInfoFocus;
    @BindView(R.id.good_info_in)
    TextView goodInfoIn;
    @BindView(R.id.good_info_contact)
    TextView goodInfoContact;
    @BindView(R.id.good_info_for)
    TextView goodInfoFor;
    @BindView(R.id.good_info_send_time)
    TextView goodInfoSendTime;
    @BindView(R.id.good_info_list_recyclerview)
    RecyclerView goodInfoListRecyclerview;
    @BindView(R.id.good_info_like_recyclerview)
    RecyclerView goodInfoLikeRecyclerview;
    @BindView(R.id.good_info_add)
    TextView goodInfoAdd;
    @BindView(R.id.good_info_buy)
    TextView goodInfoBuy;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_goodinfo;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("商品详情");
        setBanner();//banner
        //设置店铺头像
        Glide.with(this).load("https://img.zcool.cn/community/0185535c89bd39a801214168eaaef7.jpg@1280w_1l_2o_100sh.jpg")
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(10, 0))).into(goodInfoHeadIv);
        setRecyclerview();//recyclerview设置
        //点击事件
        initListener();
    }

    private void initListener() {
        goodInfoShare.setOnClickListener(this);
        actionBack.setOnClickListener(this);
        goodInfoBuy.setOnClickListener(this);
        goodInfoAdd.setOnClickListener(this);
    }

    private void setRecyclerview() {
        List list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        //评价
        goodInfoRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        goodInfoRecyclerview.setNestedScrollingEnabled(false);
        GoodInfoRecyclerviewAdapter goodInfoRecyclerAdapter = new GoodInfoRecyclerviewAdapter(R.layout.adapter_good_info_layout, list);
        goodInfoRecyclerview.setAdapter(goodInfoRecyclerAdapter);
        //商品详情
        goodInfoListRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        final GoodInfoListRecyclerviewAdapter goodInfoListRecyclerAdapter = new GoodInfoListRecyclerviewAdapter(R.layout.adapter_good_info_list_layout, list);
        goodInfoListRecyclerview.setAdapter(goodInfoListRecyclerAdapter);
        goodInfoListRecyclerview.setNestedScrollingEnabled(false);
        goodInfoListRecyclerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //点击查看大图
                Intent intent = new Intent(GoodInfoActivity.this, BigImageActivity.class);
                intent.putExtra("pic", "https://img.zcool.cn/community/01e7025549a1fe0000019ae985d443.jpg@1280w_1l_2o_100sh.jpg");
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(GoodInfoActivity.this).toBundle());
            }
        });
        //商品推荐
        goodInfoLikeRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        GoodInfoLikeRecyclerviewAdapter goodInfoLikeRecyclerviewAdapter = new GoodInfoLikeRecyclerviewAdapter(R.layout.adapter_good_info_like_layout, list);
        goodInfoLikeRecyclerview.setAdapter(goodInfoLikeRecyclerviewAdapter);
        goodInfoLikeRecyclerview.setNestedScrollingEnabled(false);
    }

    private void setBanner() {
        final List url = new ArrayList<String>();
        url.add("https://img.zcool.cn/community/012b475bffad00a80120925239f845.jpg@1280w_1l_2o_100sh.jpg");
        url.add("https://img.zcool.cn/community/01ddb05bffad01a80121ab5de25693.jpg@1280w_1l_2o_100sh.jpg");
        url.add("https://img.zcool.cn/community/01a1885bffad02a80121ab5d6079e6.jpg@1280w_1l_2o_100sh.jpg");
        goodInfoXbanner.setBannerData(url);
        goodInfoXbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(GoodInfoActivity.this).load((String) model).into((ImageView) view);
            }
        });
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
            case R.id.good_info_share:
                View inflate_share = getLayoutInflater().inflate(R.layout.dialog_share, null);
                final ButtomDialogView buttomDialogView = DialogUtils.shareDialog(GoodInfoActivity.this, inflate_share, true, true);
                ImageView dialogShare = buttomDialogView.findViewById(R.id.dialog_share);
                ImageView dialogPic = buttomDialogView.findViewById(R.id.dialog_pic);
                dialogShare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //分享
                        buttomDialogView.dismiss();
                    }
                });
                dialogPic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttomDialogView.dismiss();
                        //海报
                        View inflate_pic = getLayoutInflater().inflate(R.layout.dialog_pic, null);
                        CenterPicDialogView centerDialogView = DialogUtils.PicDialog(GoodInfoActivity.this, inflate_pic, true, true);
                        ImageView dialogPicIv = centerDialogView.findViewById(R.id.dialog_pic_iv);
                        Glide.with(GoodInfoActivity.this).load("https://img.zcool.cn/community/01b3c55bd2a7eda8012099c8e96a8d.jpg@1280w_1l_2o_100sh.jpg").into(dialogPicIv);
                    }
                });
                break;
            case  R.id.good_info_add://假如购物车
                View inflate_add = getLayoutInflater().inflate(R.layout.dialog_buy, null);
                final ButtomDialogView buyDialog = DialogUtils.buyDialog(GoodInfoActivity.this, inflate_add, true, true);
                ImageView dialogBuyIv=buyDialog.findViewById(R.id.dialog_buy_iv);
                Glide.with(this).load("https://img.zcool.cn/community/01b3c55bd2a7eda8012099c8e96a8d.jpg@1280w_1l_2o_100sh.jpg")
                        .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(40, 0))).into(dialogBuyIv);
                break;
            case R.id.good_info_buy://购买
                View inflate_buy = getLayoutInflater().inflate(R.layout.dialog_buy, null);
                final ButtomDialogView dialogView = DialogUtils.buyDialog(GoodInfoActivity.this, inflate_buy, true, true);
                ImageView dialogBuyIv1=dialogView.findViewById(R.id.dialog_buy_iv);
                Glide.with(this).load("https://img.zcool.cn/community/01b3c55bd2a7eda8012099c8e96a8d.jpg@1280w_1l_2o_100sh.jpg")
                        .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(40, 0))).into(dialogBuyIv1);
                break;
        }
    }

}
