package com.example.learning_machine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learning_machine.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener{

    private ActivityMainBinding binding;

    private RelativeLayout video_rl_calligra, video_rl_draw, video_rl_tech, video_rl_code,
            video_rl_music, video_rl_sport, video_rl_book;
    private ImageView video_iv_calligra, video_iv_draw, video_iv_tech, video_iv_code,
            video_iv_music, video_iv_sport, video_iv_book;
    private TextView video_tv_calligra, video_tv_draw, video_tv_tech, video_tv_code,
            video_tv_music, video_tv_sport, video_tv_book;
    private RecyclerView video_rv;

    private List<VideoBean> videoBeanList = new ArrayList<>();
    private VideoAdapter videoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//设置状态栏黑色字
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }


    private void initView(){
        video_rl_calligra = binding.videoRlCalligra;
        video_rl_calligra.setOnClickListener(this);
        video_rl_calligra.setOnTouchListener(this);
        video_iv_calligra = binding.videoIvCalligra;
        video_tv_calligra = binding.videoTvCalligra;

        video_rl_draw = binding.videoRlDraw;
        video_rl_draw.setOnClickListener(this);
        video_rl_draw.setOnTouchListener(this);
        video_iv_draw = binding.videoIvDraw;
        video_tv_draw = binding.videoTvDraw;

        video_rl_tech = binding.videoRlTech;
        video_rl_tech.setOnClickListener(this);
        video_rl_tech.setOnTouchListener(this);
        video_iv_tech = binding.videoIvTech;
        video_tv_tech = binding.videoTvTech;

        video_rl_code = binding.videoRlCode;
        video_rl_code.setOnClickListener(this);
        video_rl_code.setOnTouchListener(this);
        video_iv_code = binding.videoIvCode;
        video_tv_code = binding.videoTvCode;

        video_rl_music = binding.videoRlMusic;
        video_rl_music.setOnClickListener(this);
        video_rl_music.setOnTouchListener(this);
        video_iv_music = binding.videoIvMusic;
        video_tv_music = binding.videoTvMusic;

        video_rl_sport = binding.videoRlSport;
        video_rl_sport.setOnClickListener(this);
        video_rl_sport.setOnTouchListener(this);
        video_iv_sport = binding.videoIvSport;
        video_tv_sport = binding.videoTvSport;

        video_rl_book = binding.videoRlBook;
        video_rl_book.setOnClickListener(this);
        video_rl_book.setOnTouchListener(this);
        video_iv_book = binding.videoIvBook;
        video_tv_book = binding.videoTvBook;

        initData();

        video_rv = binding.videoRv;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        video_rv.setLayoutManager(gridLayoutManager);
        videoAdapter = new VideoAdapter(R.layout.item_video, videoBeanList, this);
        video_rv.setAdapter(videoAdapter);
        video_rv.setItemAnimator(new DefaultItemAnimator());

        // 美术被点击（初始）
        video_rl_draw.setPressed(true);
        video_tv_draw.setTextColor(Color.parseColor("#FFFFFF"));
    }


    private void initData(){
        for(int i = 0; i < 10; i++) {
            videoBeanList.add(new VideoBean("https://tse1-mm.cn.bing.net/th/id/OIP-C.IigYCLmDnIgmZDeuim_86QHaFL?pid=ImgDet&rs=1",
                    "合集32集《论语》儿童国学启蒙动画片解读大语文学习适合小学生学习论语",
                    "8:37", "https://s1.ax1x.com/2022/05/29/XMH6US.png",
                    "小南瓜" + i, "2022-03-"+i));
        }
    }


    /**
     * 顶部均未点击时
     */
    private void clearAll(){
        video_tv_calligra.setTextColor(Color.parseColor("#74D4E1"));
        video_iv_calligra.setImageResource(R.mipmap.calligra);

        video_tv_draw.setTextColor(Color.parseColor("#74D4E1"));
        video_iv_draw.setImageResource(R.mipmap.draw);

        video_tv_tech.setTextColor(Color.parseColor("#74D4E1"));
        video_iv_tech.setImageResource(R.mipmap.tech);

        video_tv_code.setTextColor(Color.parseColor("#74D4E1"));
        video_iv_code.setImageResource(R.mipmap.code);

        video_tv_tech.setTextColor(Color.parseColor("#74D4E1"));
        video_iv_tech.setImageResource(R.mipmap.tech);

        video_tv_music.setTextColor(Color.parseColor("#74D4E1"));
        video_iv_music.setImageResource(R.mipmap.music);

        video_tv_sport.setTextColor(Color.parseColor("#74D4E1"));
        video_iv_sport.setImageResource(R.mipmap.sport);

        video_tv_book.setTextColor(Color.parseColor("#74D4E1"));
        video_iv_book.setImageResource(R.mipmap.book);
    }


    // todo: 需要顶部的一堆切图
    @Override
    public void onClick(View v) {
        clearAll();
        switch(v.getId()){
            case R.id.video_rl_calligra:
                video_tv_calligra.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_calligra.setImageResource(R.mipmap.calligra);
                break;
            case R.id.video_rl_draw:
                video_tv_draw.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_draw.setImageResource(R.mipmap.draw);
                break;
            case R.id.video_rl_tech:
                video_tv_tech.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_tech.setImageResource(R.mipmap.tech);
                break;
            case R.id.video_rl_code:
                video_tv_code.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_code.setImageResource(R.mipmap.code);
                break;
            case R.id.video_rl_music:
                video_tv_music.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_music.setImageResource(R.mipmap.music);
                break;
            case R.id.video_rl_sport:
                video_tv_sport.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_sport.setImageResource(R.mipmap.sport);
                break;
            case R.id.video_rl_book:
                video_tv_book.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_book.setImageResource(R.mipmap.book);
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        clearAll();
        switch(v.getId()){
            case R.id.video_rl_calligra:
                video_tv_calligra.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_calligra.setImageResource(R.mipmap.calligra);
                break;
            case R.id.video_rl_draw:
                video_tv_draw.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_draw.setImageResource(R.mipmap.draw);
                break;
            case R.id.video_rl_tech:
                video_tv_tech.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_tech.setImageResource(R.mipmap.tech);
                break;
            case R.id.video_rl_code:
                video_tv_code.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_code.setImageResource(R.mipmap.code);
                break;
            case R.id.video_rl_music:
                video_tv_music.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_music.setImageResource(R.mipmap.music);
                break;
            case R.id.video_rl_sport:
                video_tv_sport.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_sport.setImageResource(R.mipmap.sport);
                break;
            case R.id.video_rl_book:
                video_tv_book.setTextColor(Color.parseColor("#FFFFFF"));
//                video_iv_book.setImageResource(R.mipmap.book);
                break;
        }

        return false;
    }
}