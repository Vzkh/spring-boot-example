package com.cn.model.exception;

import com.cn.model.result.ResultCodeEnum;

public class CMSException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer code;

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public CMSException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public CMSException(ResultCodeEnum resultCodeEnum) {
		super(resultCodeEnum.getMessage());
		this.code = resultCodeEnum.getCode();
	}

	@Override
	public String toString() {
		return "CMSException{" + "code=" + code + ", message=" + this.getMessage() + '}';
	}
}
