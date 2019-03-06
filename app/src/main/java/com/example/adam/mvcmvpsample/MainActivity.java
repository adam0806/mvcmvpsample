package com.example.adam.mvcmvpsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adam.mvcmvpsample.MVC.ControllerActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * Created by Chih-Yuan, Hsi on 2019/3/2
 * Description
 * 簡單範例輸入姓,名, 送出,顯示
 * 透過MVC,MVP
 */
public class MainActivity extends AppCompatActivity {
    @OnClick(R.id.buttonMVC) void submitMVC(){
        startActivity(new Intent(this, ControllerActivity.class));
    };
    @OnClick(R.id.buttonMVP) void submitMVP(){
        startActivity(new Intent(this, com.example.adam.mvcmvpsample.MVP.ViewActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
