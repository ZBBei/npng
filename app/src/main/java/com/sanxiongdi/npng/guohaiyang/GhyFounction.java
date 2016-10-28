package com.sanxiongdi.npng.guohaiyang;

import android.content.Context;
import android.util.Log;

import com.sanxiongdi.npng.consts.BaseFounction;
import com.sanxiongdi.npng.zhangbeibei.stickygridheaders.Founction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangbeibei on 16/10/28.
 * 功能描述：ghy新添加的功能从这里添加
 */

public class GhyFounction extends BaseFounction {

    @Override
    public void addValue(Context context) {
        {
            Founction ghyFunction = new Founction("郭海洋的第1个功能", null);
            ghyFunction.setHeader(true);
            ghyFunction.setHeaderTitle("郭海洋");
            founctions.add(ghyFunction);
            for (int i = 0; i < 4; i++) {
                Founction function = new Founction("郭海洋的第" + (i + 2) + "个功能", null);
                founctions.add(function);
            }
        }
    }
}
