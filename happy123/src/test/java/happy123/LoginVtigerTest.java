package happy123;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginVtigerTest {
	@Test
	public void loginVtiger() {
		WebDriver driver=null;
		/*
		 * System.out.println(System.getProperty("browser"));
		 * System.out.println(System.getProperty("url"));
		 * System.out.println(System.getProperty("username"));
		 * System.out.println(System.getProperty("password"));
		 */
		String browser=System.getProperty("browser");
		String url=System.getProperty("url");
		String un=System.getProperty("username");
		String password=System.getProperty("password");
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
	else if (browser.equalsIgnoreCase("firefox")) 
	{
			WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();	
		}
		else if (browser.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
	}
		else {
		System.out.println("enter a valid browser");
	
		}
	driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		Actions act=new Actions(driver);
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
	}

}
