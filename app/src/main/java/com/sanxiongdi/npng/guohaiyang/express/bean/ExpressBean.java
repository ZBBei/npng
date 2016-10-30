package com.sanxiongdi.npng.guohaiyang.express.bean;

import java.util.List;

public class ExpressBean {
	private String EBusinessID;// 用户id--注册的id
	private String ShipperCode;// 快递公司编码
	private boolean Success;// 成功与否
	private String LogisticCode; // 物流运单号
	private String State;// 物流状态：2-在途中,3-签收,4-问题件
	private String Reason;// 失败原因
	private List<TraceBean> Traces;

	public String getEBusinessID() {
		return EBusinessID;
	}

	public void setEBusinessID(String eBusinessID) {
		EBusinessID = eBusinessID;
	}

	public String getShipperCode() {
		return ShipperCode;
	}

	public void setShipperCode(String shipperCode) {
		ShipperCode = shipperCode;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public String getLogisticCode() {
		return LogisticCode;
	}

	public void setLogisticCode(String logisticCode) {
		LogisticCode = logisticCode;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public List<TraceBean> getTraces() {
		return Traces;
	}

	public void setTraces(List<TraceBean> traces) {
		Traces = traces;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	@Override
	public String toString() {
		return "ExpressBean [EBusinessID=" + EBusinessID + ", ShipperCode="
				+ ShipperCode + ", Success=" + Success + ", LogisticCode="
				+ LogisticCode + ", State=" + State + ", Reason=" + Reason
				+ ", Traces=" + Traces + "]";
	}

	

}
