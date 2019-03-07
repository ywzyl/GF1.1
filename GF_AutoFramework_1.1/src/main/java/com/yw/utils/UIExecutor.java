package com.yw.utils;

import org.openqa.selenium.WebElement;

import com.yw.object.Locator;

/**
 * webDriver常见的API
 * @author zhangj
 *
 */
public interface UIExecutor {
	//点击
	public void click(Locator locator) throws Exception ;
	//输入文本
	public void sendKey(Locator locator,String value) throws Exception ;
	//获取元素文本
	public String getText(Locator locator) throws Throwable;
	//获取元素
	public WebElement getElement(Locator locator) throws Exception;
	//判断元素是否显示
	public boolean isElementDisplayed(Locator locator) throws Exception;
	//切换页面
	public void switchWindow(String title);
	//切换frame
	public void switchFrame(Locator locator);
	//智能等待
	public void waitElement(Locator locator);
}
