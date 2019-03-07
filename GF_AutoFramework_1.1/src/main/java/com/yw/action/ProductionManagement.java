package com.yw.action;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

import com.yw.object.BasePage;

public class ProductionManagement {
	private WebDriver driver;
	private BasePage mainPage;
	private BasePage disposalCapacityPage;
	private BasePage disposalCapacityCreAndModPage;
	private BasePage disposalCapacityDelPage;

	public ProductionManagement(WebDriver driver) {
		this.driver = driver;
	}
	//处置量管理
	public void disposalCapacityManagementIndex() throws Exception {
		mainPage=new BasePage(driver, "mainPage");
		mainPage.click("生产管理");
		Thread.sleep(500);
		mainPage.click("处理量管理");
		Thread.sleep(500);
	}
	//新建
	public void disposalCapacityCreate(String wasteWater,String sludge,String inkResidue,String disposalDate ) throws Exception {
		disposalCapacityPage=new BasePage(driver, "disposalCapacityPage");
		disposalCapacityPage.click("新建");
		Thread.sleep(500);
		disposalCapacityCreAndModPage=new BasePage(driver, "disposalCapacityCreAndModPage");
		disposalCapacityCreAndModPage.sendKey("废水处置量", wasteWater);
		disposalCapacityCreAndModPage.sendKey("污泥处置量", sludge);
		disposalCapacityCreAndModPage.sendKey("油墨渣处置量", inkResidue);
		disposalCapacityCreAndModPage.sendKey("处置日期", disposalDate);
		disposalCapacityCreAndModPage.click("提交");
		Thread.sleep(500);
	}
	//修改
	public void disposalCapacityModify(String wasteWater,String sludge,String inkResidue) throws Exception {
		disposalCapacityPage=new BasePage(driver, "disposalCapacityPage");
		disposalCapacityPage.click("修改");
		Thread.sleep(500);
		disposalCapacityCreAndModPage=new BasePage(driver, "disposalCapacityCreAndModPage");
		disposalCapacityCreAndModPage.sendKey("修改废水处置量", wasteWater);
		disposalCapacityCreAndModPage.sendKey("修改污泥处置量", sludge);
		disposalCapacityCreAndModPage.sendKey("修改油墨渣处置量", inkResidue);
		Thread.sleep(500);
		disposalCapacityCreAndModPage.click("修改提交");
		Thread.sleep(500);
	}
	//删除
	public void disposalCapacityDelete() throws Exception {
		disposalCapacityPage=new BasePage(driver, "disposalCapacityPage");
		disposalCapacityPage.click("删除");
		disposalCapacityDelPage=new BasePage(driver, "disposalCapacityDelPage");
		Thread.sleep(500);
		disposalCapacityDelPage.click("确定");
	}
}
