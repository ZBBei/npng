package com.sanxiongdi.npng.zhangbeibei;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sanxiongdi.npng.consts.BaseFounction;
import com.sanxiongdi.npng.zhangbeibei.bubbletextview.BubbleTextViewActivity;
import com.sanxiongdi.npng.zhangbeibei.stickygridheaders.Founction;
import com.sanxiongdi.npng.zhangbeibei.togglebutton.ToggleButtonActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangbeibei on 16/10/28.
 * 功能描述：
 */

public class ZbbFounction extends BaseFounction {
    @Override
    public void addValue(Context context) {

        Intent intent = new Intent();
        intent.setClass(context, ToggleButtonActivity.class);
        Founction zbbFunction = new Founction("ToogleButton", intent);
        zbbFunction.setHeader(true);
        zbbFunction.setHeaderTitle("张贝贝");
        founctions.add(zbbFunction);

        Intent intent_bubbleTextView = new Intent();
        intent_bubbleTextView.setClass(context, BubbleTextViewActivity.class);
        Founction func_bubbleTextView = new Founction("BubbleTextView", intent_bubbleTextView);
        founctions.add(func_bubbleTextView);


        for (int i = 0; i < 4; i++) {
            Founction function = new Founction("张贝贝的第" + (i + 2) + "个功能", null);
            founctions.add(function);
        }

    }
}
