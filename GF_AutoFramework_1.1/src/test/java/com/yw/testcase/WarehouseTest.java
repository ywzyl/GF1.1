package com.yw.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.yw.action.Login;
import com.yw.action.WarehouseSet;
import com.yw.utils.BrowserUtil;
import com.yw.utils.TestBase;
import com.yw.utils.TestNGListener;
import static com.yw.utils.DttUtil.dtt;
import java.io.IOException;

@Listeners({TestNGListener.class})
public class WarehouseTest extends TestBase{
	TestBase testBase;
	private WebDriver driver;
	String testCaseExcel;
	private Login login;
	private WarehouseSet warehousePage;
	@BeforeClass
	public void beforeClass() {
		testBase=new TestBase();
		testCaseExcel=prop.getProperty("data");
		driver=BrowserUtil.chrome(prop.getProperty("chromedriver"), 30);
		driver.get(prop.getProperty("HOST"));
	}
	@BeforeMethod
	public void beforMethod() {
		login=new Login(driver);
		warehousePage=new WarehouseSet(driver);
		TestNGListener.setDriver(driver);
	}
	@DataProvider(name="loginData")
	public Object[][] loginZG() throws IOException {
		return dtt(testCaseExcel, 7);
	}
	@DataProvider(name="createData")
	public Object[][] warehouseCre() throws IOException {
		return dtt(testCaseExcel, 8);
	}
	@DataProvider(name="modifyData")
	public Object[][] warehouseMod() throws IOException {
		return dtt(testCaseExcel, 14);
	}
	@Test(priority=1,dataProvider="loginData")
	public void warehouseSetIndex(String username,String pwd) throws Exception {
		login.login(username, pwd);
		warehousePage.warehouseIndex();
	}
	@Test(priority=2,dataProvider="createData",description="新建仓库",enabled=true)
	public void warehouseCreate(String warehouseName,String capacity,String remark,String photoPath) throws Exception {
		warehousePage.warehouseCreate(warehouseName, capacity, remark, photoPath);
	}
	@Test(priority=3,dataProvider="modifyData",description="修改仓库",enabled=false)
	public void warehouseModify(String warehouseName,String remark,String photoPath) throws Exception {
		warehousePage.warehouseModify(warehouseName, remark, photoPath);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
