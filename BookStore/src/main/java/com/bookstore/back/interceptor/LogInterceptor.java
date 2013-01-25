package com.bookstore.back.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("logInterceptor")
public class LogInterceptor implements MethodInterceptor {

	private static final Logger logger = Logger.getLogger(LogInterceptor.class);
	
	public Object invoke(MethodInvocation method) throws Throwable {
		String classMethodIdentifier = method.getMethod().getDeclaringClass()
				+ "." + method.getMethod().getName();
		logger.info(classMethodIdentifier + " starts");
		Object result = method.proceed();
		logger.info(classMethodIdentifier + " finished");
		return result;
	}
}
