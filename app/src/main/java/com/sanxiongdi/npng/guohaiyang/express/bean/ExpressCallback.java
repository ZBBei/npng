package com.sanxiongdi.npng.guohaiyang.express.bean;

import com.google.gson.Gson;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;


public abstract class ExpressCallback extends Callback<ExpressBean> {
    //非UI线程，支持任何耗时操作
    @Override
    public ExpressBean parseNetworkResponse(Response response) throws IOException {
        String string = response.body().string();
        ExpressBean expressBean = new Gson().fromJson(string, ExpressBean.class);
        return expressBean;
    }
}