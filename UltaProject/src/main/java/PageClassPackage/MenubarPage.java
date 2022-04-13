package PageClassPackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;
import lombok.extern.log4j.Log4j;


public class MenubarPage extends BaseClass{

	public static Logger log=LogManager.getLogger(MenubarPage.class.getName());
	@FindBy(xpath="//a[@class='Anchor'][text()='Find a Store']")
	WebElement findStore ;
	
	@FindBy(linkText="Email & Text Signup")
	WebElement signUp;
	
	@FindBy(linkText="Sign In")
	WebElement signIn;
	
	@FindBy(xpath="//a[@target='_self'][text()='Gift Cards']")
	WebElement giftCards;
	
	@FindBy(xpath="//button[text()='Accept Cookies']")
	WebElement acceptCookies;
	
	public void acceptCookiesMethod() {
		acceptCookies.click();
	}
	
	 public MenubarPage() throws IOException {
		 super();
		 
		//log.info("Open the browser and web Application ");
		 PageFactory.initElements(driver, this);
		
	 }
	
	public void findStoreTag() {
	//	log.info("Open the Home Page");
	//	log.info("Click on FindStore Tab from HomePage");
		findStore.click();
	//	log.info("Closing the Browser");
		
	}
	
	public void signUpTag() {
		//log.info("Click on FindStore Tab from HomePage");
		signUp.click();
	//	log.info("Closing the Browser");
	}
	
	public void signInTag() throws InterruptedException {
		
		Thread.sleep(3000);
		signIn.click();
	}
	public void giftCardTag() {
		giftCards.click();
	}
	
	
	
	
}
