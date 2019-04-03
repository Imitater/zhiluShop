package com.mouqukeji.zhailushop.ui.fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseFragment;
import butterknife.BindView;


public class LogisticsFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.logistics_bt)
    Button logisticsBt;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_logistics;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("填写物流信息");
        //点击事件
        initListener();
    }

    private void initListener() {
        actionBack.setOnClickListener(this);
    }

    @Override
    protected void setUpData() {

    }

    @Override
    public boolean onBackPressedSupport() {
        pop();
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action_back:
                pop();
                break;
        }
    }
}
