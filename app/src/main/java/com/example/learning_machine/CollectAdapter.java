package com.example.learning_machine;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diredre
 * @brief description
 * @date 2022-05-25
 */
public class CollectAdapter extends BaseQuickAdapter<CollectBean, BaseViewHolder> {

    private static final String TAG = "CollectAdapter";
    private Context context;
    private List<CollectBean> collectBeanList = new ArrayList<>();


    public CollectAdapter(int layoutResId, @Nullable List<CollectBean> data, Context context) {
        super(layoutResId, data);
        this.collectBeanList = data;
        this.context = context;
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, CollectBean collectBean) {
        ImageView item_collect_iv_fm = baseViewHolder.getView(R.id.item_collect_iv_fm);
        TextView item_collect_tv_title = baseViewHolder.getView(R.id.item_collect_tv_title);
        TextView item_collect_tv_date = baseViewHolder.getView(R.id.item_collect_tv_date);
        TextView item_collect_tv_time = baseViewHolder.getView(R.id.item_collect_tv_time);

        Glide.with(context)
                .load(collectBean.getFmurl())
                .into(item_collect_iv_fm);
        item_collect_tv_title.setText(collectBean.getTitle());
        item_collect_tv_date.setText(collectBean.getDate());
        item_collect_tv_time.setText(collectBean.getTime());
    }
}
