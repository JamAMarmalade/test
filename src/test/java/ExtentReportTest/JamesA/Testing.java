package ExtentReportTest.JamesA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testing {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Administrator\\Downloads\\SeleniumFiles\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.co.uk/");
		String title1 = driver.getTitle();
		System.out.println(title1);
		
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
		if (Message1.equals(
				"Hello, Jam")){
			System.out.println("yay");
			driver.findElement(By.xpath(".//*[@id='hud-customer-image']/a/div/div")).click();
			}
		else{
			System.out.println("fail");
		}
		
		
		driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[1]")).click();
		
		String title4 = driver.getTitle();
		System.out.println(title4);
		
		driver.findElement(By.xpath(".//*[@id='nav-item-signout']/span")).click();
	
	}
}
//use mozilla for testing and chrome for running
//download selenium ide, eclipse (testng, egit), and (firebug, firepath) for mozilla