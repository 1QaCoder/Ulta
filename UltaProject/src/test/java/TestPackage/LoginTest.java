package TestPackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageClassPackage.LoginPage;
//import PageClassPackage.MenubarPage;
import UtilityPackage.UtilClass;

public class LoginTest {
//	MenubarPage mp;
	UtilClass uc;
	LoginPage lp;
	public static Logger log=LogManager.getLogger(MenubarTest.class.getName());
	@BeforeMethod
	public void launching() throws IOException, InterruptedException {
		// mp=new MenubarPage();
		log.info("Opening the Browser and Launching the application");
		 uc=new UtilClass();
		 lp=new LoginPage();
		
		}
	@Test(priority=1)
	public void invaliCredentials() throws IOException, InterruptedException {
		Thread.sleep(3000);
		log.info("Accepting cookies");
		lp.acceptCookiesMethod();
		log.info("Retrieving invalid login credentials from data file");
		lp.fromExcelDataInvalidCredential();
		String msg=lp.driver.findElement(By.xpath("//span[text()='The email address or password you entered is incorrect. Please try again.']")).getText();
		Assert.assertEquals(msg,"The email address or password you entered is incorrect. Please try again.");
		log.info("Successfully validated the test ");
	}
	
	@Test(description="Used Valid credentials from config.property")
	public void validCredentilasFromProp() throws InterruptedException {
		Thread.sleep(3000);
		lp.acceptCookiesMethod();
		log.info("Accepting cookies");
		lp.loginCredentialsFromPropFile();
		log.info("Retrieving valid login credentials from config.property file");
		Thread.sleep(2000);
	//	lp.windowHandle(lp.driver);
//		Assert.assertEquals(lp.driver.getCurrentUrl(),"https://www.ulta.com/");
		String name=lp.driver.findElement(By.xpath("//div[text()='Hi, Sharvari']")).getText();	
		Assert.assertEquals(name,"Hi, Sharvari" );
		log.info("Successfully validated the test ");
	}
	
	
	@Test(enabled=false)
	public void login() {
		log.info("Skipping the test ");
		
	}
	
	@Test(groups= {"SkipTest"})
	public void login1() {
		
	}
	
	@AfterMethod
	public void closeBowser() {
		lp.driver.close();
		log.info("Closing the browser ");
	}
	
		

}
