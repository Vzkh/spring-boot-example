package com.cn.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.model.exception.CMSException;
import com.cn.model.result.ResultCodeEnum;
import com.cn.model.result.ResultObject;
import com.cn.tools.ExceptionUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	/** -------- 通用异常处理方法 -------- **/
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResultObject error(Exception e) {
//		System.out.println(ExceptionUtils.getMessage(e));// 控制台输出
		log.error(ExceptionUtils.getMessage(e));// 日志文件输出
		return ResultObject.error();
	}

	/** -------- 指定异常处理方法 -------- **/
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public ResultObject error(NullPointerException e) {
//		System.out.println(ExceptionUtils.getMessage(e));// 控制台输出
		log.error(ExceptionUtils.getMessage(e));// 日志文件输出
		return ResultObject.setResult(ResultCodeEnum.NULL_POINT_ERROR);
	}

	/** -------- 自定义定异常处理方法 -------- **/
	@ExceptionHandler(CMSException.class)
	@ResponseBody
	public ResultObject error(CMSException e) {
//		System.out.println(ExceptionUtils.getMessage(e));// 控制台输出
		log.error(ExceptionUtils.getMessage(e));// 日志文件输出
		return ResultObject.error().message(e.getMessage()).code(e.getCode());
	}
}
