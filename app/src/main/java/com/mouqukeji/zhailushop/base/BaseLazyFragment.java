package com.mouqukeji.zhailushop.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import com.mouqukeji.zhailushop.bean.ErrorBean;
import com.mouqukeji.zhailushop.ui.widget.MultipleStatusView;
import com.mouqukeji.zhailushop.utils.ClassReflectHelper;
import com.mouqukeji.zhailushop.utils.EventBusUtils;
import com.mouqukeji.zhailushop.utils.EventMessage;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.jessyan.autosize.AutoSizeConfig;
import me.yokeyword.fragmentation.SupportFragment;

public abstract class BaseLazyFragment<P extends BasePresenter, M extends BaseModel> extends SupportFragment  implements IBaseView, View.OnTouchListener {
    private View mContentView;
    private Context mContext;
    private Unbinder mUnbinder;
    protected P mMvpPresenter;
    protected M mModel;
    protected MultipleStatusView mMultipleStateView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (setLayoutResourceID() != 0) {
            mMultipleStateView = new MultipleStatusView(getActivity());
            mContentView = inflater.inflate(setLayoutResourceID(), mMultipleStateView, false);
            mContentView.setOnTouchListener(this);
            mContext = getContext();
            mUnbinder = ButterKnife.bind(this, mContentView);
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
        //MVP
        mMvpPresenter = ClassReflectHelper.getT(this, 0);
        mModel = ClassReflectHelper.getT(this, 1);
        if (this instanceof IBaseView) {
            if (mMvpPresenter != null && mModel != null) {
                mMvpPresenter.setVM(this, mModel);
            }
        }
        if (isRegisteredEventBus()) {
            EventBusUtils.register(this);
        }
        initViewAndEvents();
        init();
        setUpView();
        setUpData();
        isViewCreated = true;
        lazyLoad();
        AutoSizeConfig.getInstance().setCustomFragment(true);

        return mContentView;
    }

    protected abstract void initViewAndEvents();

    /**
     * 此方法用于返回Fragment设置ContentView的布局文件资源ID
     *
     * @return 布局文件资源ID
     */
    protected abstract int setLayoutResourceID();

    /**
     * 一些View的相关操作
     */
    protected abstract void setUpView();

    /**
     * 一些Data的相关操作
     */
    protected abstract void setUpData();

    /**
     * 此方法用于初始化成员变量及获取Intent传递过来的数据
     * 注意：这个方法中不能调用所有的View，因为View还没有被初始化，要使用View在initView方法中调用
     */
    protected void init() {
    }

    public View getContentView() {
        return mContentView;
    }

    public Context getMContext() {
        return mContext;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }


    @Override
    public Context getContext() {
        return super.getContext();
    }

    /**
     * 是否注册事件分发
     *
     * @return true 注册；false 不注册，默认不注册
     */
    protected boolean isRegisteredEventBus() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        //注销 eventbus
        if (isRegisteredEventBus()) {
            EventBusUtils.unregister(this);
        }
        //页面销毁,恢复标记
        isViewCreated = false;
        isUIVisible = false;
    }

    @Override
    public void showLoading(MultipleStatusView multipleStatusView, String msg) {

    }

    /**
     * 接收到分发的事件
     *
     * @param event 事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveEvent(EventMessage event) {
    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onReceiveStickyEvent(EventMessage event) {
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showBusinessError(ErrorBean error) {
        mMultipleStateView.showError();
    }

    @Override
    public void showException(ErrorBean error) {
        mMultipleStateView.showNoNetwork();
    }


    //Fragment的View加载完毕的标记
    private boolean isViewCreated;
    //Fragment对用户可见的标记0
    private boolean isUIVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }


    /**
     * 延迟加载
     * 子类必须重写此方法
     */

    private void lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            loadData();
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;
         }
    }

    protected abstract void loadData();

}
