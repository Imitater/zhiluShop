package com.mouqukeji.zhailushop.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;
import com.mouqukeji.zhailushop.contract.MyInfoContract;
import com.mouqukeji.zhailushop.modle.MyInfoModel;
import com.mouqukeji.zhailushop.presenter.MyInfoPresenter;
import com.mouqukeji.zhailushop.ui.widget.CenterDialogView;
import com.mouqukeji.zhailushop.ui.widget.SmoothCheckBox;
import com.mouqukeji.zhailushop.utils.DateUtils;
import com.mouqukeji.zhailushop.utils.KeyUtils;
import com.mouqukeji.zhailushop.utils.TokenHelper;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyInfoActivity extends BaseActivity<MyInfoPresenter, MyInfoModel> implements MyInfoContract.View, View.OnClickListener {
    List<LocalMedia> list = new ArrayList<>();
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.info_head)
    CircleImageView infoHead;
    @BindView(R.id.info_name)
    EditText infoName;
    @BindView(R.id.info_sex)
    TextView infoSex;
    @BindView(R.id.info_sex_item)
    LinearLayout infoSexItem;
    @BindView(R.id.info_age)
    EditText infoAge;
    @BindView(R.id.info_age_item)
    LinearLayout infoAgeItem;
    @BindView(R.id.info_progress)
    LinearLayout infoProgress;


    private String url;
    private String sex;
    private String spUserID;
    private String address;
    private String age;
    private String name;

    @Override
    protected void initViewAndEvents() {
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_info;
    }

    @Override
    protected void setUpView() {
        actionSave.setVisibility(View.VISIBLE);
        actionSave.setText("保存");
        actionTitle.setText("我的资料");
        initListener();
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }

    private void initListener() {
        actionBack.setOnClickListener(this);
        infoSexItem.setOnClickListener(this);
        infoHead.setOnClickListener(this);
        actionSave.setOnClickListener(this);
        infoAge.addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            infoAge.setSelection(s.length());
        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_back:
                finish();
                break;
            case R.id.info_sex_item://性别选择
                //判断性别
                View inflate_info_sex = getLayoutInflater().inflate(R.layout.dialog_info_sex, null);
                infoSexDialog(MyInfoActivity.this, inflate_info_sex, true, true, infoSex);
                break;
            case R.id.info_head:
                setHead();//设置头像
                break;
            case R.id.action_save:
                //保存修改
                if (TextUtils.isEmpty(infoName.getText().toString())) {
                    Toast.makeText(MyInfoActivity.this, "昵称不能为空", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(infoAge.getText().toString())) {
                    Toast.makeText(MyInfoActivity.this, "年龄不能为空", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(url)) {
                    Toast.makeText(MyInfoActivity.this, "请选择上传图片", Toast.LENGTH_SHORT).show();
                } else {
                 }
                break;
        }
    }


    private void setHead() {
        PictureSelector.create(MyInfoActivity.this)
                .openGallery(PictureMimeType.ofImage())
                .theme(R.style.picture_default_style)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(1)// 最大图片选择数量 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .cropCompressQuality(50)
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .enableCrop(true)// 是否裁剪 true or false
                .compress(true)// 是否压缩 true or false
                .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示 true or false
                .isGif(false)// 是否显示gif图片 true or false
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(true)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .selectionMedia(list)// 是否传入已选图片 List<LocalMedia> list
                .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
                .isDragFrame(true)// 是否可拖动裁剪框(固定)
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    list = PictureSelector.obtainMultipleResult(data);
                    uploadImgSignQiNiu(list.get(0).getCompressPath());
                    infoProgress.setVisibility(View.VISIBLE);
                    break;
            }

        }
    }


    public void uploadImgSignQiNiu(final String path) {
        int num = (int) ((Math.random() * 9 + 1) * 100000);
        String key = "icon_" + num + DateUtils.getData();
        TokenHelper tokenHelper = TokenHelper.create(KeyUtils.Access_Key, KeyUtils.Secret_Key);
        String token = tokenHelper.getToken(KeyUtils.Bucket);
        UploadManager uploadManager = new UploadManager();
        uploadManager.put(path, key, token, new UpCompletionHandler() {
            @Override
            public void complete(String key, ResponseInfo info, JSONObject res) {
                //res包含hash、key等信息，具体字段取决于上传策略的设置
                if (info.isOK()) {
                    url = KeyUtils.Base_Url + key;
                    Glide.with(MyInfoActivity.this).load(list.get(0).getCompressPath()).into(infoHead);
                    infoProgress.setVisibility(View.GONE);
                } else {
                    Log.i("picture", "Upload Fail");
                    //如果失败，这里可以把info信息上报自己的服务器，便于后面分析上传错误原因
                }
                Log.i("picture", key + ",\r\n " + info + ",\r\n " + res);
            }
        }, null);
    }





    //男女列表
    public void infoSexDialog(final Context context, View view, final boolean isCancelable, boolean isBackCancelable, final TextView tv) {
        final CenterDialogView centerDialogView = new CenterDialogView(context, view, isCancelable, isBackCancelable);
        centerDialogView.show();
        LinearLayout dialogInfoManInfo = centerDialogView.findViewById(R.id.dialog_info_man_info);
        LinearLayout dialogInfoWomanInfo = centerDialogView.findViewById(R.id.dialog_info_woman_info);
        LinearLayout dialogInfoDefaulInfo = centerDialogView.findViewById(R.id.dialog_info_defaul_info);

        final SmoothCheckBox dialogInfoManInfoBt = centerDialogView.findViewById(R.id.dialog_info_man_info_bt);
        final SmoothCheckBox dialogInfoWomanInfoBt = centerDialogView.findViewById(R.id.dialog_info_woman_info_bt);
        final SmoothCheckBox dialogInfoDefaulInfoBt = centerDialogView.findViewById(R.id.dialog_info_defaul_info_bt);
        sex="0";
        if (sex.equals("0")) {
            setSexDefaul(context, dialogInfoManInfoBt, dialogInfoWomanInfoBt, dialogInfoDefaulInfoBt);
        } else if (sex.equals("1")) {
            setSexMan(context, dialogInfoManInfoBt, dialogInfoWomanInfoBt, dialogInfoDefaulInfoBt);
        } else {
            setSexWoman(context, dialogInfoManInfoBt, dialogInfoWomanInfoBt, dialogInfoDefaulInfoBt);
        }
        //选中男
        dialogInfoManInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex = "1";
                setSexMan(context, dialogInfoManInfoBt, dialogInfoWomanInfoBt, dialogInfoDefaulInfoBt);
                tv.setText("男");
                centerDialogView.dismiss();
            }
        });
        dialogInfoManInfoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex = "1";
                setSexMan(context, dialogInfoManInfoBt, dialogInfoWomanInfoBt, dialogInfoDefaulInfoBt);
                tv.setText("男");
                centerDialogView.dismiss();
            }
        });
        //选择女
        dialogInfoWomanInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex = "2";
                setSexWoman(context, dialogInfoManInfoBt, dialogInfoWomanInfoBt, dialogInfoDefaulInfoBt);
                tv.setText("女");
                centerDialogView.dismiss();
            }
        });
        dialogInfoWomanInfoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex = "2";
                setSexWoman(context, dialogInfoManInfoBt, dialogInfoWomanInfoBt, dialogInfoDefaulInfoBt);
                tv.setText("女");
                centerDialogView.dismiss();
            }
        });
        //保密
        dialogInfoDefaulInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex = "0";
                setSexDefaul(context, dialogInfoManInfoBt, dialogInfoWomanInfoBt, dialogInfoDefaulInfoBt);
                tv.setText("保密");
                centerDialogView.dismiss();
            }
        });
        dialogInfoDefaulInfoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex = "0";
                setSexDefaul(context, dialogInfoManInfoBt, dialogInfoWomanInfoBt, dialogInfoDefaulInfoBt);
                tv.setText("保密");
                centerDialogView.dismiss();
            }
        });
    }

    //设置性别为女
    private void setSexWoman(Context context, SmoothCheckBox dialogInfoManInfoBt, SmoothCheckBox dialogInfoWomanInfoBt, SmoothCheckBox dialogInfoDefaulInfoBt) {
        dialogInfoManInfoBt.setChecked(false);
        dialogInfoWomanInfoBt.setChecked(true);
        dialogInfoDefaulInfoBt.setChecked(false);
        dialogInfoManInfoBt.setChecked(false,false);
        dialogInfoWomanInfoBt.setChecked(true,false);
        dialogInfoDefaulInfoBt.setChecked(false,false);
    }

    //设置性别为男
    private void setSexMan(Context context, SmoothCheckBox dialogInfoManInfoBt, SmoothCheckBox dialogInfoWomanInfoBt, SmoothCheckBox dialogInfoDefaulInfoBt) {
        dialogInfoManInfoBt.setChecked(true);
        dialogInfoWomanInfoBt.setChecked(false);
        dialogInfoDefaulInfoBt.setChecked(false);
        dialogInfoManInfoBt.setChecked(true,false);
        dialogInfoWomanInfoBt.setChecked(false,false);
        dialogInfoDefaulInfoBt.setChecked(false,false);
    }

    //设置性别为保密
    private void setSexDefaul(Context context, SmoothCheckBox dialogInfoManInfoBt, SmoothCheckBox dialogInfoWomanInfoBt, SmoothCheckBox dialogInfoDefaulInfoBt) {
        dialogInfoManInfoBt.setChecked(false);
        dialogInfoWomanInfoBt.setChecked(false);
        dialogInfoDefaulInfoBt.setChecked(true);
        dialogInfoManInfoBt.setChecked(false,false);
        dialogInfoWomanInfoBt.setChecked(false,false);
        dialogInfoDefaulInfoBt.setChecked(true,false);
    }



}
