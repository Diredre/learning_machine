package com.example.learning_machine.Xmly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.learning_machine.R;
import com.example.learning_machine.databinding.ActivitySiteBinding;

public class SiteActivity extends AppCompatActivity {

    private ActivitySiteBinding binding;

    private WebView site_wb;


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