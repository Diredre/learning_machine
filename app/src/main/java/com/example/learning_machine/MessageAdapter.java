package com.example.learning_machine;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import com.example.learning_machine.R;

public class MessageAdapter extends BaseQuickAdapter<MessageBean, BaseViewHolder> {

    private Context context;
    private List<MessageBean> messageBeanList = new ArrayList<>();


    public MessageAdapter(int layoutResId, @Nullable List<MessageBean> data, Context context) {
        super(layoutResId, data);
        this.messageBeanList = data;
        this.context = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, MessageBean messageBean) {
        LinearLayout y_layout = baseViewHolder.findView(R.id.it_mes_y_layout);
        LinearLayout m_layout = baseViewHolder.findView(R.id.it_mes_m_layout);;
        TextView y_tv = baseViewHolder.findView(R.id.it_tv_y);
        TextView m_tv = baseViewHolder.findView(R.id.it_tv_m);

        if(messageBean.getType() == MessageBean.TYPE_RECEIVED){
            //如果是收到消息，显示左边y_layout
            y_layout.setVisibility(View.VISIBLE);
            m_layout.setVisibility(View.GONE);
            y_tv.setText(messageBean.getContent());
        }else if(messageBean.getType() == MessageBean.TYPE_SENT){
            //如果是发送消息，显示右边m_layout
            m_layout.setVisibility(View.VISIBLE);
            y_layout.setVisibility(View.GONE);
            m_tv.setText(messageBean.getContent());
        }
    }
}
