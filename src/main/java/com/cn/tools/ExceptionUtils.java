package com.cn.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionUtils {

	/**
	 * 打印异常信息
	 */
	public static String getMessage(Exception e) {
		String swStr = null;
		try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
			StackTraceElement st = e.getStackTrace()[0];//获取对应类名，方法名，行号
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();
			swStr = st.getClassName() + "/" + st.getMethodName() + "/" + st.getLineNumber() + "\n" + sw.toString();
		} catch (IOException ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return swStr;
	}
}
