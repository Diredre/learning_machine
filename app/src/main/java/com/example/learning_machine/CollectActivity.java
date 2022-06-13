package com.example.learning_machine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.learning_machine.databinding.ActivityCollectBinding;

import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityCollectBinding binding;

    private TextView col_tv_collect, col_tv_history;
    private RelativeLayout col_rl_collect, col_rl_history;
    private RecyclerView col_rv;
    private CollectAdapter collectAdapter;
    private List<CollectBean> collectBeanList = new ArrayList<>();


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

        binding = ActivityCollectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }


    private void initView(){
        col_tv_collect = binding.colTvCollect;
        col_tv_collect.setOnClickListener(this);

        col_tv_history = binding.colTvHistory;
        col_tv_history.setOnClickListener(this);

        col_rl_collect = binding.colRlCollect;
        col_rl_collect.setOnClickListener(this);

        col_rl_history = binding.colRlHistory;
        col_rl_history.setOnClickListener(this);

        initData();

        col_rv = binding.colRv;
        col_rv.setLayoutManager(new LinearLayoutManager(this));
        collectAdapter = new CollectAdapter(R.layout.item_collect, collectBeanList, this);
        col_rv.setAdapter(collectAdapter);
        col_rv.setItemAnimator(new DefaultItemAnimator());

        col_tv_collect.setSelected(true);
    }


    private void initData(){
        for(int i = 0; i < 10; i++) {
            collectBeanList.add(new CollectBean("https://tse1-mm.cn.bing.net/th/id/OIP-C.IigYCLmDnIgmZDeuim_86QHaFL?pid=ImgDet&rs=1",
                    "国家中小学网络平台", "2022年"+i+"月22日", "19:39"));
        }
    }


    private void clearAll(){
        col_tv_collect.setTextColor(Color.parseColor("#74D4E1"));
        col_tv_history.setTextColor(Color.parseColor("#74D4E1"));
        col_tv_collect.setBackgroundResource(0);
        col_tv_history.setBackgroundResource(0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.col_rl_collect:
            case R.id.col_tv_collect:
                clearAll();
                col_tv_collect.setTextColor(Color.parseColor("#FFFFFF"));
                col_tv_collect.setBackgroundColor(Color.parseColor("#74D4E1"));
                break;
            case R.id.col_rl_history:
            case R.id.col_tv_history:
                clearAll();
                col_tv_history.setTextColor(Color.parseColor("#FFFFFF"));
                col_tv_history.setBackgroundColor(Color.parseColor("#74D4E1"));
                break;
        }
    }

}