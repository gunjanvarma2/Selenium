package extentReportTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReportTestNG {
	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	WebDriver driver =null;
	
	
	@BeforeTest
	public void setup() {
		
		 
		//String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gunjan.Verma\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@BeforeSuite
	public void setUP() {
		
		htmlReporter = new ExtentHtmlReporter("extent.html");
		
		// create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
       
		
	}
	
	@Test(priority=0)
	public void test1() throws Exception{
		 ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		 test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	      test.fail("Fail");
	        
	        // test with snapshot
	        test.addScreenCaptureFromPath("screenshot.png");
			}
	@Test(priority=1)
	public void test2() throws Exception{
		 ExtentTest test = extent.createTest("MySecondTest", "Sample description");
		 test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	   test.pass("Google.com");
	        
	        // test with snapshot
	        test.addScreenCaptureFromPath("screenshot.png");
			}
	
	@AfterTest
	public void setclose() {
		driver.close();
		driver.quit();
		
	}
	@AfterSuite
	public void tearDown() {
		extent.flush();
		
	}

}
