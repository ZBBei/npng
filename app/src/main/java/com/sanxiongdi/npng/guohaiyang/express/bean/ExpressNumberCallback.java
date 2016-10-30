package com.sanxiongdi.npng.guohaiyang.express.bean;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

/**
 * Created by guohaiyang on 2016/10/29.
 */

public abstract class ExpressNumberCallback extends Callback<ExpressNumberBean> {
    @Override
    public ExpressNumberBean parseNetworkResponse(Response response) throws IOException {
        String string = response.body().string();
        ExpressNumberBean expressNumberBean = new Gson().fromJson(string, ExpressNumberBean.class);
        return expressNumberBean;
    }


}
