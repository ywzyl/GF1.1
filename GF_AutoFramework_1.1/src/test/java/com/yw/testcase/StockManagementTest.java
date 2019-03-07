package com.yw.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.yw.utils.CheckUtil.checkKeyVal;
import com.yw.action.Login;
import com.yw.action.StockManagement;
import com.yw.object.BasePage;
import com.yw.utils.BrowserUtil;
import com.yw.utils.TestBase;
import com.yw.utils.TestNGListener;
import static com.yw.utils.DttUtil.dtt;
import static com.yw.utils.DateUtil.date;
import java.io.IOException;

@Listeners({TestNGListener.class})
public class StockManagementTest extends TestBase{
	TestBase testBase;
	private WebDriver driver;
	String testCaseExcel;
	private Login login;
	private StockManagement stockManagementPage;
	private BasePage stockCheckPage;
	private static BasePage stockInPage;
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
		stockManagementPage=new StockManagement(driver);
		TestNGListener.setDriver(driver);
	}
	@DataProvider(name="loginData")
	public Object[][] loginBZ() throws IOException {
		return dtt(testCaseExcel, 0);
	}
	@DataProvider(name="stockData")
	public Object[][] stock() throws IOException {
		return dtt(testCaseExcel, 9);
	}
	@DataProvider(name="checkData")
	public Object[][] stockChe() throws IOException{
		return dtt(testCaseExcel, 10);
	}
	@Test(priority=1,dataProvider="loginData")
	public void stockManagementIndex(String username,String pwd) throws Exception {
		login.login(username, pwd);
		stockManagementPage.stockManagementIndex();
	}
	@Test(priority=2,dataProvider="stockData",enabled=true,description="入库操作")
	public void stockOperation(String unit,String stockCount) throws Exception {
		stockManagementPage.stock(unit, stockCount);
	}
	@Test(priority=3,dataProvider="checkData",description="查看是否已入库",enabled=false)
	public void stockCheck(String stockPeople,String materialName,String materialModel,String applyCount,String warehouseIn,String depositCount) throws Exception {
		stockManagementPage.stockInCheck();
		checkKeyVal(stockInPage,"stockInPage",driver, "入库日期", date());
		checkKeyVal(stockInPage,"stockInPage",driver, "入库人员", stockPeople);
		checkKeyVal(stockInPage,"stockInPage",driver, "物料名称", materialName);
		checkKeyVal(stockInPage,"stockInPage",driver, "型号规格", materialModel);
		checkKeyVal(stockInPage,"stockInPage",driver, "申请数量", applyCount);
		checkKeyVal(stockInPage,"stockInPage",driver, "存入仓库", warehouseIn);
		checkKeyVal(stockInPage,"stockInPage",driver, "存入数量", depositCount);
		Thread.sleep(500);
		stockCheckPage=new BasePage(driver, "stockInPage");
		stockCheckPage.click("关闭");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
