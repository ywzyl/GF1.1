package com.yw.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer{

	public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
		//获取到retryAnalyzer的注解
		IRetryAnalyzer retryAnalyzer = iTestAnnotation.getRetryAnalyzer();
		//如果注解为空，则动态设置注解，以确保用例失败后重跑。
		if (retryAnalyzer == null){ iTestAnnotation.setRetryAnalyzer(TestNGRetry.class); }		
	}
	
}
