package com.mouqukeji.zhailushop.ui.fragment;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.contract.HomeContract;
import com.mouqukeji.zhailushop.modle.HomeModel;
import com.mouqukeji.zhailushop.presenter.HomePresenter;
import com.mouqukeji.zhailushop.ui.adapter.HomeRecyclerviewAdapter;
import com.mouqukeji.zhailushop.ui.widget.MyScrollView;
import com.mouqukeji.zhailushop.utils.EventBusUtils;
import com.mouqukeji.zhailushop.utils.EventCode;
import com.mouqukeji.zhailushop.utils.EventMessage;
import com.mouqukeji.zhailushop.utils.MultipleItem;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;


public class HomeFragment extends BaseFragment<HomePresenter, HomeModel> implements HomeContract.View , View.OnClickListener {
    @BindView(R.id.home_recyclerview)
    RecyclerView homeRecyclerview;
    @BindView(R.id.home_sc)
    MyScrollView homeSc;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.home_item_iv)
    ImageView homeItemIv;
    @BindView(R.id.home_search_ll)
    LinearLayout homeSearchLl;
    @BindView(R.id.home_message_iv)
    ImageView homeMessageIv;
    @BindView(R.id.home_all_top_tv_hide)
    TextView homeAllTopTvHide;
    @BindView(R.id.home_all_bottom_tv_hide)
    TextView homeAllBottomTvHide;
    @BindView(R.id.home_all_hide)
    LinearLayout homeAllHide;
    @BindView(R.id.home_man_ll_top_tv_hide)
    TextView homeManLlTopTvHide;
    @BindView(R.id.home_man_ll_bottomo_tv_hide)
    TextView homeManLlBottomoTvHide;
    @BindView(R.id.home_man_ll_hide)
    LinearLayout homeManLlHide;
    @BindView(R.id.home_woman_top_tv_hide)
    TextView homeWomanTopTvHide;
    @BindView(R.id.home_woman_bottom_tv_hide)
    TextView homeWomanBottomTvHide;
    @BindView(R.id.home_woman_hide)
    LinearLayout homeWomanHide;
    @BindView(R.id.home_child_top_tv_hide)
    TextView homeChildTopTvHide;
    @BindView(R.id.home_child_bottom_tv_hide)
    TextView homeChildBottomTvHide;
    @BindView(R.id.home_child_hide)
    LinearLayout homeChildHide;
    @BindView(R.id.home_fashion_top_tv_hide)
    TextView homeFashionTopTvHide;
    @BindView(R.id.home_fashion_bottom_tv_hide)
    TextView homeFashionBottomTvHide;
    @BindView(R.id.home_fashion_hide)
    LinearLayout homeFashionHide;
    @BindView(R.id.home_category_hide)
    LinearLayout homeCategoryHide;
    @BindView(R.id.home_top)
    LinearLayout homeTop;
    private HomeRecyclerviewAdapter homeRecyclerviewAdapter;
    private int[] mLocationHide = new int[2];
    int[] mTitleLocation = new int[2];

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setUpView() {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        homeRecyclerview.setLayoutManager(new LinearLayoutManager(getMContext()));
        homeRecyclerview.setNestedScrollingEnabled(false);

        //设置 多布局type
        List list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            MultipleItem multipleItem = new MultipleItem(i, i);
            list.add(multipleItem);
        }
        //设置Adapter
        homeRecyclerviewAdapter = new HomeRecyclerviewAdapter(getActivity(), list, homeAllTopTvHide, homeManLlTopTvHide, homeWomanTopTvHide, homeChildTopTvHide
                , homeFashionTopTvHide, homeAllBottomTvHide, homeManLlBottomoTvHide, homeWomanBottomTvHide, homeChildBottomTvHide, homeFashionBottomTvHide, supportFragmentManager);
        homeRecyclerview.setAdapter(homeRecyclerviewAdapter);
        //上拉加载&下拉刷新
        setUpLoad();
        //顶部悬浮
        setTop();
        //点击事件
        initListener();
    }

    private void initListener() {
        homeAllHide.setOnClickListener(this);
        homeManLlHide.setOnClickListener(this);
        homeWomanHide.setOnClickListener(this);
        homeChildHide.setOnClickListener(this);
        homeFashionHide.setOnClickListener(this);
        homeSearchLl.setOnClickListener(this);
    }

    private void setTop() {
        homeSc.setScrollChangedListener(new MyScrollView.ScrollChangedListener() {
            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                homeCategoryHide.getLocationOnScreen(mLocationHide);
                homeRecyclerviewAdapter.getHomeCategory().getLocationOnScreen(mTitleLocation);
                if (t > 1200) {
                    t = 1200;
                }
                if (t==0){
                    homeTop.setBackgroundColor(Color.argb(0, 0, 0, 0));
                }
                homeTop.setBackgroundColor(Color.argb(Math.round(t * 1200 * 0.2f / 1200), 0, 0, 0));
                //y方向坐标比较
                if (mTitleLocation[1] > mLocationHide[1]) {
                    homeCategoryHide.setVisibility(View.GONE);
                    homeRecyclerviewAdapter.getHomeCategory().setVisibility(View.VISIBLE);
                } else {
                    homeCategoryHide.setVisibility(View.VISIBLE);
                    homeRecyclerviewAdapter.getHomeCategory().setVisibility(View.INVISIBLE);
                }
            }
        });


    }

    private void setUpLoad() {
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        homeTop.setVisibility(View.VISIBLE);
                        refreshLayout.finishRefreshing();
                    }
                }, 2000);
            }

            @Override
            public void onPullDownReleasing(TwinklingRefreshLayout refreshLayout, float fraction) {
                super.onPullDownReleasing(refreshLayout, fraction);
                if (fraction < 1) {
                    homeTop.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPullingDown(TwinklingRefreshLayout refreshLayout, float fraction) {
                super.onPullingDown(refreshLayout, fraction);
                homeTop.setVisibility(View.GONE);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int pageItem = homeRecyclerviewAdapter.getPageItem();
                        switch (pageItem) {
                            case 0:
                                EventMessage A = new EventMessage(EventCode.EVENT_A, 1);
                                EventBusUtils.post(A);
                                break;
                            case 1:
                                EventMessage B = new EventMessage(EventCode.EVENT_B, 1);
                                EventBusUtils.post(B);
                                break;
                            case 2:
                                EventMessage C = new EventMessage(EventCode.EVENT_C, 1);
                                EventBusUtils.post(C);
                                break;
                            case 3:
                                EventMessage D = new EventMessage(EventCode.EVENT_D, 1);
                                EventBusUtils.post(D);
                                break;
                            case 4:
                                EventMessage E = new EventMessage(EventCode.EVENT_E, 1);
                                EventBusUtils.post(E);
                                break;
                        }
                        refreshLayout.finishLoadmore();
                    }
                }, 2000);
            }
        });
    }

    @Override
    protected void setUpData() {

    }

    @Override
    protected boolean isRegisteredEventBus() {
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_all_hide:
                homeRecyclerviewAdapter.setAll(homeRecyclerviewAdapter.getViewHolder());
                break;
            case R.id.home_man_ll_hide:
                homeRecyclerviewAdapter.setMan(homeRecyclerviewAdapter.getViewHolder());
                break;
            case R.id.home_woman_hide:
                homeRecyclerviewAdapter.setWoman(homeRecyclerviewAdapter.getViewHolder());
                break;
            case R.id.home_child_hide:
                homeRecyclerviewAdapter.setChild(homeRecyclerviewAdapter.getViewHolder());
                break;
            case R.id.home_fashion_hide:
                homeRecyclerviewAdapter.setFashion(homeRecyclerviewAdapter.getViewHolder());
                break;
            case R.id.home_search_ll:
                SearchFragment searchFragment = SearchFragment.newInstance();
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        //这里处理逻辑

                    }
                });
                searchFragment.showFragment(getActivity().getSupportFragmentManager(), SearchFragment.TAG);
                break;
        }
    }
}
