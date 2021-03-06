package com.example.learning_machine.Xmly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.learning_machine.MainActivity;
import com.example.learning_machine.R;
import com.example.learning_machine.databinding.ActivitySiteBinding;
import com.leaf.library.StatusBarUtil;

public class SiteActivity extends AppCompatActivity {

    private ActivitySiteBinding binding;

    private WebView site_wb;
    private ImageView site_iv_back, site_iv_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        StatusBarUtil.setTransparentForWindow(this);
        StatusBarUtil.setDarkMode(this);

        binding = ActivitySiteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initView();
    }


    private void initView(){
        site_wb = binding.siteWb;

        WebSettings ws = site_wb.getSettings();
        ws.setPluginState(WebSettings.PluginState.ON);
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setSupportMultipleWindows(true);
        ws.setAppCacheEnabled(true);

        if (Build.VERSION.SDK_INT >= 21) {
            // 5.0及以上系统，指定可以HTTPS跨域访问HTTP
            ws.setMixedContentMode(android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        site_wb.loadUrl("https://www.ximalaya.com/");

        site_iv_back = binding.siteIvBack;
        site_iv_back.setOnClickListener(v->{
            if (site_wb.canGoBack()) {
                site_wb.goBack();   //返回上个页面
                return;
            } else {
                finish();
            }
        });

        site_iv_home = binding.siteIvHome;
        site_iv_home.setOnClickListener(v->{
            finish();
//            startActivity(new Intent(this, MainActivity.class));
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        site_wb.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        site_wb.onResume();
    }

}