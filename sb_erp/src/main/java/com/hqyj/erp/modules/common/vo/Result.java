package com.hqyj.erp.modules.common.vo;

/**
 * 返回结果封装类
 * @author: HymanHu
 * @date: 2019年10月27日
 */
public class Result {

	private int status;
	private String message;
	private Object object;
	
	public static Result getResult(int code) {
		if (code == 1) {
			return new Result(200, "操作成功。");
		} else if (code == -1) {
			return new Result(500, "操作失败，重名。");
		} else {
			return new Result(500, "操作失败。");
		}
	}

	public Result() {
	}

	public Result(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public Result(int status, String message, Object object) {
		this.status = status;
		this.message = message;
		this.object = object;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
