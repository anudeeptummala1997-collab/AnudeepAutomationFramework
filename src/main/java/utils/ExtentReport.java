package utils;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	private static ExtentReports extent;
	 private static ExtentTest test;
	 public static String reportPath;
	 
	 public static ExtentReports getReportInstance() {
		 if(extent==null) {
			 String timestamp=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			  reportPath="reports/ExtentReport_"+timestamp+".html";
			 ExtentSparkReporter report=new ExtentSparkReporter(reportPath);
			 report.config().setDocumentTitle("Automation Reprot");
			 report.config().setReportName("Test Exexution Report");
			 extent =new ExtentReports();
			 extent.attachReporter(report);
		 }
		 return extent;
	 }
    public static ExtentTest createTest(String testname) {
    	test=getReportInstance().createTest(testname);
    	return test;
    }
    
    public static String captureScreenShot(WebDriver driver,String screenshotname) {
    	try {
    			
    		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		String path=System.getenv("user.dir")+"/screenshots/"+screenshotname+".png";
    		FileUtils.copyFile(src,new File(path));
    		return path;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
}
