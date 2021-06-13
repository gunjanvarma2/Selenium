package extentreportPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extenreportClass {

	public static void main(String[] args) {
		
ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
		
		// create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gunjan.Verma\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		test.log(Status.INFO, "Starting test");
		
		driver.get("http://www.google.com");
		test.pass("Website opened");
		//test.log(Status.INFO, "This step shows usage of log - website opened");

		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("abcd");
		test.pass("Keyword entered");
		//test.log(Status.INFO, "Entered keyword");
		
		//driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
		//driver.findElement(By.name("btnk")).click();
		WebElement button = driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]"));
		button.sendKeys(Keys.RETURN);
		test.pass("Clicked on search");
		
		driver.close();
		test.pass("Browser closed");
		
		test.info("Test case completed");
		
		System.out.println("projectPath is "+projectPath);
		extent.flush();
		// TODO Auto-generated method stub

	}

}
