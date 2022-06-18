package com.example.learning_machine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.learning_machine.Chat.VoiceActivity;
import com.example.learning_machine.Map.MapActivity;
import com.example.learning_machine.Xmly.SiteActivity;
import com.example.learning_machine.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding binding;

    private RelativeLayout main_rl_map, main_rl_story, main_rl_cook, main_rl_xmly, main_rl_chat;


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
        main_rl_map = binding.mainRlMap;
        main_rl_map.setOnClickListener(this);

        main_rl_story = binding.mainRlStory;
        main_rl_story.setOnClickListener(this);

        main_rl_cook = binding.mainRlCook;
        main_rl_cook.setOnClickListener(this);

        main_rl_xmly = binding.mainRlXmly;
        main_rl_xmly.setOnClickListener(this);

        main_rl_chat = binding.mainRlChat;
        main_rl_chat.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_rl_map:
                startActivity(new Intent(this, MapActivity.class));
                break;
            case R.id.main_rl_story:
//                startActivity(new Intent(this, StoryActivity.class));
                break;
            case R.id.main_rl_cook:
//                startActivity(new Intent(this, CookActivity.class));
                break;
            case R.id.main_rl_xmly:
                startActivity(new Intent(this, SiteActivity.class));
                break;
            case R.id.main_rl_chat:
                startActivity(new Intent(this, VoiceActivity.class));
                break;
        }
    }
}