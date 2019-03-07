package com.yw.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNGRetry implements IRetryAnalyzer{
	//设置当前的重跑次数
	private int retryCount = 1;
	//设置最大重跑次数，定义为常量。
    private static final int maxRetryCount = 3;

	public boolean retry(ITestResult iTestResult) {
		if (retryCount<=maxRetryCount){
			//输出当前的重跑次数以及当前的正在重跑的用例名称。
            System.out.println("it's the "+retryCount+"times retry.And the current case is"+iTestResult.getName());
            //重跑之后，次数+1
            retryCount++;
            //当return true之后，代表继续重跑
            return true;
        }
		//return false之后，代表停止重跑
        return false;
    }

    public void reSetCount(){
        retryCount=1;
	}

}
