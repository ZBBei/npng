package com.sanxiongdi.npng.liuliang;

import android.content.Context;
import android.content.Intent;

import com.sanxiongdi.npng.consts.BaseFounction;
import com.sanxiongdi.npng.zhangbeibei.stickygridheaders.Founction;

/**
 * Created by zhangbeibei on 16/10/28.
 * 功能描述：ll新添加的功能从这里添加
 */

public class LlFounction extends BaseFounction {

    @Override
    public void addValue(Context context) {
        Founction llFunction = new Founction("ProgressBar", new Intent(context,ProgressBarActivity.class));
        llFunction.setHeader(true);
        llFunction.setHeaderTitle("刘亮");
        founctions.add(llFunction);
        for (int i = 0; i < 4; i++) {
            Founction function = new Founction("刘亮的第" + (i + 2) + "个功能", null);
            founctions.add(function);
        }
    }
}
