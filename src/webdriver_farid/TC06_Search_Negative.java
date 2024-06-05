package webdriver_farid;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.interactions.Actions;	
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TC06_Search_Negative {
	public static void main(String[] args) throws InterruptedException {
			
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp=new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		
		WebDriver driver=new ChromeDriver(options);
		  
		// System Property for Chrome Driver   
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Farid\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");  
	                
	        
			
		
			
	    
			
			//Launch Website
			driver.navigate().to("https://www.agoda.com/");
			
			//Maximize the Browser
			driver.manage().window().maximize();
			
			Actions actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			//Search
			Thread.sleep(8000);
			
			actions.moveToElement(driver.findElement(By.className("ab-close-button"))).click().build().perform();
			
			driver.findElement(By.xpath("//*[@id=\"textInput\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"textInput\"]")).sendKeys("Pyongyang, North Korea");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,10000)");
			
			Thread.sleep(3000);
			actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/button"))).click().build().perform();
			
			String location = driver.findElement(By.className("SearchBoxTextDescription__title")).getText();
			
			if(!location.equals("Pyongyang, North Korea")) 
			{
				System.out.println("Target location has been changed into:");
				System.out.println(location);
				System.out.println("No hotels found in Pyongyang, North Korea.");
			}
			
		
			
			//Close and Quit the Browser
			driver.close();
			driver.quit();
		}
}
