package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtil;
import utils.ExtentReport;

public class LoginTest extends BaseTest {

	
	@DataProvider(name="logind")
	public Object[][] getLogindata() throws IOException{
		String filepath=System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtil.loadExcel(filepath, "Sheet1");
		int rowcount=ExcelUtil.getRowsCount();
		Object[][] data=new Object[rowcount-1][2];
		for(int i=1;i<rowcount;i++) {
			data[i-1][0]=ExcelUtil.getCellData(i, 0);
			data[i-1][1]=ExcelUtil.getCellData(i, 1);

		}
		ExcelUtil.closeExcel();
		return data;
	}
	
	@Test(dataProvider="logind")
	//@Test
	public void testValidLogin(String username,String password) {
		
		test=ExtentReport.createTest("Login Test");
		test.info("Navigating to Url");
		LoginPage loginpage=new LoginPage(driver);
		test.info("Entering the credentials..");
		loginpage.login(username,password);
	}
	//fpxr tkuk edeh nsyu app pasword
	//c8c44946ee57478eb0d2e753692e33cf jenkins password
}
