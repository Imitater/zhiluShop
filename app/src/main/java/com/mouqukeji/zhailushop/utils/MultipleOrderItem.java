package com.mouqukeji.zhailushop.utils;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MultipleOrderItem implements MultiItemEntity {
    public static final int PAY_Order = 0;
    public static final int Ongoing_Order = 1;
    public static final int ToEvaluate_Order = 2;
    public static final int Return_Order = 3;

    private int itemType = 0;


    public MultipleOrderItem(int itemType, int i) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}


