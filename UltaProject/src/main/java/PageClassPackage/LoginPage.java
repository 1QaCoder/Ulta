package PageClassPackage;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;
import UtilityPackage.UtilClass;

public class LoginPage extends BaseClass{
	UtilClass uc=new UtilClass();

	//public static Properties prop ;
	
	@FindBy(id="username")
	WebElement email ;
	@FindBy(xpath="//input[@id='password']")
	WebElement pass;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signInButton ;
	@FindBy(linkText="Sign In")
	WebElement signIn;
	@FindBy(xpath="//button[text()='Accept Cookies']")
	WebElement acceptCookies;
	
	public LoginPage() throws IOException, InterruptedException  {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public void acceptCookiesMethod() {
		acceptCookies.click();
	}
	public void loginCredentialsFromPropFile() throws InterruptedException {
		signIn.click();
		email.sendKeys(prop.getProperty("userName"));
		pass.sendKeys(prop.getProperty("password"));
		signInButton.click();
	}
	
	public void fromExcelDataInvalidCredential() throws IOException, InterruptedException {
		signIn.click();
		String [][]data=uc.getDataFromExcel();
		
		email.sendKeys(data[2][0]);
		pass.sendKeys(data[2][1]);
		signInButton.click();
		
	}

	
	
	
	
	
	
	
	
	
	
}
