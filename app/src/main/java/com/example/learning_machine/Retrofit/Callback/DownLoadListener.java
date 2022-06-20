package com.example.learning_machine.Retrofit.Callback;

/**
 * description: 下载回调
 */
public interface DownLoadListener {

    void onStart();

    void progress(int progress, float currentSize, float totalSize);

    void onFinish(String path);

    void onFailure(String msg);

    void onCancel(String tag);

}