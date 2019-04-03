package com.mouqukeji.zhailushop.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;
import com.mouqukeji.zhailushop.contract.HelpContract;
import com.mouqukeji.zhailushop.modle.HelpModel;
import com.mouqukeji.zhailushop.presenter.HelpPresenter;
import com.mouqukeji.zhailushop.ui.fragment.QuestionFragment;
import com.mouqukeji.zhailushop.ui.fragment.RechangeListFragment;
import com.mouqukeji.zhailushop.utils.DialogUtils;
import com.mouqukeji.zhailushop.utils.update.ICheckAgent;
import com.mouqukeji.zhailushop.utils.update.IUpdateChecker;
import com.mouqukeji.zhailushop.utils.update.IUpdateParser;
import com.mouqukeji.zhailushop.utils.update.UpdateInfo;
import com.mouqukeji.zhailushop.utils.update.UpdateManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HelpActivity extends BaseActivity<HelpPresenter, HelpModel> implements HelpContract.View, View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.help_advice)
    LinearLayout helpAdvice;
    @BindView(R.id.help_call)
    LinearLayout helpCall;
    @BindView(R.id.help_version_number)
    TextView helpVersionNumber;
    @BindView(R.id.help_version)
    LinearLayout helpVersion;
    @BindView(R.id.help_framelayout)
    FrameLayout helpFramelayout;

    String mCheckUrl = "http://client.waimai.baidu.com/message/updatetag";

    String mUpdateUrl = "http://mobile.ac.qq.com/qqcomic_android.apk";
    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_help;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("设置");
        initListenerz();
    }

    private void initListenerz() {
        actionBack.setOnClickListener(this);
        helpAdvice.setOnClickListener(this);
        helpCall.setOnClickListener(this);
        helpVersion.setOnClickListener(this);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action_back:
                HelpActivity.this.finish();
                break;
            case R.id.help_advice:
                //意见反馈
                helpFramelayout.setVisibility(View.VISIBLE);
                loadRootFragment(R.id.help_framelayout, new QuestionFragment());
                break;
            case R.id.help_call:
                //显示dialog
                View dialog_iscall = getLayoutInflater().inflate(R.layout.dialog_iscall, null);
                DialogUtils.callDialog(HelpActivity.this, dialog_iscall, true, true);
                break;
            case R.id.help_version:
                check(true, true, false, false, true, 998);
                break;
        }
    }
    void check(boolean isManual, final boolean hasUpdate, final boolean isForce, final boolean isSilent, final boolean isIgnorable, final int
            notifyId) {
        UpdateManager.create(this).setChecker(new IUpdateChecker() {
            @Override
            public void check(ICheckAgent agent, String url) {
                 agent.setInfo("");
            }
        }).setUrl(mCheckUrl).setManual(isManual).setNotifyId(notifyId).setParser(new IUpdateParser() {
            @Override
            public UpdateInfo parse(String source) throws Exception {
                UpdateInfo info = new UpdateInfo();
                info.hasUpdate = hasUpdate;
                info.updateContent = "• 支持文字、贴纸、背景音乐，尽情展现欢乐气氛；\n• 两人视频通话支持实时滤镜，丰富滤镜，多彩心情；\n• 图片编辑新增艺术滤镜，一键打造文艺画风；\n• 资料卡新增点赞排行榜，看好友里谁是魅力之王。";
                info.versionCode = 587;
                info.versionName = "v5.8.7";
                info.url = mUpdateUrl;
                info.md5 = "56cf48f10e4cf6043fbf53bbbc4009e3";
                info.size = 10149314;
                info.isForce = isForce;
                info.isIgnorable = isIgnorable;
                info.isSilent = isSilent;
                return info;
            }
        }).check();
    }

}
