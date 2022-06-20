package com.example.learning_machine.Retrofit.Callback;

/**
 * description: 请求回调
 */
public interface ResponseCallback<T> {

    void onSuccess(T t);

    void onFailure(Throwable t);
}