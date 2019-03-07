package com.yw.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.yw.action.Login;
import com.yw.action.MaterialBasicDataMaintenance;
import com.yw.object.BasePage;
import com.yw.utils.BrowserUtil;
import com.yw.utils.TestNGListener;

@Listeners({TestNGListener.class})
public class LoginTest {
	private WebDriver driver;
	private Login loginBZ;
	private MaterialBasicDataMaintenance materialBasicCreate;
	@DataProvider(name="loginParams")
	public Object[][] loginParams(){
		return new Object[][]{{"li","1111","用户名或密码错误"},{"li","","请输入登录密码！"},{"","123456","请输入登录账户！"}};
	}
	@BeforeClass
	//@Parameters({"browserDriverUrl","url"})
	public void beforeClass() {
		driver=BrowserUtil.chrome("C:\\Users\\zhangj\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe", 30);
		driver.get("https://gcfw.dongjiang.com.cn/wf/");
	}
	@BeforeMethod
	public void beforeMethod() {
		loginBZ=new Login(driver);
		TestNGListener.setDriver(driver);
	}
	/*@Test//(dataProvider="loginParams",description= "异常用户信息登录",enabled=false)
	public void  login02() throws Exception{
		loginBZ.login("li", "");
		String tip = new BasePage(driver, "loginPage").getText("错误提示");
		Assert.assertEquals(tip, "用户密码不能为空");
	}*/
	@Test(priority=1,description="正常用户登录")  //dependsOnMethods="login02",
	//@Parameters({"username", "pwd"})
	public void login() throws Exception {
		loginBZ.login("bzceshi", "123456");
		//String tip = new BasePage(driver, "mainPage").getText("头像");
		//Assert.assertEquals(tip, "客服热线：0755-2309674");
		System.out.println("success");
	}
	/*@Test(priority=2,description="新建物料基础数据")//dependsOnMethods="login",
	public void MaterialBasicCreate() throws Exception {
		materialBasicCreate.materialBasicIndex();
		materialBasicCreate.materialBasicCreate("PVC","27%","杂牌","CG11010009","吨","5000");
		String tip=new BasePage(driver, "materialBasicPage").getText("保存成功");
		Assert.assertEquals(tip, "保存成功");
	}*/
	@AfterClass
	public void afterClass() {
 
	}
	@AfterTest
	public void afterTest(){
	    driver.quit();
	}
}
