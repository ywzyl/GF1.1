package com.yw.action;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import com.yw.object.BasePage;

public class WarehouseSet {
	private WebDriver driver;
	private BasePage mainPage;
	private BasePage warehousePage;
	private BasePage warehouseCreAndModPage;
	
	public WarehouseSet(WebDriver driver) {
		super();
		this.driver = driver;
	}
	//仓库设置
	public void warehouseIndex() throws Exception {
		Thread.sleep(500);
		mainPage=new BasePage(driver, "mainPage");
		mainPage.click("仓库管理");
		Thread.sleep(500);
		mainPage.click("仓库设置");
	}
	//新建
	public void warehouseCreate(String warehouseName,String capacity,String remark,String photoPath) throws Exception {
		Thread.sleep(500);
		warehousePage=new BasePage(driver, "warehousePage");
		warehousePage.click("新建");
		Thread.sleep(1000);
		warehouseCreAndModPage=new BasePage(driver, "warehouseCreAndModPage");
		warehouseCreAndModPage.sendKey("仓库名称", warehouseName);
		warehouseCreAndModPage.click("仓库类型");
		Thread.sleep(500);
		warehouseCreAndModPage.click("选择化工原料辅料");
		warehouseCreAndModPage.sendKey("容量（吨）", capacity);
		warehouseCreAndModPage.click("仓库负责人");
		Thread.sleep(500);
		warehouseCreAndModPage.click("选择仓库负责人");
		warehouseCreAndModPage.sendKey("备注", remark);
		warehouseCreAndModPage.sendKey("仓库平面图", photoPath);
		warehouseCreAndModPage.click("确认");
	}
	//修改
	public void warehouseModify(String warehouseName,String remark,String photoPath) throws Exception {
		Thread.sleep(500);
		warehousePage=new BasePage(driver, "warehousePage");
		warehousePage.click("修改");
		Thread.sleep(1000);
		warehouseCreAndModPage=new BasePage(driver, "warehouseCreAndModPage");
		warehouseCreAndModPage.sendKey("修改仓库名称", warehouseName);
		warehouseCreAndModPage.click("修改仓库负责人");
		Thread.sleep(500);
		warehouseCreAndModPage.click("选择新仓库负责人");
		warehouseCreAndModPage.sendKey("修改备注", remark);
		warehouseCreAndModPage.sendKey("修改仓库平面图", photoPath);
		warehouseCreAndModPage.click("修改确认");
	}
	//删除
	
}
