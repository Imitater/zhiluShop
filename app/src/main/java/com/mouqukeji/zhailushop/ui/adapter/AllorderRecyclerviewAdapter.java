package com.mouqukeji.zhailushop.ui.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mouqukeji.zhailushop.R;
import com.mouqukeji.zhailushop.ui.activity.OrderInfoActivity;
import com.mouqukeji.zhailushop.utils.MultipleOrderItem;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class AllorderRecyclerviewAdapter extends BaseMultiItemQuickAdapter<MultipleOrderItem, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public AllorderRecyclerviewAdapter(List<MultipleOrderItem> data) {
        super(data);
        addItemType(MultipleOrderItem.PAY_Order, R.layout.adapter_pay_order);
        addItemType(MultipleOrderItem.Ongoing_Order, R.layout.adapter_ongoing_order);
        addItemType(MultipleOrderItem.ToEvaluate_Order, R.layout.adapter_to_evaluate_order);
        addItemType(MultipleOrderItem.Return_Order, R.layout.adapter_return_order);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleOrderItem item) {
        switch (helper.getItemViewType()) {
            case 0:
                List pay=new ArrayList<Integer>();
                for (int i = 0; i < 2; i++) {
                    pay.add(i);
                }
                RecyclerView adapterPayOrderRecyclerview=helper.getView(R.id.adapter_all_order_recyclerview);
                adapterPayOrderRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
                AdapterAllOrderAdapter adapterPayOrderAdapter = new AdapterAllOrderAdapter(R.layout.adapter_all_order_layout,pay);
                adapterPayOrderRecyclerview.setAdapter(adapterPayOrderAdapter);
                adapterPayOrderAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(mContext, OrderInfoActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 1:
                List send=new ArrayList<Integer>();
                for (int i = 0; i < 2; i++) {
                    send.add(i);
                }
                RecyclerView adapterSendOrderRecyclerview=helper.getView(R.id.adapter_all_order_recyclerview);
                adapterSendOrderRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
                AdapterAllOrderAdapter adapterSendOrderAdapter = new AdapterAllOrderAdapter(R.layout.adapter_all_order_layout,send);
                adapterSendOrderRecyclerview.setAdapter(adapterSendOrderAdapter);
                adapterSendOrderAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(mContext, OrderInfoActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 2:
                List evaluate=new ArrayList<Integer>();
                for (int i = 0; i < 2; i++) {
                    evaluate.add(i);
                }
                RecyclerView adapterEvaluateOrderRecyclerview=helper.getView(R.id.adapter_all_order_recyclerview);
                adapterEvaluateOrderRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
                AdapterAllOrderAdapter adapterEvaluateOrderAdapter = new AdapterAllOrderAdapter(R.layout.adapter_all_order_layout,evaluate);
                adapterEvaluateOrderRecyclerview.setAdapter(adapterEvaluateOrderAdapter);
                adapterEvaluateOrderAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(mContext, OrderInfoActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 3:
                List returnGood=new ArrayList<Integer>();
                for (int i = 0; i < 2; i++) {
                    returnGood.add(i);
                }
                RecyclerView adapterreturnGoodOrderRecyclerview=helper.getView(R.id.adapter_all_order_recyclerview);
                adapterreturnGoodOrderRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
                AdapterAllOrderAdapter adapterreturnGoodOrderAdapter = new AdapterAllOrderAdapter(R.layout.adapter_all_order_layout,returnGood);
                adapterreturnGoodOrderRecyclerview.setAdapter(adapterreturnGoodOrderAdapter);
                adapterreturnGoodOrderAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(mContext, OrderInfoActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
        }
    }
}
