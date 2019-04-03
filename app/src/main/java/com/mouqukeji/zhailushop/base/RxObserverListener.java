package com.mouqukeji.zhailushop.base;

import android.util.Log;
import android.widget.Toast;

import com.mouqukeji.zhailushop.MyApplication;
import com.mouqukeji.zhailushop.bean.ErrorBean;
import com.mouqukeji.zhailushop.net.BaseObserverListener;

public abstract class RxObserverListener<T> implements BaseObserverListener<T> {
    private IBaseView mView;

    protected RxObserverListener(IBaseView view) {
        this.mView = view;
    }

    /**
     * 统一处理异常情况：包括没网、数据返回错误等
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        RetrofitException.ResponseThrowable responseThrowable = RetrofitException.getResponseThrowable(e);
        Log.e("TAG", "e.code=" + responseThrowable.code + responseThrowable.message);
        ErrorBean errorBean = new ErrorBean();
        errorBean.setMsg(responseThrowable.message);
        errorBean.setCode(responseThrowable.code + "");
        if (mView != null) {
            mView.showException(errorBean);
            Toast.makeText(MyApplication.getContext(), responseThrowable.message, Toast.LENGTH_SHORT);
        }
    }

    /**
     * 接口http结果返回200，但是后台数据返回错误。
     * @param errorBean
     */
    @Override
    public void onBusinessError(ErrorBean errorBean) {
        if (mView != null) {
            mView.showBusinessError(errorBean);
//            CommonUtils.makeEventToast(BaseApplication.getInstance(), errorBean.getMsg(), false);
            Log.e("TAG", "onBusinessError msg=" + errorBean.getMsg());
        }
    }

    @Override
    public void onComplete() {

    }
    @Override
    public void onReLoad() {

    }

    @Override
    public void onBeing() {
    }

    @Override
    public void onStop() {

    }
}
