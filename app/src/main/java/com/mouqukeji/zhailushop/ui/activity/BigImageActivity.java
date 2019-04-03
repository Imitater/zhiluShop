package com.mouqukeji.zhailushop.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;

import butterknife.BindView;


public class BigImageActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.bigimage_iv)
    PhotoView bigimageIv;
    @BindView(R.id.relativelayout)
    RelativeLayout relativelayout;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_bigimage;
    }

    protected void setUpView() {
        getWindow().setEnterTransition(new Fade().setDuration(1000));
        getWindow().setExitTransition(new Fade().setDuration(1000));
        Intent intent = getIntent();
        String pic = intent.getStringExtra("pic");
        ImageView bigImageIv = findViewById(R.id.bigimage_iv);
        //设置图片
        Glide.with(this).load(pic).into(bigImageIv);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }


    @Override
    public void onClick(View v) {

    }

}
