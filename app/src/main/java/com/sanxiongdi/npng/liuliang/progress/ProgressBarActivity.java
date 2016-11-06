package com.sanxiongdi.npng.liuliang.progress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sanxiongdi.npng.R;

/**
 * Created by liuliang on 2016/11/1.10:22
 * Email: liang.liu@zmind.cn
 * Describle:
 */

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnAdd;
    private  Button btnSub;

    private  WavaBezierProgress mWavaBezierProgress;
    private  int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_progress_layout);

        mWavaBezierProgress = (WavaBezierProgress)findViewById(R.id.wavaBezierProgress);

        btnAdd = (Button)findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);
        btnSub = (Button)findViewById(R.id.btn_sub);
        btnSub.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                value += 10;
                if (value>=100){
                    value = 100;
                }
                mWavaBezierProgress.setProgress(value);
                break;
            case  R.id.btn_sub:
                value -= 10;
                if(value <= 0){
                    value = 0;
                }
                mWavaBezierProgress.setProgress(value);
                break;
        }
    }
}
