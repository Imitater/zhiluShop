package com.mouqukeji.zhailushop.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import com.mouqukeji.zhailushop.base.BaseLazyFragment;
import com.mouqukeji.zhailushop.contract.ManContract;
import com.mouqukeji.zhailushop.modle.ManModel;
import com.mouqukeji.zhailushop.presenter.ManPresenter;
import com.mouqukeji.zhailushop.ui.activity.GoodInfoActivity;
import com.mouqukeji.zhailushop.ui.adapter.ManRecyclerviewAdapter;
import com.mouqukeji.zhailushop.ui.widget.CustomHomeViewPager;
import com.mouqukeji.zhailushop.utils.EventCode;
import com.mouqukeji.zhailushop.utils.EventMessage;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;


@SuppressLint("ValidFragment")
public class ManFragment extends BaseLazyFragment<ManPresenter, ManModel> implements ManContract.View {
    private final CustomHomeViewPager viewPager;
    @BindView(R.id.man_recyclerview)
    RecyclerView manRecyclerview;
      private List list;
    private ManRecyclerviewAdapter manRecyclerviewAdapter;
    private int page = 1;
    String[] images = {"https://img.zcool.cn/community/01e8a7554b28fe000001bf724d42be.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/01d2b45c305a67a80121df90e4921b.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/01a95d554b2901000001bf72867913.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/01e78e554b28fe000001bf72d41e01.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/013fe0554b2903000001bf72a9b193.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/01c6bd554b28fe000001bf72fea1e0.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/01f3da554b28fe000001bf72c6a75a.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/017e835aaf2a8aa80121246d8f28dd.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/0153de5aaf2a8aa80121246d33f69c.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/013dd2570683b032f875a944b47f62.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/01e8a7554b28fe000001bf724d42be.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/01d2b45c305a67a80121df90e4921b.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/01a95d554b2901000001bf72867913.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/01e78e554b28fe000001bf72d41e01.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/013fe0554b2903000001bf72a9b193.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/01c6bd554b28fe000001bf72fea1e0.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/01f3da554b28fe000001bf72c6a75a.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/017e835aaf2a8aa80121246d8f28dd.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/0153de5aaf2a8aa80121246d33f69c.jpg@1280w_1l_2o_100sh.jpg",
            "https://img.zcool.cn/community/013dd2570683b032f875a944b47f62.jpg@1280w_1l_2o_100sh.jpg"
    };

    public ManFragment(CustomHomeViewPager viewPager) {
        this.viewPager=viewPager;
    }


    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_man;
    }

    @Override
    protected void setUpView() {
        //添加假数据
        initData();
        setRecyclerview();
    }

    private void setRecyclerview() {
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        manRecyclerviewAdapter = new ManRecyclerviewAdapter(R.layout.adapter_man, list);
        manRecyclerview.setLayoutManager(recyclerViewLayoutManager);
        manRecyclerview.setAdapter(manRecyclerviewAdapter);
        manRecyclerview.setNestedScrollingEnabled(false);
        viewPager.setObjectForPosition(getContentView(),1);
        manRecyclerviewAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);//设置recyclerview 动画
        manRecyclerviewAdapter.isFirstOnly(false);//设置动画一直使用
        manRecyclerviewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getMContext(), GoodInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void setUpData() {

    }


    private void initData() {
        list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add(images[i]);
        }
    }

    @Override
    protected boolean isRegisteredEventBus() {
        return true;
    }
    @Override
    public void onReceiveEvent(EventMessage event) {
        super.onReceiveEvent(event);
        if (event != null) {
            if (event.getCode() == EventCode.EVENT_B) {
                if (page<=2) {
                    page++;
                    manRecyclerviewAdapter.addData(list);
                    manRecyclerviewAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    @Override
    protected void loadData() {
        //添加假数据
        initData();
        setRecyclerview();
    }
}
