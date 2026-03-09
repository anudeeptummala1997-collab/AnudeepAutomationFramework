package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.EmailUtil;
import utils.ExtentReport;
import utils.Log;

public class BaseTest {
	
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	
	
    @BeforeMethod
    public void setup() {
    	
    	 Log.info("Starting Webdriver...");
    	driver=new ChromeDriver();
    	Log.info("Navigating to url...");
    	driver.get("https://admin-demo.nopcommerce.com/login");
    	driver.manage().window().maximize();
    }
    @BeforeSuite
    public void setupReport() {
    	extent=ExtentReport.getReportInstance();
    }
    @AfterSuite
    public void tearDownReport() {
    	extent.flush();
    	String reportPath=ExtentReport.reportPath;
    	EmailUtil.sendTestReport(reportPath);
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
    	
    	if(result.getStatus()==ITestResult.FAILURE) {
    		String screenshotpath=ExtentReport.captureScreenShot(driver, "LoginFailure");
    		test.fail("test Failed...", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
    		
    	}
    	if(driver!=null) {
    		Log.info("Closing browser...");
    		driver.quit();
    	}
    }
}
