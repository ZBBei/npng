package com.sanxiongdi.npng.consts;

import android.content.Context;
import android.util.Log;

import com.sanxiongdi.npng.guohaiyang.GhyFounction;
import com.sanxiongdi.npng.liuliang.LlFounction;
import com.sanxiongdi.npng.zhangbeibei.ZbbFounction;
import com.sanxiongdi.npng.zhangbeibei.stickygridheaders.Founction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangbeibei on 16/10/28.
 * 功能描述：
 */

public abstract class BaseFounction {
    public static List<Founction> founctions = new ArrayList<Founction>();

//    static {
//        founctions.addAll(GhyFounction.ghyfounctions);
//        founctions.addAll(ZbbFounction.Zbbfounctions);
//        founctions.addAll(LlFounction.Llfounctions);
//    }
    public abstract void addValue(Context context);
    public static List<Founction> getFounctions() {
        return founctions;
    }
}
