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
import com.leaf.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class VoiceActivity extends AppCompatActivity {

    private static final String TAG = "VoiceActivity";
    private ActivityVoiceBinding binding;

//    private RecyclerView voice_rv;
    private EditText voice_et_input;
    private Button voice_btn_send;
    private ImageView voice_iv_back, voice_iv_home;

//    private MessageAdapter messageAdapter;
//    private List<MessageBean> messageBeanList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        StatusBarUtil.setTransparentForWindow(this);
        StatusBarUtil.setDarkMode(this);

        binding = ActivityVoiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        initMes();
        initView();
    }


    private void initView(){
//        voice_rv = binding.voiceRv;
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        voice_rv.setLayoutManager(layoutManager);
//        messageAdapter = new MessageAdapter(R.layout.item_message, messageBeanList, this);
//        voice_rv.setAdapter(messageAdapter);
//
//        voice_et_input = binding.voiceEtInput;
//        voice_btn_send = binding.voiceBtnSend;
//        voice_btn_send.setOnClickListener(v->{
//            String content = voice_et_input.getText().toString();
//            if(!"".equals(content)) {
//                MessageBean message = new MessageBean(content, MessageBean.TYPE_SENT);
//                messageBeanList.add(message);
//                voice_et_input.setText("");
//                MessageBean message2 = new MessageBean("????????????????????????", MessageBean.TYPE_RECEIVED);
//                messageBeanList.add(message2);
//                messageAdapter.notifyItemInserted(messageBeanList.size() - 1);      //??????????????????????????????
//                voice_rv.scrollToPosition(messageBeanList.size() - 1);                      //?????????????????????
//            }
//        });

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


//    private void initMes(){
//        MessageBean mes1 = new MessageBean("????????????????????????", MessageBean.TYPE_RECEIVED);
//        messageBeanList.add(mes1);
//        MessageBean mes2 = new MessageBean("?????????", MessageBean.TYPE_SENT);
//        messageBeanList.add(mes2);
//        MessageBean mes3 = new MessageBean("???????????????????????????????????????", MessageBean.TYPE_RECEIVED);
//        messageBeanList.add(mes3);
//    }
}