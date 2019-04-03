package com.mouqukeji.zhailushop.contract;
import com.mouqukeji.zhailushop.base.BaseModel;
import com.mouqukeji.zhailushop.base.BasePresenter;
import com.mouqukeji.zhailushop.base.IBaseView;

public interface AddressContract {
    interface View extends IBaseView {

    }

    interface Model extends BaseModel {
     }

    abstract class Presenter extends BasePresenter<AddressContract.View, AddressContract.Model> {
     }
}

