package com.mouqukeji.zhailushop.ui.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.ui.fragment.AllFragment;
import com.mouqukeji.zhailushop.ui.fragment.ChildFragment;
import com.mouqukeji.zhailushop.ui.fragment.FashionFragment;
import com.mouqukeji.zhailushop.ui.fragment.ManFragment;
import com.mouqukeji.zhailushop.ui.fragment.WomanFragment;
import com.mouqukeji.zhailushop.ui.widget.CustomHomeViewPager;
import com.mouqukeji.zhailushop.utils.MultipleItem;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class HomeRecyclerviewAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    private final TextView homeAllTopTvHide;
    private final TextView homeManLlTopTvHide;
    private final TextView homeWomanTopTvHide;
    private final TextView homeChildTopTvHide;
    private final TextView homeFashionTopTvHide;
    private final TextView homeAllBottomTvHide;
    private final TextView homeManLlBottomoTvHide;
    private final TextView homeWomanBottomTvHide;
    private final TextView homeChildBottomTvHide;
    private final TextView homeFashionBottomTvHide;
    private final Activity activity;
    private final FragmentManager supportFragmentManager;
    private List listFragment;
    private CustomHomeViewPager viewPager;
    private int pageItem;
    private LinearLayout homeCategory;
    private BaseViewHolder viewHolder;

    public HomeRecyclerviewAdapter(Activity activity, List data, TextView homeAllTopTvHide,
                                   TextView homeManLlTopTvHide, TextView homeWomanTopTvHide, TextView homeChildTopTvHide,
                                   TextView homeFashionTopTvHide, TextView homeAllBottomTvHide, TextView homeManLlBottomoTvHide,
                                   TextView homeWomanBottomTvHide, TextView homeChildBottomTvHide, TextView homeFashionBottomTvHide, FragmentManager supportFragmentManager) {
        super(data);
        addItemType(MultipleItem.Banner, R.layout.banner);
        addItemType(MultipleItem.Category, R.layout.category);
        addItemType(MultipleItem.Item, R.layout.item);
        addItemType(MultipleItem.List, R.layout.list);
        this.homeAllTopTvHide = homeAllTopTvHide;
        this.homeManLlTopTvHide = homeManLlTopTvHide;
        this.homeWomanTopTvHide = homeWomanTopTvHide;
        this.homeChildTopTvHide = homeChildTopTvHide;
        this.homeAllBottomTvHide = homeAllBottomTvHide;
        this.homeManLlBottomoTvHide = homeManLlBottomoTvHide;
        this.homeFashionTopTvHide = homeFashionTopTvHide;
        this.homeWomanBottomTvHide = homeWomanBottomTvHide;
        this.homeChildBottomTvHide = homeChildBottomTvHide;
        this.homeFashionBottomTvHide = homeFashionBottomTvHide;
        this.activity = activity;
        this.supportFragmentManager = supportFragmentManager;
    }

    @Override
    protected void convert(final BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case 0://Banner
                final List url = new ArrayList<String>();
                url.add("https://img.zcool.cn/community/01d9f75c88ca34a801208f8bb7e879.jpg@1280w_1l_2o_100sh.jpg");
                url.add("https://img.zcool.cn/community/01aad55c88ca35a801214168d6f05d.jpg@1280w_1l_2o_100sh.jpg");
                url.add("https://img.zcool.cn/community/01ff535c88ca35a801208f8b96bcb5.jpg@1280w_1l_2o_100sh.jpg");
                XBanner homeXbanner = helper.getView(R.id.home_xbanner);
                homeXbanner.setBannerData(url);
                homeXbanner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(mContext).load((String) model).into((ImageView) view);
                    }
                });
                break;
            case 1://Category
                Glide.with(mContext).load("https://img.zcool.cn/community/01626a58e4ab96a801219c77255b1e.jpg@1280w_1l_2o_100sh.jpg").into((ImageView) helper.getView(R.id.home_left_top_iv));
                Glide.with(mContext).load("https://img.zcool.cn/community/0112c7583eec1ba801219c7719c9a4.jpg@1280w_1l_2o_100sh.jpg").into((ImageView) helper.getView(R.id.home_left_bottom_iv));
                Glide.with(mContext).load("https://img.zcool.cn/community/01e1505549a2c40000019ae977f537.jpg@1280w_1l_2o_100sh.jpg").into((ImageView) helper.getView(R.id.home_right_iv));
                break;
            case 2://Item
                homeCategory = helper.getView(R.id.home_category);
                viewHolder = helper;
                helper.setOnClickListener(R.id.home_all, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setAll(helper);
                    }
                });
                helper.setOnClickListener(R.id.home_man_ll, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setMan(helper);
                    }
                });
                helper.setOnClickListener(R.id.home_woman, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setWoman(helper);
                    }
                });
                helper.setOnClickListener(R.id.home_child, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setChild(helper);
                    }
                });
                helper.setOnClickListener(R.id.home_fashion, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setFashion(helper);
                    }
                });
                break;
            case 3://List
                viewPager = helper.getView(R.id.list_viewpager);
                initFragment();
                MainPageAdapter mainPageAdapter = new MainPageAdapter(supportFragmentManager, listFragment);
                viewPager.resetHeight(0);
                viewPager.setOffscreenPageLimit(4);
                pageItem = 0;
                viewPager.setAdapter(mainPageAdapter);
                break;
        }
    }

    private void initFragment() {
        listFragment = new ArrayList<Fragment>();
        listFragment.add(new AllFragment(viewPager));
        listFragment.add(new ManFragment(viewPager));
        listFragment.add(new WomanFragment(viewPager));
        listFragment.add(new ChildFragment(viewPager));
        listFragment.add(new FashionFragment(viewPager));
    }


    public void setFashion(BaseViewHolder helper) {
        viewPager.setCurrentItem(4);
        viewPager.resetHeight(4);
        pageItem=4;
        homeAllTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeManLlTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeWomanTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeChildTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeFashionTopTvHide.setTextColor(mContext.getResources().getColor(R.color.home_yellow));

        homeAllBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeManLlBottomoTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeWomanBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeChildBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeFashionBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.type_circle_shape));

        homeAllBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeManLlBottomoTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeWomanBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeChildBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeFashionBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_yellow));

        helper.setTextColor(R.id.home_all_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_man_ll_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_woman_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_child_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_fashion_top_tv, mContext.getResources().getColor(R.color.home_yellow));


        TextView homeAllBottomTv = helper.getView(R.id.home_all_bottom_tv);
        TextView homeManLlBottomoTv = helper.getView(R.id.home_man_ll_bottomo_tv);
        TextView homeWomanBottomTv = helper.getView(R.id.home_woman_bottom_tv);
        TextView homeChildBottomTv = helper.getView(R.id.home_child_bottom_tv);
        TextView homeFashionBottomTv = helper.getView(R.id.home_fashion_bottom_tv);
        homeAllBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeManLlBottomoTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeWomanBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeChildBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeFashionBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.type_circle_shape));

        helper.setTextColor(R.id.home_all_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_man_ll_bottomo_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_woman_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_child_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_fashion_bottom_tv, mContext.getResources().getColor(R.color.home_yellow));
    }

    public void setChild(BaseViewHolder helper) {
        viewPager.setCurrentItem(3);
        viewPager.resetHeight(3);
        pageItem=3;
        homeAllTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeManLlTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeWomanTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeChildTopTvHide.setTextColor(mContext.getResources().getColor(R.color.home_yellow));
        homeFashionTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));

        homeAllBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeManLlBottomoTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeWomanBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeChildBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.type_circle_shape));
        homeFashionBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));

        homeAllBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeManLlBottomoTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeWomanBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeChildBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_yellow));
        homeFashionBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));

        helper.setTextColor(R.id.home_all_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_man_ll_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_woman_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_child_top_tv, mContext.getResources().getColor(R.color.home_yellow));
        helper.setTextColor(R.id.home_fashion_top_tv, mContext.getResources().getColor(R.color.black));

        TextView homeAllBottomTv = helper.getView(R.id.home_all_bottom_tv);
        TextView homeManLlBottomoTv = helper.getView(R.id.home_man_ll_bottomo_tv);
        TextView homeWomanBottomTv = helper.getView(R.id.home_woman_bottom_tv);
        TextView homeChildBottomTv = helper.getView(R.id.home_child_bottom_tv);
        TextView homeFashionBottomTv = helper.getView(R.id.home_fashion_bottom_tv);
        homeAllBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeManLlBottomoTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeWomanBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeChildBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.type_circle_shape));
        homeFashionBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));

        helper.setTextColor(R.id.home_all_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_man_ll_bottomo_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_woman_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_child_bottom_tv, mContext.getResources().getColor(R.color.home_yellow));
        helper.setTextColor(R.id.home_fashion_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
    }

    public void setWoman(BaseViewHolder helper) {
        viewPager.setCurrentItem(2);
        viewPager.resetHeight(2);
        pageItem=2;
        homeAllTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeManLlTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeWomanTopTvHide.setTextColor(mContext.getResources().getColor(R.color.home_yellow));
        homeChildTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeFashionTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));

        homeAllBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeManLlBottomoTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeWomanBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.type_circle_shape));
        homeChildBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeFashionBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));

        homeAllBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeManLlBottomoTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeWomanBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_yellow));
        homeChildBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeFashionBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));

        helper.setTextColor(R.id.home_all_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_man_ll_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_woman_top_tv, mContext.getResources().getColor(R.color.home_yellow));
        helper.setTextColor(R.id.home_child_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_fashion_top_tv, mContext.getResources().getColor(R.color.black));
        TextView homeAllBottomTv = helper.getView(R.id.home_all_bottom_tv);
        TextView homeManLlBottomoTv = helper.getView(R.id.home_man_ll_bottomo_tv);
        TextView homeWomanBottomTv = helper.getView(R.id.home_woman_bottom_tv);
        TextView homeChildBottomTv = helper.getView(R.id.home_child_bottom_tv);
        TextView homeFashionBottomTv = helper.getView(R.id.home_fashion_bottom_tv);
        homeAllBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeManLlBottomoTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeWomanBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.type_circle_shape));
        homeChildBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeFashionBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));

        helper.setTextColor(R.id.home_all_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_man_ll_bottomo_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_woman_bottom_tv, mContext.getResources().getColor(R.color.home_yellow));
        helper.setTextColor(R.id.home_child_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_fashion_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
    }

    public void setMan(BaseViewHolder helper) {
        viewPager.setCurrentItem(1);
        viewPager.resetHeight(1);
        pageItem=1;
        homeAllTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeManLlTopTvHide.setTextColor(mContext.getResources().getColor(R.color.home_yellow));
        homeWomanTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeChildTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeFashionTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));

        homeAllBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeManLlBottomoTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.type_circle_shape));
        homeWomanBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeChildBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeFashionBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));

        homeAllBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeManLlBottomoTvHide.setTextColor(mContext.getResources().getColor(R.color.home_yellow));
        homeWomanBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeChildBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeFashionBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));

        helper.setTextColor(R.id.home_all_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_man_ll_top_tv, mContext.getResources().getColor(R.color.home_yellow));
        helper.setTextColor(R.id.home_woman_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_child_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_fashion_top_tv, mContext.getResources().getColor(R.color.black));

        TextView homeAllBottomTv = helper.getView(R.id.home_all_bottom_tv);
        TextView homeManLlBottomoTv = helper.getView(R.id.home_man_ll_bottomo_tv);
        TextView homeWomanBottomTv = helper.getView(R.id.home_woman_bottom_tv);
        TextView homeChildBottomTv = helper.getView(R.id.home_child_bottom_tv);
        TextView homeFashionBottomTv = helper.getView(R.id.home_fashion_bottom_tv);
        homeAllBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeManLlBottomoTv.setBackground(mContext.getResources().getDrawable(R.drawable.type_circle_shape));
        homeWomanBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeChildBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeFashionBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));

        helper.setTextColor(R.id.home_all_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_man_ll_bottomo_tv, mContext.getResources().getColor(R.color.home_yellow));
        helper.setTextColor(R.id.home_woman_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_child_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_fashion_bottom_tv, mContext.getResources().getColor(R.color.home_gray));


    }

    public void setAll(BaseViewHolder helper) {
        viewPager.setCurrentItem(0);
        viewPager.resetHeight(0);
        pageItem=0;
        homeAllTopTvHide.setTextColor(mContext.getResources().getColor(R.color.home_yellow));
        homeManLlTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeWomanTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeChildTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));
        homeFashionTopTvHide.setTextColor(mContext.getResources().getColor(R.color.black));

        homeAllBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.type_circle_shape));
        homeManLlBottomoTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeWomanBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeChildBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeFashionBottomTvHide.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));

        homeAllBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_yellow));
        homeManLlBottomoTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeWomanBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeChildBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));
        homeFashionBottomTvHide.setTextColor(mContext.getResources().getColor(R.color.home_gray));

        helper.setTextColor(R.id.home_all_top_tv, mContext.getResources().getColor(R.color.home_yellow));
        helper.setTextColor(R.id.home_man_ll_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_woman_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_child_top_tv, mContext.getResources().getColor(R.color.black));
        helper.setTextColor(R.id.home_fashion_top_tv, mContext.getResources().getColor(R.color.black));

        TextView homeAllBottomTv = helper.getView(R.id.home_all_bottom_tv);
        TextView homeManLlBottomoTv = helper.getView(R.id.home_man_ll_bottomo_tv);
        TextView homeWomanBottomTv = helper.getView(R.id.home_woman_bottom_tv);
        TextView homeChildBottomTv = helper.getView(R.id.home_child_bottom_tv);
        TextView homeFashionBottomTv = helper.getView(R.id.home_fashion_bottom_tv);
        homeAllBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.type_circle_shape));
        homeManLlBottomoTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeWomanBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeChildBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));
        homeFashionBottomTv.setBackground(mContext.getResources().getDrawable(R.drawable.home_gray_shape));

        helper.setTextColor(R.id.home_all_bottom_tv, mContext.getResources().getColor(R.color.home_yellow));
        helper.setTextColor(R.id.home_man_ll_bottomo_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_woman_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_child_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
        helper.setTextColor(R.id.home_fashion_bottom_tv, mContext.getResources().getColor(R.color.home_gray));
    }

    public int getPageItem() {
        return pageItem;
    }

    public LinearLayout getHomeCategory() {
        return homeCategory;
    }

    public BaseViewHolder getViewHolder() {
        return viewHolder;
    }
}
