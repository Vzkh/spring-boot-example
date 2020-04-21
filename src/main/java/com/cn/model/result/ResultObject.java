package com.cn.model.result;

import java.util.Map;

import lombok.Data;

@Data
public class ResultObject {
	// 请求状态
	private Boolean success;
	// 请求code码
	private Integer code;
	// 请求返回结果描述
	private String message;
	// 接口返回数据
	private Map<String, Object> data;

	private ResultObject() {
	}

	/**
	 * 设置结果，形参为结果枚举
	 * 
	 * @param result
	 * @return
	 */
	public static ResultObject setResult(ResultCodeEnum result) {
		ResultObject res = new ResultObject();
		res.setSuccess(result.getSuccess());
		res.setCode(result.getCode());
		res.setMessage(result.getMessage());
		return res;
	}

	/**
	 * 成功通用返回
	 * 
	 * @return
	 */
	public static ResultObject ok() {
		return setResult(ResultCodeEnum.SUCCESS);
	}

	/**
	 * 通用错误返回
	 * 
	 * @return
	 */
	public static ResultObject error() {
		return setResult(ResultCodeEnum.UNKNOWN_ERROR);
	}

	/**
	 * 通用参数错误返回
	 * 
	 * @return
	 */
	public static ResultObject paramError() {
		return setResult(ResultCodeEnum.PARAM_ERROR);
	}

	/**
	 * 设置接口返回值
	 * 
	 * @param data
	 * @return
	 */
	public ResultObject data(Map<String, Object> data) {
		this.setData(data);
		return this;
	}

	/**
	 * 修改/新增data中参数
	 */
	public ResultObject data(String key, String value) {
		this.data.put(key, value);
		return this;
	}

	// 自定义状态信息
	public ResultObject message(String message) {
		this.setMessage(message);
		return this;
	}

	// 自定义状态码
	public ResultObject code(Integer code) {
		this.setCode(code);
		return this;
	}

	// 自定义返回结果
	public ResultObject success(Boolean success) {
		this.setSuccess(success);
		return this;
	}

}
