package com.example.learning_machine.Retrofit.Callback;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitStringCallback implements Callback<String> {

    private StringCallback callback;

    public RetrofitStringCallback(StringCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            callback.onSuccess(response.body());
        } else {
            try {
                Throwable throwable = new Throwable(response.errorBody().string());
                callback.onFailure(throwable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        callback.onFailure(t);
    }
}