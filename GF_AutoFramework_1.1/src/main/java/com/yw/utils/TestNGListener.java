package com.yw.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class TestNGListener extends TestListenerAdapter{
	private static WebDriver driver;
	 
	//LogUtil log = new LogUtil(TestNGListener.class);
 
	public static void setDriver(WebDriver driver) {
		TestNGListener.driver = driver;
	}
	@Override
	public void onTestSuccess(ITestResult tr) {
		//log.info("Test Success");
		System.out.println("Test Success");
		super.onTestSuccess(tr);
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		//log.error("Test Failure");
		System.out.println("Test Failure");
		ScreenShot screenShot = new ScreenShot(driver);
		//获取当前project目录
		String path = System.getProperty("user.dir").replace("\\", "/");
		//加上时间戳以区分截图
		//String curTime = TimeUtil.getDate("yyyyMMddHHmmss");
		screenShot.saveScreenShot(path + "/img/", "testFail" +  ".png"); // curTime +
	}
	@Override
	public void onTestSkipped(ITestResult tr) {
		// log.error("Test Skipped");
		System.out.println("Test Skipped");
		super.onTestSkipped(tr);
	}
	@Override
	public void onStart(ITestContext testContext) {
		// log.info("Test Start");
		System.out.println("Test Start");
		super.onStart(testContext);
	}
	@Override
	public void onFinish(ITestContext testContext) {
		// log.info("Test Finish");
		System.out.println("Test Finish");
		super.onFinish(testContext);
	}
}
