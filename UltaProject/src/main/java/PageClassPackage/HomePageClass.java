package PageClassPackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BasePackage.BaseClass;

public class HomePageClass extends BaseClass{

	String makeUpUrl;
	@FindBy(css="input[name='searchInput']")
	WebElement searchField;
	
	@FindBy(css="a[title='Ulta Beauty Logo']")
	WebElement logo;
	
	@FindBy(id="opennav")
	WebElement navigationBar;
	
	@FindBy(xpath="//button[text()='Accept Cookies']")
	WebElement acceptCookies;
	
	@FindBy(xpath="//ul[@role='listbox']")
	List<WebElement> products;
	
	@FindBy(xpath="//a[text()='Brands']")
	WebElement brands;
	@FindBy(xpath="//img[@alt='Dior']")
	WebElement dior;
	
	@FindBy(xpath="//button[@class='Button Button__icon']")
	WebElement searchButton;
	
	public HomePageClass() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void acceptCookiesMethod() {
		acceptCookies.click();
	}
	
	public void checkLogo() {
		
		logo.click();
		boolean logoIsPresent=logo.isSelected();
		System.out.println("logoIsPresent ="+logoIsPresent);
	}
	
	public void enterValuesToSearchField() throws InterruptedException {
		searchField.click();
		searchField.sendKeys("MakeUp");
		searchButton.click();
		Thread.sleep(2000);
		makeUpUrl=driver.getCurrentUrl();
		Assert.assertEquals(makeUpUrl,"https://www.ulta.com/shop/makeup");
	}
	
	public void navigator() {
		navigationBar.click();
		actionMethod(brands);
		dior.click();
		String d=driver.getCurrentUrl();
		Assert.assertEquals(d,"https://www.ulta.com/brand/dior");
		
		
	}
	
	
	
	
	
	
	
}
