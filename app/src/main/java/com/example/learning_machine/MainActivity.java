package com.example.learning_machine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.learning_machine.Chat.VoiceActivity;
import com.example.learning_machine.Map.MapActivity;
import com.example.learning_machine.Xmly.SiteActivity;
import com.example.learning_machine.databinding.ActivityMainBinding;
import com.leaf.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding binding;

    private ImageView main_iv_map, main_iv_story, main_iv_cook, main_iv_xmly, main_iv_chat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        StatusBarUtil.setTransparentForWindow(this);
        StatusBarUtil.setDarkMode(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }


    private void initView(){
        main_iv_map = binding.mainIvMap;
        main_iv_map.setOnClickListener(this);

        main_iv_story = binding.mainIvStory;
        main_iv_story.setOnClickListener(this);

        main_iv_cook = binding.mainIvCook;
        main_iv_cook.setOnClickListener(this);

        main_iv_xmly = binding.mainIvXmly;
        main_iv_xmly.setOnClickListener(this);

        main_iv_chat = binding.mainIvChat;
        main_iv_chat.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_iv_map:
                startActivity(new Intent(this, MapActivity.class));
                break;
            case R.id.main_iv_story:
//                startActivity(new Intent(this, StoryActivity.class));
                break;
            case R.id.main_iv_cook:
//                startActivity(new Intent(this, CookActivity.class));
                break;
            case R.id.main_iv_xmly:
                startActivity(new Intent(this, SiteActivity.class));
                break;
            case R.id.main_iv_chat:
                startActivity(new Intent(this, VoiceActivity.class));
                break;
        }
    }
}