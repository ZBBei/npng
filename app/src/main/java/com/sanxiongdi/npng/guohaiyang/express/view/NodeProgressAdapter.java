package com.sanxiongdi.npng.guohaiyang.express.view;

import com.sanxiongdi.npng.guohaiyang.express.bean.TraceBean;

import java.util.ArrayList;
import java.util.List;


public class NodeProgressAdapter {
    private List<TraceBean> traceBeanList = new ArrayList<>();

    public void setTraceBeanList(List<TraceBean> traceBeanList) {
        this.traceBeanList = traceBeanList;
    }

    /**
     * 返回集合大小
     *
     * @return
     */
    int getCount() {
        return traceBeanList.size();
    }

    /**
     * 适配数据的集合
     *
     * @return
     */
    List<TraceBean> getData() {
        return traceBeanList;
    }

}
