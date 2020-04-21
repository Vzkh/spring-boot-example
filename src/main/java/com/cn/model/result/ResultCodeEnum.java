package com.cn.model.result;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

	SUCCESS(true, 0, "成功"), UNKNOWN_ERROR(false, -1, "未知错误"), PARAM_ERROR(false, 2, "参数错误"),
	NULL_POINT_ERROR(false, -1, "空指针异常");

	private Boolean success;
	private Integer code;
	private String message;

	ResultCodeEnum(boolean success, Integer code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}

}
