package com.mouqukeji.zhailushop.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.base.BaseActivity;

import butterknife.BindView;

public class AdviceActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.action_back)
    View actionBack;
    @BindView(R.id.action_title)
    TextView actionTitle;
    @BindView(R.id.action_save)
    TextView actionSave;
    @BindView(R.id.question_1_iv)
    ImageView question1Iv;
    @BindView(R.id.question_1)
    LinearLayout question1;
    @BindView(R.id.question_1_item)
    LinearLayout question1Item;
    @BindView(R.id.question_2_iv)
    ImageView question2Iv;
    @BindView(R.id.question_2)
    LinearLayout question2;
    @BindView(R.id.question_2_item)
    LinearLayout question2Item;
    @BindView(R.id.question_3_iv)
    ImageView question3Iv;
    @BindView(R.id.question_3)
    LinearLayout question3;
    @BindView(R.id.question_3_item)
    LinearLayout question3Item;
    @BindView(R.id.question_4_iv)
    ImageView question4Iv;
    @BindView(R.id.question_4)
    LinearLayout question4;
    @BindView(R.id.question_4_item)
    LinearLayout question4Item;
    @BindView(R.id.question_5_iv)
    ImageView question5Iv;
    @BindView(R.id.question_5)
    LinearLayout question5;
    @BindView(R.id.question_5_item)
    LinearLayout question5Item;
    private boolean question1flag = false;
    private boolean question2flag = false;
    private boolean question3flag=false;
    private boolean question4flag=false;
    private boolean question5flag=false;

    @Override
    protected void initViewAndEvents() {

    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_advice;
    }

    @Override
    protected void setUpView() {
        actionTitle.setText("帮助中心");
        setListener();
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }

    private void setListener() {
        question1.setOnClickListener(this);
        question2.setOnClickListener(this);
        question3.setOnClickListener(this);
        question4.setOnClickListener(this);
        question5.setOnClickListener(this);
        actionBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.question_1://问题1
                if (!question1flag) {
                    question1flag = true;
                    question2flag = false;
                    question3flag = false;
                    question4flag = false;
                    question5flag = false;
                    question1Item.setVisibility(View.VISIBLE);
                    question2Item.setVisibility(View.GONE);
                    question3Item.setVisibility(View.GONE);
                    question4Item.setVisibility(View.GONE);
                    question5Item.setVisibility(View.GONE);
                    question1Iv.setBackgroundResource(R.mipmap.mipmap_question_down);
                    question2Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question3Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question4Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question5Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                } else {
                    question1flag = false;
                    question2flag = false;
                    question3flag = false;
                    question4flag = false;
                    question5flag = false;
                    question1Item.setVisibility(View.GONE);
                    question2Item.setVisibility(View.GONE);
                    question3Item.setVisibility(View.GONE);
                    question4Item.setVisibility(View.GONE);
                    question5Item.setVisibility(View.GONE);
                    question1Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question2Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question3Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question4Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question5Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                }
                break;
            case R.id.question_2://问题2
                if (!question2flag) {
                    question2flag = true;
                    question1flag = false;
                    question3flag = false;
                    question4flag = false;
                    question5flag = false;
                    question2Item.setVisibility(View.VISIBLE);
                    question1Item.setVisibility(View.GONE);
                    question3Item.setVisibility(View.GONE);
                    question4Item.setVisibility(View.GONE);
                    question5Item.setVisibility(View.GONE);
                    question2Iv.setBackgroundResource(R.mipmap.mipmap_question_down);
                    question1Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question3Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question4Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question5Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                } else {
                    question2flag = false;
                    question1flag = false;
                    question3flag = false;
                    question4flag = false;
                    question5flag = false;
                    question2Item.setVisibility(View.GONE);
                    question1Item.setVisibility(View.GONE);
                    question3Item.setVisibility(View.GONE);
                    question4Item.setVisibility(View.GONE);
                    question5Item.setVisibility(View.GONE);
                    question2Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question1Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question3Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question4Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question5Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                }
                break;
            case R.id.question_3://问题3
                if (!question3flag) {
                    question2flag = false;
                    question1flag = false;
                    question3flag = true;
                    question4flag = false;
                    question5flag = false;
                    question3Item.setVisibility(View.VISIBLE);
                    question1Item.setVisibility(View.GONE);
                    question2Item.setVisibility(View.GONE);
                    question4Item.setVisibility(View.GONE);
                    question5Item.setVisibility(View.GONE);
                    question3Iv.setBackgroundResource(R.mipmap.mipmap_question_down);
                    question1Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question2Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question4Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question5Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                } else {
                    question3flag = false;
                    question2flag = false;
                    question1flag = false;
                    question4flag = false;
                    question5flag = false;
                    question3Item.setVisibility(View.GONE);
                    question1Item.setVisibility(View.GONE);
                    question2Item.setVisibility(View.GONE);
                    question4Item.setVisibility(View.GONE);
                    question5Item.setVisibility(View.GONE);
                    question3Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question1Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question2Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question4Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question5Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                }
                break;
            case R.id.question_4://问题4
                if (!question4flag) {
                    question2flag = false;
                    question1flag = false;
                    question3flag = false;
                    question4flag = true;
                    question5flag = false;
                    question3Item.setVisibility(View.GONE);
                    question1Item.setVisibility(View.GONE);
                    question2Item.setVisibility(View.GONE);
                    question4Item.setVisibility(View.VISIBLE);
                    question5Item.setVisibility(View.GONE);
                    question3Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question1Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question2Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question4Iv.setBackgroundResource(R.mipmap.mipmap_question_down);
                    question5Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                } else {
                    question3flag = false;
                    question2flag = false;
                    question1flag = false;
                    question4flag = false;
                    question5flag = false;
                    question3Item.setVisibility(View.GONE);
                    question1Item.setVisibility(View.GONE);
                    question2Item.setVisibility(View.GONE);
                    question4Item.setVisibility(View.GONE);
                    question5Item.setVisibility(View.GONE);
                    question3Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question1Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question2Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question4Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question5Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                }
                break;
            case R.id.question_5://问题5
                if (!question5flag) {
                    question2flag = false;
                    question1flag = false;
                    question3flag = false;
                    question4flag = false;
                    question5flag = true;
                    question3Item.setVisibility(View.GONE);
                    question1Item.setVisibility(View.GONE);
                    question2Item.setVisibility(View.GONE);
                    question4Item.setVisibility(View.GONE);
                    question5Item.setVisibility(View.VISIBLE);
                    question3Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question1Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question2Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question4Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question5Iv.setBackgroundResource(R.mipmap.mipmap_question_down);
                } else {
                    question3flag = false;
                    question2flag = false;
                    question1flag = false;
                    question4flag = false;
                    question5flag = false;
                    question3Item.setVisibility(View.GONE);
                    question1Item.setVisibility(View.GONE);
                    question2Item.setVisibility(View.GONE);
                    question4Item.setVisibility(View.GONE);
                    question5Item.setVisibility(View.GONE);
                    question3Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question1Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question2Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question4Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                    question5Iv.setBackgroundResource(R.mipmap.mipmap_gray_next);
                }
                break;
            case R.id.action_back:
                finish();
                break;
        }
    }


}
