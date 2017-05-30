package ExtentReportTest.JamesA;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AmazonShopper {

	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	// pass scenario
	@Test(priority = 1, enabled = true)
	public void verifyHomePageTitle() {

		// where to create the report file
		report = new ExtentReports(
				"C:\\Users\\Administrator\\Desktop\\Java\\Test\\automationreport.html",
				true);
		// init/start the test
		test = report.startTest("Verify application Title");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\SeleniumFiles\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().window().maximize();
		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		driver.get("https://www.amazon.co.uk/");
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals(
				"Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more")) {
			// report the test as a pass
			test.log(LogStatus.PASS, "verify Title of the page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
		}
		report.endTest(test);
		report.flush();
	}
	// Fail scenario
	// make this fail to see the screenshot output
	@Test(priority = 2, enabled = true)
	public void verifyLogo() throws IOException {
		test = report.startTest("Sign into Amazon");
		driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[2]")).click();
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		final String UserName = "jamesawoba@gmail.com";
		final String PassWord = "stdstd123";
		
		
		WebElement usernameBox = driver.findElement(By.id("ap_email"));
		WebElement passwordBox = driver.findElement(By.id("ap_password"));
		usernameBox.sendKeys(UserName);
		passwordBox.sendKeys(PassWord);
		driver.findElement(By.id("signInSubmit")).click();
		
		String title3 = driver.getTitle();
		System.out.println(title3);
		
		String Message1 = driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']/span")).getText();
		if(Message1.equals(
				"Hello, Jam")){
			// report the test as a pass
			test.log(LogStatus.PASS, "verify Title of the page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(
					"C:\\Users\\Administrator\\Desktop\\Java\\Test\\screenshot\\img.jpg"));
			String image = test.addScreenCapture(
					"C:\\Users\\Administrator\\Desktop\\Java\\Test\\screenshot\\img.jpg");
			test.log(LogStatus.FAIL, "verify logo of the application", image);
		}
		report.endTest(test);
		report.flush();
		// driver.quit();
	}
}