package PageClassPackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BasePackage.BaseClass;

public class CheckCartClass extends BaseClass {

	@FindBy(xpath="//button[text()='Accept Cookies']")
	WebElement acceptCookies;
	
	@FindBy(xpath="//a[@title='Bag']")
	WebElement cartTag;
//	@FindBy(xpath="//button[@data-nav-description='Add To Bag']")
//	WebElement addToBag;
//	
//	@FindBy(xpath="img[src='https://images.ulta.com/is/image/Ulta/2551167?$lg$']")
//	WebElement iteam;
//	
//	@FindBy(linkText="VIEW BAG & CHECKOUT")
//	WebElement viewbagAndCheckout;
//	@FindBy(xpath="//button[@class='Button Button__primary Button--large Button--block']")
//	WebElement secureCheckout;

	@FindBy(css="label[for='emailAddress']")
	WebElement emailAdd;
	@FindBy(xpath="//button[text()='Email Me']")
	WebElement emailMeButton;
	@FindBy(linkText="Forgot Password?")
	WebElement forgotPassword;
	@FindBy(xpath="//div[@class='ConfirmPage__emailId']")
	WebElement checkEmailId;
	public CheckCartClass() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void acceptCookiesMethod() {
		acceptCookies.click();
	}

	public void cartButton() throws InterruptedException {
			
			Thread.sleep(3000);
			cartTag.click();
			System.out.println(driver.getCurrentUrl());
			
	}
	
	public void selectProduct() throws InterruptedException {
		cartButton();
		scrollPage();
		Thread.sleep(02000);

		Thread.sleep(02000);
		System.out.println(driver.getCurrentUrl());
	}
	
	public void forgotPassword() throws InterruptedException {
		cartButton();
		forgotPassword.click();
		Thread.sleep(2000);
		String email="sharvarimn@gmail.com";
		emailAdd.sendKeys("sharvarimn@gmail.com");
		Thread.sleep(4000);
		emailMeButton.click();
		String check=checkEmailId.getText();
		Thread.sleep(2000);
		Assert.assertEquals(check, email);
		
	}
}
