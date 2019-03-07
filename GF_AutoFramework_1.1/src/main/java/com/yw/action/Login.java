package com.yw.action;


import org.dom4j.DocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.yw.object.BasePage;

public class Login {
	private WebDriver driver;
	private BasePage loginPage;
	private BasePage mainPage;
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	// 登录操作
	public void login(String username,String pwd) throws Exception {
		loginPage=new BasePage(driver, "loginPage");//这里的pageName要对应page.xml文件中的page标签值
		loginPage.sendKey("登录输入账号框", username);//登录输入账号框对应的是page.xml中设置的元素名称
		loginPage.sendKey("登录输入密码框", pwd);
		loginPage.click("登录");
	}
	//退出操作
	public void loginOut() throws Exception {
		mainPage=new BasePage(driver, "mainPage");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName(\"popover-content-container\")[0].style.display='block'");
		mainPage.click("退出登录");
	}
}
