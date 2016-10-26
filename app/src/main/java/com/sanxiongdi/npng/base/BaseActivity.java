package com.sanxiongdi.npng.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by liuliang on 2016/10/26.14:46
 * Email: liang.liu@zmind.cn
 * Describle: 在这个类中做一些统一操作，先写这个，把这个改好再统一做吧，欢迎修改
 */

public abstract  class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    /*
    * 初始化绑定控件*/
    public abstract void initView();


    /**
     * 显示加载进度条
     * isCancel 表示点击外面消失
     */

    public  void showLoadingDialog(boolean isCancel){

    }

    /**
     *取消进度条
     */
    public  void dismissLoadingDialog(){

    }
}
