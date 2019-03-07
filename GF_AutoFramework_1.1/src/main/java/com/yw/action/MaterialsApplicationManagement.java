package com.yw.action;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import com.yw.object.BasePage;

public class MaterialsApplicationManagement {
	private WebDriver driver;
	private BasePage mainPage;
	private BasePage materialsApplicationPage;
	private BasePage materialsApplicationCreatePage;
	private BasePage materialsApplicationModPage;
	private BasePage materialsApplicationDelPage;
	private BasePage materialsApplicationAudPage;
	
	public MaterialsApplicationManagement(WebDriver driver) {
		this.driver = driver;
	}
	//物料申请管理
	public void MaterialsApplicationIndex() throws Exception {
		mainPage=new BasePage(driver, "mainPage");
		mainPage.click("仓库管理");
		Thread.sleep(500);
		mainPage.click("物料申请管理");
		Thread.sleep(500);
	}
	
	//新建
	public void MaterialsApplicationCreate(String materialCount,String materialDeliveryDate) throws Exception {
		materialsApplicationPage=new BasePage(driver, "materialsApplicationPage");
		materialsApplicationPage.click("新建");
		Thread.sleep(1000);
		materialsApplicationCreatePage=new BasePage(driver, "materialsApplicationCreAndModPage");
		materialsApplicationCreatePage.click("新增一行");
		Thread.sleep(500);
		materialsApplicationCreatePage.click("物料名称");
		Thread.sleep(500);
		materialsApplicationCreatePage.click("选择物料名称");
		Thread.sleep(300);
		materialsApplicationCreatePage.sendKey("数量", materialCount);
		materialsApplicationCreatePage.sendKey("要求到货日期", materialDeliveryDate);
		materialsApplicationCreatePage.click("申购原因");
		Thread.sleep(1000);
		materialsApplicationCreatePage.click("选择备用申购原因");
		materialsApplicationCreatePage.click("新建提交");
		Thread.sleep(500);
	}
	//修改
	public void MaterialsApplicationModify(String materialBrand,String materialModel,String materialCount,String materialUnit,
			String materialDeliveryDate) throws Exception {
		materialsApplicationPage=new BasePage(driver, "materialsApplicationPage");
		materialsApplicationPage.click("修改");
		Thread.sleep(1000);
		materialsApplicationModPage=new BasePage(driver, "materialsApplicationCreAndModPage");
		materialsApplicationModPage.click("物料名称");
		Thread.sleep(500);
		materialsApplicationModPage.click("选择物料名称");
		Thread.sleep(300);
		materialsApplicationModPage.sendKey("品牌",materialBrand );
		materialsApplicationModPage.sendKey("型号规格",materialModel );
		materialsApplicationModPage.sendKey("数量", materialCount);
		materialsApplicationModPage.sendKey("单位", materialUnit);
		materialsApplicationModPage.sendKey("要求到货日期", materialDeliveryDate);
		materialsApplicationModPage.click("申购原因");
		Thread.sleep(1000);
		materialsApplicationModPage.click("选择备用更换原因");
		materialsApplicationModPage.click("修改提交");	
		Thread.sleep(500);
	}
	//删除
	public void MaterialsApplicationDel() throws Exception {
		materialsApplicationPage=new BasePage(driver, "materialsApplicationPage");
		materialsApplicationPage.click("删除");
		Thread.sleep(1000);
		materialsApplicationDelPage=new BasePage(driver, "materialsApplicationDelPage");
		materialsApplicationDelPage.click("确定");
		Thread.sleep(500);
	}
	//提交
	public void MaterialsApplicationSubmit() throws Exception {
		materialsApplicationPage=new BasePage(driver, "materialsApplicationPage");
		materialsApplicationPage.click("提交");
		Thread.sleep(1000);		
	}
	//审核
	public void MaterialsApplicationAudit(String approvalOpt) throws Exception {
		materialsApplicationPage=new BasePage(driver, "materialsApplicationPage");
		materialsApplicationPage.click("审批");
		Thread.sleep(1000);
		materialsApplicationAudPage=new BasePage(driver, "materialsApplicationAuditPage");
		materialsApplicationAudPage.click("通过");
		materialsApplicationAudPage.sendKey("审批意见", approvalOpt);
		materialsApplicationAudPage.click("提交");
		Thread.sleep(1000);
	}
}
