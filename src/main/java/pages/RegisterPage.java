package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import action.ActionClass;

public class RegisterPage extends ActionClass {
	private WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	private WebElement registerLink;

	@FindBy(css = "#firstName")
	private WebElement firstNameField;

	@FindBy(id = "lastName")
	private WebElement lastNameField;

	@FindBy(css = "#userEmail")
	private WebElement emailField;

	@FindBy(xpath = "//input[@id='userMobile']")
	private WebElement phoneNumberField;

	@FindBy(xpath = "//select[@formcontrolname='occupation']")
	private WebElement occupationDropdown;

	@FindBy(xpath = "//input[@value='Male']")
	private WebElement genderMaleRadioButton;

	@FindBy(xpath = "//input[@value='Female']")
	private WebElement genderFemaleRadioButton;

	@FindBy(css = "#userPassword")
	private WebElement passwordField;

	@FindBy(css = "#confirmPassword")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement ageCheckbox;

	@FindBy(xpath = "//input[@id='login']")
	private WebElement registerButton;
	
	
	
	@FindBy(xpath="//h1[@class='headcolor']")
	private WebElement accountCreationMsg;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterRegisterInfo(String[] userData) {
		String firstName = userData[0];
	    String lastName = userData[1];
	    String email = userData[2];
	    String phoneNumber = userData[3];
	    String occupation = userData[4];
	    String gender = userData[5];
	    String password = userData[6];
//	    String confirmPassword = userData[7];

		registerLink.click();
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		
		phoneNumberField.sendKeys(phoneNumber);

		Select select = new Select(occupationDropdown);
		select.selectByVisibleText(occupation);

		if (gender.equalsIgnoreCase("male")) {
			genderMaleRadioButton.click();
		} else if (gender.equalsIgnoreCase("female")) {
			genderFemaleRadioButton.click();
		}
		
	    passwordField.sendKeys(password);
	    confirmPasswordField.sendKeys(password);
		
		ageCheckbox.click();
		
		registerButton.click();
		
	    boolean status = waitForElement(accountCreationMsg, 10);
	    
	    if(status) {
	      String actualMsg = accountCreationMsg.getText().trim();
	      if(actualMsg.equalsIgnoreCase("Account Created Successfully")) {
	    	  System.out.println("Account Created Successful");
	      }else {
	          System.out.println("Account Creation Failed");
	      }
	    }
	    

	}

}
