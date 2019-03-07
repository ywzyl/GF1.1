package com.yw.utils;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.yw.object.Locator;
/**
 * UIExecutor接口实现类
 * @author zhangj
 *
 */

public class UIExecutorImpl implements UIExecutor{
	private WebDriver driver;
	public LogUtil log;
	public UIExecutorImpl(WebDriver driver) {
		this.driver = driver;
	}
	

	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * 点击元素
	 * @throws Exception 
	 */

	public void click(Locator locator) throws Exception {
		WebElement element=getElement(locator);
		element.click();		
	}
	/**
	 * 输入文本
	 * @throws Exception 
	 */

	public void sendKey(Locator locator, String value) throws Exception {

			WebElement element = getElement(locator);
	
		element.clear();
		element.sendKeys(value);
	}
	/**
	 * 获取文本内容
	 */
	public String getText(Locator locator) throws Exception {
		WebElement element=getElement(locator);
		return element.getText();
		
	}
	/**
	 * 获取元素
	 */
	public WebElement getElement(Locator locator) throws Exception {
		WebElement element=null;
		String address=locator.getAddress();
		switch(locator.getByType()) {
		case xpath:
			element=driver.findElement(By.xpath(address));
			break;
		case id:
			element=driver.findElement(By.id(address));
			break;
		case className:
			element=driver.findElement(By.className(address));
			break;
		case linkText:
			element=driver.findElement(By.linkText(address));
			break;
		default:
			break;
		}
		return element;
	}
	/**
	 * 元素是否显式显示
	 * @throws Exception 
	 */
	public boolean isElementDisplayed(Locator locator) throws Exception {
		boolean flag=false;
		WebElement element=getElement(locator);
		flag=element.isDisplayed();
		return flag;
	}
	/**
	 * 切换窗口
	 */
	public void switchWindow(String title) {
		Set<String> handles=driver.getWindowHandles();
		for (String handle : handles) {
			if (handle.equals(driver.getWindowHandle())) {
				continue;
			}else {
				driver.switchTo().window(handle);
				if (title.contains(driver.getTitle())) {
					break;
				}else {
					continue;
				}
			}
		}
		
	}
	/**
	 * 切换frame
	 */
	public void switchFrame(Locator locator) {
		driver.switchTo().frame(locator.getAddress());
		
	}
	/**
	 * 智能等待，超过该时长抛出异常
	 */
	public void waitElement(Locator locator) {
		
	}
	
	
}
