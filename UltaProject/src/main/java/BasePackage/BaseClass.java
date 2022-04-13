package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop ;
	public  WebDriver driver;
	public static Logger log;
	
	public BaseClass() throws IOException {
			
			prop=new Properties();
			 FileInputStream fin = new FileInputStream("C:\\Users\\Darsh\\eclipse-workspace\\HybridFramework\\src\\main\\java\\Config\\config.properties");
			
			prop.load(fin);
			String browserName=prop.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
			}
			else if(browserName.equalsIgnoreCase("edge")){
				WebDriverManager.edgedriver().setup();
			}
			else
			{
				WebDriverManager.firefoxdriver().setup();
			}
			
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String urlName=prop.getProperty("url");
			driver.get(urlName);
			
			System.setProperty("log4j.configurationFile", "resources/log4j.properties");
			log=LogManager.getLogger();
		} 
		
	public void windowHandle(WebDriver driver) {
			
			Set<String> windows=driver.getWindowHandles();
			Iterator<String> it=windows.iterator();
		//	String parentWindow=it.next();
		//	String childWindow=it.next();
			driver.switchTo().defaultContent();
		}
				
	public void actionMethod(WebElement act) {
		Actions a= new Actions(driver);
		a.moveToElement(act).build().perform();
		
		
	}
	
	public void scrollPage() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(900,700)", " ");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(900,700)", " ");
		
	}
	
	
	
	
	
}
