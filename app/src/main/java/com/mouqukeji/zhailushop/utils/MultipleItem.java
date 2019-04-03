package com.mouqukeji.zhailushop.utils;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MultipleItem implements MultiItemEntity {
    public static final int Banner = 0;
    public static final int Category = 1;
    public static final int Item = 2;
    public static final int List = 3;

    private int itemType = 0;


    public MultipleItem(int itemType, int i) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}


