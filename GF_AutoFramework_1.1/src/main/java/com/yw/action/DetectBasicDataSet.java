package com.yw.action;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

import com.yw.object.BasePage;

public class DetectBasicDataSet {
	private WebDriver driver;
	private BasePage mainPage;
	private BasePage detectCatagoryPage;
	private BasePage detectCatagoryCreAndModPage;
	private BasePage detectBasicDataSetPage;
	private BasePage detectItemPage;
	private BasePage detectItemCreAndModPage;
	
	public DetectBasicDataSet(WebDriver driver) {
		super();
		this.driver = driver;
	}
	//检测基础数据设置-检测类别
	public void detectBasicDataSetIndex() throws Exception {
		Thread.sleep(500);
		mainPage=new BasePage(driver, "mainPage");
		mainPage.click("检测管理");
		Thread.sleep(500);
		mainPage.click("检测基础数据设置");
		Thread.sleep(500);		
	}
	//新建检测类别
	public void detectCatagoryCreate(String catagoryName1,String floor1,String upper1) throws Exception {
		detectCatagoryPage=new BasePage(driver, "detectCatagoryPage");
		detectCatagoryPage.click("新建");
		Thread.sleep(500);
		detectCatagoryCreAndModPage=new BasePage(driver, "detectCatagoryCreAndModPage");
		detectCatagoryCreAndModPage.sendKey("检测项分类名1", catagoryName1);
		detectCatagoryCreAndModPage.sendKey("下限1", floor1);
		detectCatagoryCreAndModPage.sendKey("上限1", upper1);
		detectCatagoryCreAndModPage.click("保存");
		Thread.sleep(500);
	}
	/*//修改检测类别
	public void detectCatagoryModify(String catagoryName2,String floor2,String upper2) throws Exception {
		detectCatagoryPage=new BasePage(driver, "detectCatagoryPage");
		detectCatagoryPage.click("修改");
		detectCatagoryCreAndModPage=new BasePage(driver, "detectCatagoryCreAndModPage");
		detectCatagoryCreAndModPage.click("新增一行");
		detectCatagoryCreAndModPage.sendKey("检测项分类名2", catagoryName2);
		detectCatagoryCreAndModPage.sendKey("下限2", floor2);
		detectCatagoryCreAndModPage.sendKey("上限2", upper2);
		detectCatagoryCreAndModPage.click("保存");
	}*/
	//删除检测类别
	public void detectCatagoryDelete() throws Exception {
		detectCatagoryPage=new BasePage(driver, "detectCatagoryPage");
		detectCatagoryPage.click("删除");
	}
	//检测基础数据设置-检测项目
	public void detectItemIndex() throws Exception {
		Thread.sleep(500);
		mainPage=new BasePage(driver, "mainPage");
		mainPage.click("检测管理");
		Thread.sleep(500);
		mainPage.click("检测基础数据设置");
		Thread.sleep(500);	
		detectBasicDataSetPage=new BasePage(driver, "detectBasicDataSetPage");
		detectBasicDataSetPage.click("检测项目");
		Thread.sleep(500);
		}
	//新建检测项目
	public void detectItemCreate(String itemName1,String itemUnit1,String warningFloor1,String warningUpper1,String alarmFloor1,
			String alarmUpper1) throws Exception {
		detectItemPage=new BasePage(driver, "detectItemPage");
		detectItemPage.click("新建");
		Thread.sleep(500);
		detectItemCreAndModPage=new BasePage(driver, "detectItemCreAndModPage");
		detectItemCreAndModPage.sendKey("检测指标名称1", itemName1);
		detectItemCreAndModPage.sendKey("检测指标单位1", itemUnit1);
		detectItemCreAndModPage.sendKey("预警区间下限1", warningFloor1);
		detectItemCreAndModPage.sendKey("预警区间上限1", warningUpper1);
		detectItemCreAndModPage.sendKey("报警区间下限1", alarmFloor1);
		detectItemCreAndModPage.sendKey("报警区间上限1", alarmUpper1);
		detectItemCreAndModPage.click("保存");
		Thread.sleep(500);
	}
	//修改检测项目
	public void detectItemModify(String itemName1,String itemUnit1,String warningFloor1,String warningUpper1,String alarmFloor1,
			String alarmUpper1) throws Exception {
		detectItemPage=new BasePage(driver, "detectItemPage");
		detectItemPage.click("修改");
		Thread.sleep(500);
		detectItemCreAndModPage=new BasePage(driver, "detectItemCreAndModPage");
		detectItemCreAndModPage.sendKey("修改检测指标名称1", itemName1);
		detectItemCreAndModPage.sendKey("修改检测指标单位1", itemUnit1);
		detectItemCreAndModPage.sendKey("修改预警区间下限1", warningFloor1);
		detectItemCreAndModPage.sendKey("修改预警区间上限1", warningUpper1);
		detectItemCreAndModPage.sendKey("修改报警区间下限1", alarmFloor1);
		detectItemCreAndModPage.sendKey("修改报警区间上限1", alarmUpper1);
		detectItemCreAndModPage.click("保存");
		Thread.sleep(500);
	}
	//删除检测项目
	public void detectItemDelete() throws Exception {
		detectItemPage=new BasePage(driver, "detectItemPage");
		detectItemPage.click("删除");
	}
}
