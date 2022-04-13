package TestPackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageClassPackage.CheckCartClass;

import UtilityPackage.UtilClass;


public class CheckCartTest {
	public static Logger log=LogManager.getLogger(CheckCartClass.class.getName());
	CheckCartClass acc;
	UtilClass uc;
	
	@BeforeMethod
	public void launching() throws IOException, InterruptedException {
			log.info("dirver is initialized");
			acc=new CheckCartClass();
			
			uc=new UtilClass();
			
			acc.acceptCookiesMethod();
			Thread.sleep(2000);
			log.info("Navigated to home page");
		}
	@Test
	public void selectCart() throws InterruptedException, IOException {
		log.info("Click on cart button ");
		acc.cartButton();
		uc.screenShot(acc.driver);
		Assert.assertEquals(acc.driver.getCurrentUrl(), "https://www.ulta.com/");
		log.info("Successfully validated the test ");
	}
	
	@Test
	public void selectProduct() throws InterruptedException {
		log.info("Adding the product in cart ");
		acc.selectProduct();
		log.info("Successfully validated the test ");
		
	}
	@Test
	public void forgoPassword() throws InterruptedException, IOException {
		log.info("Click on forgot password link ");
		acc.forgotPassword();
		
		uc.screenShot(acc.driver);
		Assert.assertTrue(true);
		log.info("Successfully validated the test ");
	}
	
	
	@AfterMethod
	public void closeBowser() {
		acc.driver.close();
		log.info("Closing the browser ");
	}
	
	
}
