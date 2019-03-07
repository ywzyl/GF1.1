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

import com.yw.action.DetectBasicDataSet;
import com.yw.action.Login;
import com.yw.utils.BrowserUtil;
import com.yw.utils.TestBase;
import com.yw.utils.TestNGListener;

@Listeners({TestNGListener.class})
public class DetectBasicDataSetTest extends TestBase{
	TestBase testBase;
	String testCaseExcel;
	private WebDriver driver;
	private Login login;
	private DetectBasicDataSet detectBasicDataSet;
	
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
		detectBasicDataSet=new DetectBasicDataSet(driver);
		TestNGListener.setDriver(driver);
	}
	@DataProvider(name="loginZG")
	public Object[][] login() throws IOException{
		return dtt(testCaseExcel, 7);
	}
	@DataProvider(name="createData1")
	public Object[][] create() throws IOException{
		return dtt(testCaseExcel, 17);
	}
	@DataProvider(name="createData2")
	public Object[][] create2() throws IOException{
		return dtt(testCaseExcel, 18);
	}
	@DataProvider(name="modifyData2")
	public Object[][] modify2() throws IOException{
		return dtt(testCaseExcel, 19);
	}
	@Test(priority=1,dataProvider="loginZG")
	public void detectBasicDataSetIndex(String username,String pwd) throws Exception {
		login.login(username, pwd);
		
	}
	@Test(priority=2,enabled=false)
	public void detectBasicDataSetIndex() throws Exception {
		detectBasicDataSet.detectBasicDataSetIndex();
	}
	@Test(priority=3,dataProvider="createData1",enabled=false)
	public void detectBasicDataSetCreate(String catagoryName1,String floor1,String upper1) throws Exception {
		detectBasicDataSet.detectCatagoryCreate(catagoryName1, floor1, upper1);
	}
	@Test(priority=4,enabled=false)
	public void detectBasicDataSetDelete() throws Exception {
		detectBasicDataSet.detectCatagoryDelete();
	}
	@Test(priority=5)
	public void detectItemIndex() throws Exception {
		detectBasicDataSet.detectItemIndex();
	}
	@Test(priority=6,dataProvider="createData2")
	public void detectItemCreate(String itemName1,String itemUnit1,String warningFloor1,String warningUpper1,String alarmFloor1,
			String alarmUpper1) throws Exception {
		detectBasicDataSet.detectItemCreate(itemName1, itemUnit1, warningFloor1, warningUpper1, alarmFloor1, alarmUpper1);
	}
	@Test(priority=7,dataProvider="modifyData2")
	public void detectItemModify(String itemName1,String itemUnit1,String warningFloor1,String warningUpper1,String alarmFloor1,
			String alarmUpper1) throws Exception {
		detectBasicDataSet.detectItemModify(itemName1, itemUnit1, warningFloor1, warningUpper1, alarmFloor1, alarmUpper1);
	}
	@Test(priority=8,enabled=false)
	public void detectItemDelete() throws Exception {
		detectBasicDataSet.detectItemDelete();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
