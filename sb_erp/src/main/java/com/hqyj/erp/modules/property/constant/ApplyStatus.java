package com.hqyj.erp.modules.property.constant;

public enum ApplyStatus {
	APPLY(0, "申请"), APPROVE(1, "同意"), REJECT(-1, "拒绝");
	
	private int code;
	private String desc;

	private ApplyStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
