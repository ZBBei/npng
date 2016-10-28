package com.sanxiongdi.npng.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangbeibei on 16/10/28.
 * 功能描述：获取设备相关信息
 */

public class DeviceUtil {
    private static final String TAG = DeviceUtil.class.getSimpleName();

    /**
     * TODO<获取本地ip地址>
     *
     * @return String
     */
    public static String getLocAddress() {
        String ipaddress = "";

        try {
            Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces();
            // 遍历所用的网络接口
            while (en.hasMoreElements()) {
                NetworkInterface networks = en.nextElement();
                // 得到每一个网络接口绑定的所有ip
                Enumeration<InetAddress> address = networks.getInetAddresses();
                // 遍历每一个接口绑定的所有ip
                while (address.hasMoreElements()) {
                    InetAddress inetAddress = address.nextElement();
                    if (!inetAddress.isLoopbackAddress()
                            && inetAddress instanceof Inet4Address) {
                        ipaddress = inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            Log.e(TAG, "getLocAddress error:" + e.toString());
        }

        Log.i(TAG, "本机IP:" + ipaddress);
        return ipaddress;
    }

    /**
     * TODO<获取当前App进程的名称>
     *
     * @return String
     */
    public static String getAppProcessName(Context context, int processId) {
        String processName = null;

        ActivityManager am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> l = am.getRunningAppProcesses();// 获取所有运行App的进程集合
        Iterator<ActivityManager.RunningAppProcessInfo> i = l.iterator();

        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i
                    .next());
            try {
                if (info.pid == processId) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return processName;
    }

    /**
     * TODO<获取应用版本名--versionName>
     *
     * @return String
     */
    public static String getVersionName(Context context) {
        String versionName = "";
        PackageManager packageManager = context.getPackageManager();// 获取PackageManager实例

        try {
            PackageInfo packInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);// 获取程序包包信息
            versionName = packInfo.versionName;// 获取版本名称--versionName
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return versionName;
    }

    /**
     * TODO<获取应用版本号--versionCode>
     *
     * @return String
     */
    public static String getVersionCode(Context context) {
        String versionCode = "";
        PackageManager packageManager = context.getPackageManager();// 获取PackageManager实例

        try {
            PackageInfo packInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);// 获取程序包包信息
            versionCode = String.valueOf(packInfo.versionCode);// 获取版本号--versionCode
            return versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return versionCode;
    }

    /**
     * TODO<获取设备的唯一标识ID>
     *
     * @return String
     */
    public static String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();

        if (TextUtils.isEmpty(deviceId)) {
            return "";
        } else {
            return deviceId;
        }
    }

    /**
     * TODO<获取本机设备名称>
     *
     * @return String
     */
    public static String getLocDeviceName() {
        return android.os.Build.MODEL;
    }

    /**
     * TODO<获取手机品牌>
     *
     * @return String
     */
    public static String getPhoneBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * TODO<获取手机型号>
     *
     * @return String
     */
    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    /**
     * TODO< 获取手机Android API等级>
     *
     * @return int
     */
    public static int getBuildLevel() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * TODO<获取手机Android版本>
     *
     * @return String
     */
    public static String getBuildVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * TODO<获取App进程的ID>
     *
     * @return int
     */
    public static int getAppProcessId() {
        return android.os.Process.myPid();
    }

    /**
     * TODO<将dp转为px>
     *
     * @return int
     */
    public static int dpTopx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * TODO<将px转为dp>
     *
     * @return int
     */
    public static int pxTodp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * TODO<获取设备宽度(px)>
     *
     * @return int
     */
    public static int getDeviceWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * TODO<获取设备高度(px)>
     *
     * @return int
     */
    public static int getDeviceHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * TODO<判断SD卡是否可用>
     *
     * @return boolean
     */
    public static boolean isSDCardAvailable() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

}
