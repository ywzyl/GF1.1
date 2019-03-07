package com.yw.utils;

import static com.yw.utils.JavaScriptUtil.getRandomString;
import static com.yw.utils.JavaScriptUtil.jsGetValue;
import static com.yw.utils.JavaScriptUtil.jsStrToSetAtt;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.yw.object.BasePage;

public class CheckUtil {
	//private static BasePage materialBasicModifyPage;
	public static void checkKeyVal(BasePage usingPage,String pageName,WebDriver driver2,String locator,String keyString) throws Exception {
		usingPage=new BasePage(driver2, pageName);
		WebElement materialN= usingPage.getElement(locator);
		String val=getRandomString();
		jsStrToSetAtt(driver2,materialN, val);		
		Assert.assertEquals(jsGetValue(driver2, val), keyString);
	}
}
