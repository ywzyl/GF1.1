package com.yw.utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * 在用例执行失败和用例执行成功后，都需要重置当前的重跑次数。
 * @author zhangj
 *
 */
public class TestRunnerListener extends TestListenerAdapter{
	@Override
	public void onTestSuccess(ITestResult tr) {
		TestNGRetry retryAnalyzer = (TestNGRetry) tr.getMethod().getRetryAnalyzer();
        retryAnalyzer.reSetCount();
        onFinish((ITestContext) tr);
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		TestNGRetry retryAnalyzer = (TestNGRetry) tr.getMethod().getRetryAnalyzer();
        retryAnalyzer.reSetCount();
        onFinish((ITestContext) tr);
	}
}
