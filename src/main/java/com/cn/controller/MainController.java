package com.cn.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.model.result.ResultObject;

@RestController
public class MainController {

	@GetMapping("test")
	public ResultObject test() {
		String str = null;
		System.out.println(str.length());
		return ResultObject.ok().data(new HashMap<String, Object>());
	}

}
