package com.yw.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.yw.action.Login;
import com.yw.action.StockOutManagement;
import com.yw.utils.BrowserUtil;
import com.yw.utils.TestBase;
import com.yw.utils.TestNGListener;
import static com.yw.utils.DttUtil.dtt;
import java.io.IOException;

@Listeners({TestNGListener.class})
public class StockOutManagementTest extends TestBase{
	TestBase testBase;
	String testCaseExcel;
	private StockOutManagement stockOutManagementPage;
	private WebDriver driver;
	private Login login;
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
		stockOutManagementPage=new StockOutManagement(driver);
		TestNGListener.setDriver(driver);
	}
	@DataProvider(name="loginBZ")
	public Object[][] loginBZ() throws IOException{
		return dtt(testCaseExcel, 0);
	}
	@DataProvider(name="createData")
	public Object[][] create() throws IOException{
		return dtt(testCaseExcel, 11);
	}
	@DataProvider(name="modifyData")
	public Object[][] modify() throws IOException{
		return dtt(testCaseExcel, 12);
	}
	@DataProvider(name="loginZG")
	public Object[][] loginZG() throws IOException{
		return dtt(testCaseExcel, 13);
	}
	@Test(priority=1,dataProvider="loginBZ",enabled=true)
	public void stockOutManagementIndex(String username,String pwd) throws Exception {
		login.login(username, pwd);
		stockOutManagementPage.stockOutIndex();
	}
	@Test(priority=2,dataProvider="createData",enabled=false,description="新建出库单")
	public void stockOutCreate(String applyReason,String stockOutWeight) throws Exception {
		stockOutManagementPage.stockOutCreate(applyReason, stockOutWeight);
	}
	@Test(priority=3,dataProvider="modifyData",enabled=false,description="修改出库单")
	public void stockOutModify(String applyReason,String stockOutWeight) throws Exception {
		stockOutManagementPage.stockOutModify(applyReason, stockOutWeight);
	}
	@Test(priority=4,description="删除出库单",enabled=false)
	public void	stockOutDelete() throws Exception {
		stockOutManagementPage.stockOutDelete();
	}
	@Test(priority=5,description="提交出库单",enabled=false)
	public void stockOutSubmit() throws Exception {
		stockOutManagementPage.stockOutSubmit();
	}
	@Test(priority=6,dataProvider="loginZG",description="审核出库单")
	private void stockOutAudit(String username,String pwd,String approvalOpt) throws Exception {
		login.loginOut();
		login.login(username, pwd);
		stockOutManagementPage.stockOutIndex();
		stockOutManagementPage.stockOutAudit(approvalOpt);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
