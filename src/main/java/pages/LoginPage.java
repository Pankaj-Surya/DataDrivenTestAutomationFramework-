package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.ActionClass;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(css = "#userEmail")
	private WebElement emailField;
	
	@FindBy(css = "#userPassword")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@id='login']")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterLoginDetails(String[] userData) throws Exception {
		String email = userData[0];
		String ps = userData[1];
	    ActionClass action = new ActionClass();
	   
	    action.implicitWait(15); // Wait for elements to be interactable
		emailField.sendKeys(email);
		passwordField.sendKeys(ps);
		loginButton.click();
		Thread.sleep(2000);
		String currentURL = driver.getCurrentUrl();
		
		System.out.println(currentURL);
		String expectedURL = "https://rahulshettyacademy.com/client/dashboard/dash";
		if(currentURL.equals(expectedURL)) {
			System.out.println("Login Success");
		}else {
			System.out.println("Login Failed");
		}
	}
	
	
	
	
}
