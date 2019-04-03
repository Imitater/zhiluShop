package com.mouqukeji.zhailushop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.ui.widget.ButtomDialogView;
import com.mouqukeji.zhailushop.ui.widget.CenterDialogView;
import com.mouqukeji.zhailushop.ui.widget.CenterPicDialogView;
import com.mouqukeji.zhailushop.ui.widget.PickerScrollView;
import com.mouqukeji.zhailushop.ui.widget.Pickers;

import java.util.ArrayList;
import java.util.List;

public class DialogUtils {


    private static int causeId;
    private static String cause;

    //拨打电话
    public static void callDialog(final Context context, View view, boolean isCancelable, boolean isBackCancelable) {
        final CenterDialogView dialogView = new CenterDialogView(context, view, isCancelable, isBackCancelable);
        dialogView.show();
        TextView dialogCall = dialogView.findViewById(R.id.dialog_call);
        dialogCall.setOnClickListener(new View.OnClickListener() {//拨打
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                Uri data = Uri.parse("tel:" + "400-179-0720");
                intent.setData(data);
                context.startActivity(intent);
                dialogView.dismiss();
            }
        });
        TextView dialogDismiss = dialogView.findViewById(R.id.dialog_dismiss);
        dialogDismiss.setOnClickListener(new View.OnClickListener() {//取消
            @Override
            public void onClick(View v) {
                dialogView.dismiss();
            }
        });
    }

    //分享
    public static ButtomDialogView shareDialog(final Activity activity, View view, final boolean isCancelable, boolean isBackCancelable) {
        final ButtomDialogView buttomDialogView = new ButtomDialogView(activity, view, isCancelable, isBackCancelable);
        buttomDialogView.show();
        Button dismiss=buttomDialogView.findViewById(R.id.dialog_dismiss);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttomDialogView.dismiss();
            }
        });
        return buttomDialogView;
    }
    //海报
    public static CenterPicDialogView PicDialog(final Context context, View view, boolean isCancelable, boolean isBackCancelable) {
        final CenterPicDialogView dialogView = new CenterPicDialogView(context, view, isCancelable, isBackCancelable);
        dialogView.show();
        Button dialogPicDismiss=dialogView.findViewById(R.id.dialog_pic_dismiss);
        dialogPicDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView.dismiss();
            }
        });
        return dialogView;
    }
    private static PickerScrollView pickerScrollView;

    //设置退款原因
    public static int showButtomCauseDialog(final Context context, View view, boolean isCancelable, boolean isBackCancelable, final TextView textView) {
        final ButtomDialogView buttomDialogView = new ButtomDialogView(context, view, isCancelable, isBackCancelable);
        buttomDialogView.show();

        pickerScrollView = buttomDialogView.findViewById(R.id.dialog_pickerscrollview);
        TextView dialogDissmiss = buttomDialogView.findViewById(R.id.dialog_dissmiss);
        TextView dialogEnter = buttomDialogView.findViewById(R.id.dialog_enter);

        //設置item數據
        List list = new ArrayList<Pickers>();
        String[] id = new String[]{"0", "1"};
        String[] name = new String[]{"尺寸拍错／不喜欢／效果差", "现在不想要了"};
        for (int i = 0; i < name.length; i++) {
            list.add(new Pickers(name[i], id[i]));
        }
        // 设置数据，默认选择第一条
        pickerScrollView.setData(list);
        pickerScrollView.setSelected(causeId);

        // 滚动选择器选中事件
        pickerScrollView.setOnSelectListener(new PickerScrollView.onSelectListener() {
            @Override
            public void onSelect(Pickers pickers) {
                causeId = Integer.parseInt(pickers.getShowId());
                cause = pickers.getShowConetnt();
            }
        });
        dialogDissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //關閉dialog
                buttomDialogView.dismiss();
            }
        });
        dialogEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //確定并關閉
                if (TextUtils.isEmpty(cause)) {
                    cause = "尺寸拍错／不喜欢／效果差";
                } else {
                    textView.setTextColor(context.getResources().getColor(R.color.black));
                    textView.setText(cause);
                }
                buttomDialogView.dismiss();
            }
        });
        return causeId;
    }
    //购买设置
    public static ButtomDialogView buyDialog(final Activity activity, View view, final boolean isCancelable, boolean isBackCancelable) {
        final ButtomDialogView buttomDialogView = new ButtomDialogView(activity, view, isCancelable, isBackCancelable);
        buttomDialogView.show();
        ImageView dismiss=buttomDialogView.findViewById(R.id.dialog_dismiss);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttomDialogView.dismiss();
            }
        });
        return buttomDialogView;
    }
}
