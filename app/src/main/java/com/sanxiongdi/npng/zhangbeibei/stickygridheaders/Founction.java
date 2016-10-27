package com.sanxiongdi.npng.zhangbeibei.stickygridheaders;

/**
 * Created by zhangbeibei on 16/10/28.
 * 功能描述：用于描述新增功能
 */

public class Founction {
    private boolean isHeader = false;
    private String headerTitle;
    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    private String func_desc;

    public Founction(String func_desc) {
        this.func_desc = func_desc;
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
