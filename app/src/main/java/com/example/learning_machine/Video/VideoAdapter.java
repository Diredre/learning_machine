package com.example.learning_machine.Video;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.learning_machine.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diredre
 * @brief description
 * @date 2022-05-22
 */
public class VideoAdapter extends BaseQuickAdapter<VideoBean, BaseViewHolder> {

    private static final String TAG = "VideoAdapter";
    private Context context;
    private List<VideoBean> videoBeanList = new ArrayList<>();


    public VideoAdapter(int layoutResId, @Nullable List<VideoBean> data, Context context) {
        super(layoutResId, data);
        this.videoBeanList = data;
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, VideoBean videoBean) {
        RelativeLayout item_video_rl = baseViewHolder.getView(R.id.item_video_rl);
        ImageView item_video_iv_fm = baseViewHolder.getView(R.id.item_video_iv_fm);
        TextView item_video_tv_time = baseViewHolder.getView(R.id.item_video_tv_time);
        TextView item_video_tv_title = baseViewHolder.getView(R.id.item_video_tv_title);
        ImageView item_video_iv_usericon = baseViewHolder.getView(R.id.item_video_iv_usericon);
        TextView item_video_tv_username = baseViewHolder.getView(R.id.item_video_tv_username);
        TextView item_video_tv_usertime = baseViewHolder.getView(R.id.item_video_tv_usertime);
        RelativeLayout item_video_all = baseViewHolder.getView(R.id.item_video_all);

        Glide.with(context)
                .load(videoBean.getFmurl())
                .into(item_video_iv_fm);
        item_video_tv_time.setText(videoBean.getTime());
        item_video_tv_title.setText(videoBean.getTitle());
        Glide.with(context)
                .load(videoBean.getIconurl())
                .into(item_video_iv_usericon);
//        item_video_iv_usericon.setImageResource(R.mipmap.peoicon);
        item_video_tv_username.setText(videoBean.getUsername());
        item_video_tv_usertime.setText(videoBean.getUsertime());

        item_video_rl.setOnClickListener(v->{
            Intent intent = new Intent(context, FullVideoActivity.class);
            intent.putExtra("VIDEOURL", "xxx");
            context.startActivity(intent);
        });

        item_video_all.setOnClickListener(v->{
            context.startActivity(new Intent(context, FullVideoActivity.class));
        });
    }
}
