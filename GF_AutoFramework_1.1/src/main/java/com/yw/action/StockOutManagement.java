package com.yw.action;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

import com.yw.object.BasePage;
import com.yw.utils.TestBase;

public class StockOutManagement {
	private WebDriver driver;
	private BasePage mainPage;
	private BasePage stockOutManagePage;
	private BasePage stockOutPage;
	private BasePage addMaterialPage;

	public StockOutManagement(WebDriver driver) {
		this.driver = driver;
	}
	//出库管理
	public void stockOutIndex() throws Exception {
		mainPage=new BasePage(driver, "mainPage");
		mainPage.click("仓库管理");
		Thread.sleep(500);
		mainPage.click("出库管理");	
		Thread.sleep(500);
	}
	//新建
	public void stockOutCreate(String applyReason,String stockOutWeight) throws Exception {
		stockOutManagePage=new BasePage(driver, "stockOutManagePage");
		stockOutManagePage.click("新建");
		Thread.sleep(500);
		stockOutPage=new BasePage(driver, "stockOutCreAndModPage");
		stockOutPage.click("添加化工原料");
		Thread.sleep(500);
		addMaterialPage=new BasePage(driver, "addMaterialPage");
		addMaterialPage.click("选择化工原料");
		addMaterialPage.click("保存");
		Thread.sleep(500);
		stockOutPage.sendKey("申请原因",applyReason );
		stockOutPage.sendKey("出库重量", stockOutWeight);
		stockOutPage.click("提交");
		Thread.sleep(500);
	}
	//修改
	public void stockOutModify(String applyReason,String stockOutWeight) throws Exception {
		stockOutManagePage=new BasePage(driver, "stockOutManagePage");
		stockOutManagePage.click("修改");
		Thread.sleep(500);
		stockOutPage=new BasePage(driver, "stockOutCreAndModPage");
		stockOutPage.sendKey("修改申请原因", applyReason);
		stockOutPage.sendKey("修改出库重量", stockOutWeight);
		stockOutPage.click("修改提交");
		Thread.sleep(500);
	}
	//删除
	public void stockOutDelete() throws Exception {
		stockOutManagePage=new BasePage(driver, "stockOutManagePage");
		stockOutManagePage.click("删除");
		Thread.sleep(500);
		stockOutManagePage=new BasePage(driver, "stockOutDelPage");
		Thread.sleep(500);
	}
	//提交
	public void stockOutSubmit() throws Exception {
		stockOutManagePage=new BasePage(driver, "stockOutManagePage");
		stockOutManagePage.click("提交");
		Thread.sleep(500);
	}
	//审核
	public void stockOutAudit(String approvalOpt) throws Exception {
		stockOutManagePage=new BasePage(driver, "stockOutManagePage");
		stockOutManagePage.click("审批");
		Thread.sleep(500);
		stockOutManagePage=new BasePage(driver, "stockOutAudPage");
		stockOutManagePage.click("通过");
		stockOutManagePage.sendKey("审批意见", approvalOpt);
		stockOutManagePage.click("提交");
		Thread.sleep(500);
			
	}
}
