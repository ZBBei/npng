package com.sanxiongdi.npng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sanxiongdi.npng.guohaiyang.GhyMainActivity;
import com.sanxiongdi.npng.liuliang.LlMainAcitivity;
import com.sanxiongdi.npng.zhangbeibei.ZbbMainActivity;

/**
 * zbb
 * 2016.10.26
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("zbb","zbb");
    }

    public void zhangbeibei(){
       Intent intent = new Intent(this, ZbbMainActivity.class);
        startActivity(intent);

    }
    public void liuliang(){
        Intent intent = new Intent(this, LlMainAcitivity.class);
        startActivity(intent);
    }
    public void guohaiyang(){
        Intent intent = new Intent(this, GhyMainActivity.class);
        startActivity(intent);
    }
}
