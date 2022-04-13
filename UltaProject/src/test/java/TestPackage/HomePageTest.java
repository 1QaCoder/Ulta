package TestPackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageClassPackage.HomePageClass;


public class HomePageTest {
	
	HomePageClass hp;
	public static Logger log=LogManager.getLogger(MenubarTest.class.getName());
	@BeforeMethod
	public void launching() throws IOException, InterruptedException {
		// mp=new MenubarPage();
		log.info("Opening the Browser and Launching the application");
			hp=new HomePageClass();
			hp.acceptCookiesMethod();
			Thread.sleep(2000);
		}
	
	@Test
	public void logo() {
		log.info("Check logo");
		hp.checkLogo();
		Assert.assertTrue(true);
		log.info("Successfully validated the test ");
	}
	
	@Test
	public void search() throws InterruptedException {
		log.info("Entering values in the search bar ");
		hp.enterValuesToSearchField();
		Assert.assertTrue(true);
		log.info("Successfully validated the test ");
	}
	
	@Test
	public void navigator() {
		log.info("Click and Open naviagation tab ");
		hp.navigator();
		Assert.assertTrue(true);
		log.info("Successfully validated the test ");
	}
	

	@AfterMethod
	public void closeBowser() {
		hp.driver.close();
		log.info("Closing the browser ");
	}
	
		
	
}
