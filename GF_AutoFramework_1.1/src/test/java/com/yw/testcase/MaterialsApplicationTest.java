package com.yw.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.yw.action.Login;
import com.yw.action.MaterialsApplicationManagement;
import com.yw.object.BasePage;
import com.yw.utils.BrowserUtil;
import com.yw.utils.TestBase;
import com.yw.utils.TestNGListener;
import static com.yw.utils.DttUtil.dtt;

import java.io.IOException;
@Listeners({TestNGListener.class})
public class MaterialsApplicationTest extends TestBase{
	TestBase testBase;
	String testCaseExcel;
	private WebDriver driver;
	private Login login;
	private MaterialsApplicationManagement materialsApplicationPage;
	/*private MaterialsApplicationManagement materialsApplicationPage; 
	private MaterialsApplicationManagement materialsApplicationCreatePage;
	private MaterialsApplicationManagement materialsApplicationModPage;
	private MaterialsApplicationManagement materialsApplicationAudPage;*/
	@BeforeClass
	public void beforeClass() {
		testBase=new TestBase();
		testCaseExcel=prop.getProperty("data");
		driver=BrowserUtil.chrome(prop.getProperty("chromedriver"), 30);
		driver.get(prop.getProperty("HOST"));
	}
	@BeforeMethod
	public void beforeMethod() {
		login=new Login(driver);
		materialsApplicationPage=new MaterialsApplicationManagement(driver);
		//materialsApplicationPage=new MaterialsApplicationManagement(driver);
		//materialsApplicationCreatePage=new MaterialsApplicationManagement(driver);
		//materialsApplicationModPage=new MaterialsApplicationManagement(driver);
		//materialsApplicationAudPage=new MaterialsApplicationManagement(driver);
		TestNGListener.setDriver(driver);
	}
	@DataProvider(name="loginData")
	public Object[][] loginBZ() throws IOException {
		return dtt(testCaseExcel, 0);
	}
	@DataProvider(name="createData")
	public Object[][] mACreate() throws IOException{
		return dtt(testCaseExcel, 4);
	}
	@DataProvider(name="modData")
	public Object[][] mAMod() throws IOException{
		return dtt(testCaseExcel, 5);
	}
	@DataProvider(name="loginZG")
	public Object[][] loginZG() throws IOException{
		return dtt(testCaseExcel, 6);
	}
	@Test(priority=1,dataProvider="loginData")
	public void materialsApplicationIndex(String username,String pwd) throws Exception {
		login.login(username, pwd);
		materialsApplicationPage.MaterialsApplicationIndex();
	}
	@Test(priority=2,dataProvider="createData",enabled=true,description="新建物料申请单")
	public void materialsApplicationCreate(String materialCount,String materialDeliveryDate) throws Exception {
		materialsApplicationPage.MaterialsApplicationCreate(materialCount, materialDeliveryDate);
		String tip=new BasePage(driver, "materialsApplicationPage").getText("提交成功");
		Assert.assertEquals(tip, "提交成功！");
	}
	@Test(priority=3,dataProvider="modData",enabled=false,description="修改物料申请单")
	public void materialsApplicationMod(String materialBrand,String materialModel,String materialCount,String materialUnit,
			String materialDeliveryDate) throws Exception {
		materialsApplicationPage.MaterialsApplicationModify(materialBrand, materialModel, materialCount, materialUnit, materialDeliveryDate);
		String tip=new BasePage(driver, "materialsApplicationPage").getText("提交成功");
		Assert.assertEquals(tip, "提交成功！");
	}
	@Test(priority=4,enabled=false,description="删除物料申请单")
	public void materialsApplicationDel() throws Exception {
		materialsApplicationPage.MaterialsApplicationDel();
		String tip=new BasePage(driver, "materialsApplicationPage").getText("删除成功");
		Assert.assertEquals(tip, "删除成功！");
	}
	@Test(priority=5,description="提交物料申请单")
	public void materialsApplicationSub() throws Exception {
		materialsApplicationPage.MaterialsApplicationSubmit();
		String tip=new BasePage(driver, "materialsApplicationPage").getText("提交成功");
		Assert.assertEquals(tip, "提交成功");
	}
	@Test(priority=6,dataProvider="loginZG",description="审批物料申请单")
	public void materialsApplicationAud(String username,String pwd,String approvalOpt) throws Exception {
		login.loginOut();
		//Thread.sleep(1000);
		login.login(username, pwd);
		//Thread.sleep(1000);
		materialsApplicationPage.MaterialsApplicationIndex();
		//Thread.sleep(500);
		materialsApplicationPage.MaterialsApplicationAudit(approvalOpt);
		//Thread.sleep(500);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
