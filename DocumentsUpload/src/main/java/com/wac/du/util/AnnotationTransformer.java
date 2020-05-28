package com.wac.du.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.wac.du.base.TestBase;


public class AnnotationTransformer extends TestBase implements IAnnotationTransformer {
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
