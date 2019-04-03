package com.mouqukeji.zhailushop.net;


import com.mouqukeji.zhailushop.bean.ErrorBean;

public interface BaseObserverListener<T> {
    void onSuccess(T result);
    void onComplete();
    void onError(Throwable e);
    void onBusinessError(ErrorBean errorBean);
    void onReLoad();
    void onBeing();
    void onStop();
}
