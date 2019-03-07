

import static com.yw.utils.CheckUtil.checkKeyVal;
import static com.yw.utils.DttUtil.dtt;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.yw.action.Login;
import com.yw.action.MaterialBasicDataMaintenance;
import com.yw.object.BasePage;
import com.yw.utils.BrowserUtil;
import com.yw.utils.TestBase;
import com.yw.utils.TestNGListener;

@Listeners({TestNGListener.class})
public class MaterialBasicTest extends TestBase{
	TestBase testBase;
	String testCaseExcel;
	private WebDriver driver;
	private Login loginBZ;
	private MaterialBasicDataMaintenance materialBasicPage;
	//private MaterialBasicDataMaintenance materialBasicCreate;
	private static BasePage materialBasicModifyPage;
	//private MaterialBasicDataMaintenance materialBasicDel;
	//private MaterialBasicDataMaintenance materialBasicCheck;
	private BasePage materialBasicCheckPage;	
	@BeforeClass
	public void beforeClass() {
		driver=BrowserUtil.chrome(prop.getProperty("chromedriver"), 30);
		driver.get(prop.getProperty("HOST"));
		testBase=new TestBase();
		testCaseExcel=prop.getProperty("data");
	}
	@BeforeMethod
	public void beforeMethod() {
		loginBZ=new Login(driver);
		materialBasicPage=new MaterialBasicDataMaintenance(driver);
		/*materialBasicModify=new MaterialBasicDataMaintenance(driver);
		materialBasicCheck=new MaterialBasicDataMaintenance(driver);
		materialBasicDel=new MaterialBasicDataMaintenance(driver);*/
		TestNGListener.setDriver(driver);

	}
	@DataProvider(name="loginData")
	public Object[][] loginBZ() throws IOException{
		return dtt(testCaseExcel, 0);
	}
	@DataProvider(name="createData")
	public Object[][] mBCreate() throws IOException{
		return dtt(testCaseExcel, 1);
	}
	@DataProvider(name="modifyData")
	public Object[][] mBModify() throws IOException{
		return dtt(testCaseExcel, 2);
	}
	@DataProvider(name="checkData")
	public Object[][] mBCheck() throws IOException{
		return dtt(testCaseExcel, 3);
	}
	@Test(priority=1,dataProvider="loginData")
	public void materialBasicIndex(String username,String pwd) throws Exception {
		loginBZ.login(username, pwd);
		materialBasicPage.materialBasicIndex();		
	}
	@Test(priority=2,dataProvider="createData",enabled=false,description="新建物料基础数据")
	public void materialBasicCreate(String materialName,String materialModel,String materialBrand,String materialCode,
			String materialUnit,String materialLimit) throws Exception {
		materialBasicPage.materialBasicCreate(materialName,materialModel,materialBrand,materialCode,materialUnit,materialLimit);
		String tip=new BasePage(driver, "materialBasicPage").getText("保存成功");
		Assert.assertEquals(tip, "保存成功！");
	}
	@Test(priority=3,dataProvider="modifyData",enabled=true,description="修改物料基础数据")
	public void materialBasicModify(String materialName,String materialModel,String materialCode,String materialUnit,String materialPrice,
			String materialUnitConsumption,String materialFloor,String materialUpper,String materialLimit) throws Exception {
		materialBasicPage.materialBasicMod(materialName, materialModel, materialCode, materialUnit, materialPrice, 
				materialUnitConsumption, materialFloor, materialUpper, materialLimit);		
		String tip=new BasePage(driver, "materialBasicPage").getText("保存成功");
		Assert.assertEquals(tip, "保存成功！");
	}
	
	@Test(priority=4,dataProvider="checkData",enabled=true,description="查看物料基础数据")
	public void materialBasicCheck(String materialName,String materialType,String materialBrand,String materialModel,String materialCode,
			String materialUnit,String materialPrice,String materialUnitConsumption,String materialFloor,String materialUpper,
			String materialLimit) throws Exception {
		materialBasicPage.materialBasicChe();
		
		checkKeyVal(materialBasicModifyPage,"materialBasicModifyPage",driver, "物料名称", materialName);
		checkKeyVal(materialBasicModifyPage,"materialBasicModifyPage",driver, "物料类型", materialType);
		checkKeyVal(materialBasicModifyPage,"materialBasicModifyPage",driver, "规格型号", materialModel);
		checkKeyVal(materialBasicModifyPage,"materialBasicModifyPage",driver, "品牌", materialBrand);
		checkKeyVal(materialBasicModifyPage,"materialBasicModifyPage",driver, "编码", materialCode);
		checkKeyVal(materialBasicModifyPage,"materialBasicModifyPage",driver, "单位", materialUnit);
		checkKeyVal(materialBasicModifyPage,"materialBasicModifyPage",driver, "价格", materialPrice);
		checkKeyVal(materialBasicModifyPage,"materialBasicModifyPage",driver, "单耗标准", materialUnitConsumption);
		checkKeyVal(materialBasicModifyPage,"materialBasicModifyPage",driver, "库存下限", materialFloor);
		checkKeyVal(materialBasicModifyPage,"materialBasicModifyPage",driver, "库存上限", materialUpper);
		checkKeyVal(materialBasicModifyPage,"materialBasicModifyPage",driver, "入库数量限制", materialLimit);
		Thread.sleep(500);
		materialBasicCheckPage=new BasePage(driver, "materialBasicCheckPage");
		materialBasicCheckPage.click("X");
	}
	@Test(priority=5,description="删除物料基础数据")
	public void materialBasicDel() throws Exception {
		Thread.sleep(1000);
		materialBasicPage.materialBasicDel();
	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}
}
