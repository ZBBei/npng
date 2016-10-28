package com.sanxiongdi.npng.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhangbeibei on 16/10/28.
 * 功能描述：
 */

public class ToastUtil {
    /**
     * 防止toast排队显示
     */

    private static Toast toast;

    public static void makeText(Context context, String msg, int duration) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, duration);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
//
//    /**
//     * 判断字符串是否为空
//     *
//     * @param msg
//     * @return true 空字符串
//     */
//    public static boolean isEmptyString(String msg) {
//        return msg == null || msg.equals("");
//    }
//
//
//    /**
//     * 避免按钮被重复点击
//     */
//    private static long lastClickTime;
//
//    public static boolean isFastDoubleClick() {
//        long time = System.currentTimeMillis();
//        long timeD = time - lastClickTime;
//        if (0 < timeD && timeD < 500) {
//            return true;
//        }
//        lastClickTime = time;
//        return false;
//    }
}
