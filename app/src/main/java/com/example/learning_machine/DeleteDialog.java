package com.example.learning_machine;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learning_machine.R;

public class DeleteDialog {

    public Dialog mDialog;
    public TextView dialog_del_tv_yes, dialog_del_tv_no;
    public ImageView dialog_del_iv_exit;
    public View mView;
    private Context context;

    public DeleteDialog(Context context, CollectAdapter collectAdapter, int pos) {
        this.context = context;

        LayoutInflater inflater = LayoutInflater.from(context);
        mView = inflater.inflate(R.layout.dialog_delete, null);
        mDialog = new Dialog(context, R.style.dialog_style);
        mDialog.setContentView(mView);

        Window dialogWindow = mDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER);
        dialogWindow.setWindowAnimations(R.style.dialogWindowAnim); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
//        lp.width = context.getResources().getDisplayMetrics().widthPixels; // 宽度
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT; // 高度
        dialogWindow.setAttributes(lp);

        mDialog.setCanceledOnTouchOutside(true);
        dialog_del_iv_exit = mView.findViewById(R.id.dialog_del_iv_exit);
        dialog_del_tv_yes = mView.findViewById(R.id.dialog_del_tv_yes);
        dialog_del_tv_no = mView.findViewById(R.id.dialog_del_tv_no);

        dialog_del_iv_exit.setOnClickListener(v->{
            dismiss();
        });
        dialog_del_tv_yes.setOnClickListener(v->{
            collectAdapter.removeData(pos);
            Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();
            dismiss();
        });
        dialog_del_tv_no.setOnClickListener(v->{
            dismiss();
        });
    }

    public void show() {
        mDialog.show();
    }

    public void dismiss() {
        mDialog.dismiss();
    }
}
