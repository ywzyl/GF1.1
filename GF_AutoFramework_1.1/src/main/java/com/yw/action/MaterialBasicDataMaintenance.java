package com.yw.action;

import org.openqa.selenium.WebDriver;
import com.yw.object.BasePage;

public class MaterialBasicDataMaintenance {
	private WebDriver driver;
	private BasePage materialBasicPage;
	private BasePage materialBasicCreatePage;
	private BasePage materialBasicModifyPage;
	private BasePage mainPage;
	private BasePage materialBasicDelPage;
	
	public MaterialBasicDataMaintenance(WebDriver driver) {
		this.driver = driver;
	}

	//物料基础数据维护
	public void materialBasicIndex() throws Exception {
		Thread.sleep(1000);
		mainPage=new BasePage(driver, "mainPage");
		mainPage.click("仓库管理");		
		Thread.sleep(1000);
		mainPage.click("物料基础数据维护");
	}
	//新建
	public void materialBasicCreate(String materialName,String materialModel,String materialBrand,String materialCode,
			String materialUnit,String materialLimit) throws Exception {
		materialBasicPage=new BasePage(driver, "materialBasicPage");
		Thread.sleep(1000);
		materialBasicPage.click("新建");
		Thread.sleep(1000);
		materialBasicCreatePage=new BasePage(driver, "materialBasicCreatePage");
		materialBasicCreatePage.sendKey("物料名称",materialName );
		materialBasicCreatePage.click("物料类型");
		Thread.sleep(500);
		materialBasicCreatePage.click("选择物料类型");
		materialBasicCreatePage.sendKey("规格型号", materialModel);
		materialBasicCreatePage.sendKey("品牌", materialBrand);
		materialBasicCreatePage.sendKey("编码", materialCode);
		materialBasicCreatePage.sendKey("单位", materialUnit);
		materialBasicCreatePage.sendKey("入库数量限制", materialLimit);
		materialBasicCreatePage.click("确认");
	}
	//修改
	public void materialBasicMod(String materialName,String materialModel,String materialCode,String materialUnit,
			String materialPrice,String materialUnitConsumption,String materialFloor,String materialUpper,String materialLimit) throws Exception {
		Thread.sleep(1000);
		materialBasicPage=new BasePage(driver, "materialBasicPage");
		materialBasicPage.click("修改");
		Thread.sleep(1000);
		materialBasicModifyPage=new BasePage(driver, "materialBasicModifyPage");
		materialBasicModifyPage.sendKey("物料名称", materialName);
		materialBasicModifyPage.sendKey("规格型号", materialModel);
		materialBasicModifyPage.sendKey("编码", materialCode);
		materialBasicModifyPage.sendKey("单位", materialUnit);
		materialBasicModifyPage.sendKey("价格", materialPrice);
		materialBasicModifyPage.sendKey("单耗标准", materialUnitConsumption);
		materialBasicModifyPage.sendKey("库存下限", materialFloor);
		materialBasicModifyPage.sendKey("库存上限", materialUpper);
		materialBasicModifyPage.sendKey("入库数量限制", materialLimit);
		materialBasicModifyPage.click("选择入库限制方式");
		Thread.sleep(500);
		materialBasicModifyPage.click("百分比");
		materialBasicModifyPage.click("确认");
		Thread.sleep(500);
	}
	//查看
	public void materialBasicChe() throws  Exception {
		Thread.sleep(500);
		materialBasicPage=new BasePage(driver, "materialBasicPage");
		materialBasicPage.click("查看");
		Thread.sleep(500);
	}
	//修改
	public void materialBasicDel() throws Exception {
		Thread.sleep(500);
		materialBasicPage=new BasePage(driver, "materialBasicPage");
		materialBasicPage.click("删除");
		materialBasicDelPage=new BasePage(driver, "materialBasicDelPage");
		materialBasicDelPage.click("确定");
	}
}
