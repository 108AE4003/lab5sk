package com.example.lab5_sk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn =findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("请编辑功能");
                dialog.setMessage("请根据下方按钮选择要显示的物件");
                dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "dialog关闭", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNeutralButton("自定义Toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast();
                    }
                });
                dialog.setPositiveButton("显示list", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showListDialog();
                    }
                });
                dialog.show();
            }
        });
    }
    private  void showToast(){
        Toast toast=new Toast(MainActivity.this);
        toast.setGravity(Gravity.TOP,0,50);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater= getLayoutInflater();
        View layout=inflater.inflate(R.layout.custom_toast
                ,(ViewGroup)findViewById(R.id.custom_toast_root));
        toast.setView(layout);
        toast.show();
    }
    private  void showListDialog(){
        final String[] list ={"message1","message2","message3","message4","message5"};
        AlertDialog.Builder dialog_List=new AlertDialog.Builder(MainActivity.this);
        dialog_List.setTitle("使用LIST呈现");
        dialog_List.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this
                ,"你选得是"+list[i],Toast.LENGTH_SHORT).show();
            }
        });
        dialog_List.show();
    }
}
