package com.sanxiongdi.npng.zhangbeibei.stickygridheaders;

import android.content.Intent;

/**
 * Created by zhangbeibei on 16/10/28.
 * 功能描述：用于描述新增功能
 */

public class Founction {
    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    private boolean isHeader = false;
    private String headerTitle;

    public boolean isHeader() {
        return isHeader;
    }

    private Intent intent;

    public void setHeader(boolean header) {
        isHeader = header;
    }

    private String func_desc;

    public Founction(String func_desc, Intent intent) {
        this.func_desc = func_desc;
        this.intent = intent;
    }

    public String getFunc_desc() {
        return func_desc;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public void setFunc_desc(String func_desc) {
        this.func_desc = func_desc;
    }
}
