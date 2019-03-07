package com.yw.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.yw.utils.DttUtil.dtt;

import java.io.IOException;

import com.yw.action.Login;
import com.yw.action.ProductionManagement;
import com.yw.utils.BrowserUtil;
import com.yw.utils.TestBase;
import com.yw.utils.TestNGListener;
@Listeners({TestNGListener.class})
public class ProductionManagementTest extends TestBase{
	TestBase testBase;
	String testCaseExcel;
	private WebDriver driver;
	private Login login;
	private ProductionManagement disposalCapacityManagement;
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
		disposalCapacityManagement=new ProductionManagement(driver);
		TestNGListener.setDriver(driver);
	}
	@DataProvider(name="loginBZ")
	public Object[][] loginBZ() throws IOException{
		return dtt(testCaseExcel, 0);
	}
	@DataProvider(name="createData ")
	public Object[][] create() throws IOException{
		return dtt(testCaseExcel, 15);
	}
	@DataProvider(name="modifyData ")
	public Object[][] modify() throws IOException{
		return dtt(testCaseExcel, 16);
	}
	@Test(priority=1,dataProvider="loginBZ")
	public void productionManagementIndex(String username,String pwd) throws Exception {
		login.login(username, pwd);
		disposalCapacityManagement.disposalCapacityManagementIndex();
	}
	@Test(priority=2,dataProvider="createData ")
	public void disposalCapacityCreate(String wasteWater,String sludge,String inkResidue,String disposalDate) throws Exception {
		disposalCapacityManagement.disposalCapacityCreate(wasteWater, sludge, inkResidue, disposalDate);
	}
	@Test(priority=3,dataProvider="modifyData ")
	public void disposalCapacityModify(String wasteWater,String sludge,String inkResidue) throws Exception {
		disposalCapacityManagement.disposalCapacityModify(wasteWater, sludge, inkResidue);
	}
	@Test(priority=4,enabled=false)
	public void disposalCapacityDelete() throws Exception {
		disposalCapacityManagement.disposalCapacityDelete();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
