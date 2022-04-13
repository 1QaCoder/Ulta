package TestPackage;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;


import PageClassPackage.MenubarPage;
import UtilityPackage.UtilClass;

public class MenubarTest{
	
	MenubarPage mp;
	UtilClass uc;
	public static Logger log=LogManager.getLogger(MenubarTest.class.getName());
	@BeforeMethod
	public void launching() throws IOException {
		log.info("Open the Home Page");
	 mp=new MenubarPage();
	 uc=new UtilClass();
	 mp.driver.manage().deleteAllCookies();
	 

	}
	
	@Test
	public void signUp() throws IOException, InterruptedException {
		log.info("Click on SignUp Tab Tab from HomePage");
		mp.signUpTag();
		Thread.sleep(2000);
		System.out.println(mp.driver.getCurrentUrl());
		Assert.assertEquals("https://pages.exacttarget.com/ulta-email-signup/",mp.driver.getCurrentUrl());
		log.info("Successfully validated the test ");
	}
	
	@Test
	public void findStore() throws IOException, InterruptedException {
	//	Thread.sleep(2000);
		log.info("Click on FindStore Tab from HomePage");
		mp.findStoreTag();
		System.out.println(mp.driver.getCurrentUrl());
		uc.screenShot(mp.driver);
		Assert.assertEquals("https://www.ulta.com/stores",mp.driver.getCurrentUrl());
		log.info("Successfully validated the test ");
	}
	
	@Test(timeOut=5000)
	public void signIn() throws IOException, InterruptedException {
		log.info("Click on Sign In Tab from HomePage");
		mp.signInTag();	
		
		WebElement text=mp.driver.findElement(By.linkText("Forgot Password?"));
		
		Assert.assertEquals(text.getText(),"Forgot Password?");
		log.info("Successfully validated the test ");
	}
	
	@Test(dependsOnMethods="findStore")
	public void giftcards() throws IOException, InterruptedException {
	//	Thread.sleep(2000);
		log.info("Click on GiftCard Tab from HomePage");
		mp.giftCardTag();
		System.out.println(mp.driver.getCurrentUrl());
		Assert.assertEquals("https://www.ulta.com/giftcards",mp.driver.getCurrentUrl());
		log.info("Successfully validated the test ");
	}
	
	
	
	@AfterMethod
	public void closeBowser() {
		mp.driver.close();
		log.info("Closing the browser ");
	}
}
