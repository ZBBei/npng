package com.sanxiongdi.npng.guohaiyang.express.bean;

import java.util.List;

/**
 * Created by guohaiyang on 2016/10/29.
 */

public class ExpressNumberBean {

    /**
     * EBusinessID : 1268037
     * Success : true
     * LogisticCode : 1000745320654
     * Shippers : [{"ShipperCode":"YD","ShipperName":"韵达快递"},{"ShipperCode":"EMS","ShipperName":"EMS"},{"ShipperCode":"HTKY","ShipperName":"百世汇通"}]
     */

    private String EBusinessID;
    private boolean Success;
    private String LogisticCode;
    /**
     * ShipperCode : YD
     * ShipperName : 韵达快递
     */

    private List<ShippersBean> Shippers;

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String LogisticCode) {
        this.LogisticCode = LogisticCode;
    }

    public List<ShippersBean> getShippers() {
        return Shippers;
    }

    public void setShippers(List<ShippersBean> Shippers) {
        this.Shippers = Shippers;
    }

    public static class ShippersBean {
        private String ShipperCode;
        private String ShipperName;

        public String getShipperCode() {
            return ShipperCode;
        }

        public void setShipperCode(String ShipperCode) {
            this.ShipperCode = ShipperCode;
        }

        public String getShipperName() {
            return ShipperName;
        }

        public void setShipperName(String ShipperName) {
            this.ShipperName = ShipperName;
        }
    }

    @Override
    public String toString() {
        return "ExpressNumberBean{" +
                "EBusinessID='" + EBusinessID + '\'' +
                ", Success=" + Success +
                ", LogisticCode='" + LogisticCode + '\'' +
                ", Shippers=" + Shippers +
                '}';
    }
}
