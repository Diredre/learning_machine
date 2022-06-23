package com.example.learning_machine.Chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.learning_machine.Chat.MessageAdapter;
import com.example.learning_machine.Chat.MessageBean;
import com.example.learning_machine.MainActivity;
import com.example.learning_machine.R;
import com.example.learning_machine.databinding.ActivityVoiceBinding;

import java.util.ArrayList;
import java.util.List;

public class VoiceActivity extends AppCompatActivity {

    private static final String TAG = "VoiceActivity";
    private ActivityVoiceBinding binding;

    private RecyclerView voice_rv;
    private EditText voice_et_input;
    private Button voice_btn_send;
    private ImageView voice_iv_back, voice_iv_home;

    private MessageAdapter messageAdapter;
    private List<MessageBean> messageBeanList = new ArrayList<>();


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

        binding = ActivityVoiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initMes();
        initView();
    }


    private void initView(){
        voice_rv = binding.voiceRv;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        voice_rv.setLayoutManager(layoutManager);
        messageAdapter = new MessageAdapter(R.layout.item_message, messageBeanList, this);
        voice_rv.setAdapter(messageAdapter);

        voice_et_input = binding.voiceEtInput;
        voice_btn_send = binding.voiceBtnSend;
        voice_btn_send.setOnClickListener(v->{
            String content = voice_et_input.getText().toString();
            if(!"".equals(content)) {
                MessageBean message = new MessageBean(content, MessageBean.TYPE_SENT);
                messageBeanList.add(message);
                voice_et_input.setText("");
                MessageBean message2 = new MessageBean("这是一条自动回复", MessageBean.TYPE_RECEIVED);
                messageBeanList.add(message2);
                messageAdapter.notifyItemInserted(messageBeanList.size() - 1);      //通知列表有新数据插入
                voice_rv.scrollToPosition(messageBeanList.size() - 1);                      //定位在最后一行
            }
        });

        voice_iv_back = binding.voiceIvBack;
        voice_iv_back.setOnClickListener(v->{
            this.finish();
        });

        voice_iv_home = binding.voiceIvHome;
        voice_iv_home.setOnClickListener(v->{
            this.finish();
//            startActivity(new Intent(this, MainActivity.class));
        });
    }


    private void initMes(){
        MessageBean mes1 = new MessageBean("您好，我是小牛。", MessageBean.TYPE_RECEIVED);
        messageBeanList.add(mes1);
        MessageBean mes2 = new MessageBean("你好。", MessageBean.TYPE_SENT);
        messageBeanList.add(mes2);
        MessageBean mes3 = new MessageBean("您好，我能为您做点什么呢？", MessageBean.TYPE_RECEIVED);
        messageBeanList.add(mes3);
    }
}