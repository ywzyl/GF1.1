package com.yw.action;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

import com.yw.object.BasePage;

public class StockManagement {
	private WebDriver driver;
	private BasePage mainPage;
	private BasePage stockPendingPage;
	private BasePage stockManagePage;
	private BasePage stockInPage;
	public StockManagement (WebDriver driver) {
		this.driver=driver;
	}
	//入库管理
	public void stockManagementIndex() throws Exception {
		mainPage=new BasePage(driver, "mainPage");
		mainPage.click("仓库管理");
		Thread.sleep(500);
		mainPage.click("入库管理");
		Thread.sleep(1000);
	}
	//入库
	public void stock(String unit,String stockCount) throws Exception {
		stockPendingPage=new BasePage(driver, "stockPendingPage");
		stockPendingPage.click("入库");
		Thread.sleep(1000);
		stockManagePage=new BasePage(driver, "stockManagePage");
		stockManagePage.sendKey("送料单位", unit);
		stockManagePage.click("存入仓库");
		Thread.sleep(500);
		stockManagePage.click("选择存入仓库");
		Thread.sleep(1000);
		stockManagePage.sendKey("存入数量", stockCount);
		stockManagePage.click("确认");
		Thread.sleep(1000);
	}
	//已入库查看
	public void stockInCheck() throws Exception {
		stockInPage=new BasePage(driver, "stockInPage");
		stockInPage.click("已入库");
		Thread.sleep(1000);
		stockInPage.click("查看");
		Thread.sleep(500);
	}
}
