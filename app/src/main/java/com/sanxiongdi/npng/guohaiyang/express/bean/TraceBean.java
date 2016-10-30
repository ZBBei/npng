package com.sanxiongdi.npng.guohaiyang.express.bean;

public class TraceBean {
	private String AcceptTime; //时间
	private String AcceptStation;//描述
	private String Remark;//备注

	public String getAcceptTime() {
		return AcceptTime;
	}

	public void setAcceptTime(String acceptTime) {
		AcceptTime = acceptTime;
	}

	public String getAcceptStation() {
		return AcceptStation;
	}

	public void setAcceptStation(String acceptStation) {
		AcceptStation = acceptStation;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	@Override
	public String toString() {
		return "TraceBean [AcceptTime=" + AcceptTime + ", AcceptStation="
				+ AcceptStation + ", Remark=" + Remark + "]";
	}

	

}
