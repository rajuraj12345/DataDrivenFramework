package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id="first-name")
	private WebElement firstName;
	
	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(id="postal-code")
	private WebElement postalCode;
	
	@FindBy(id="continue")
	private WebElement continueButton;



	public void setFirstName(String fName) {
		
		firstName.sendKeys(fName);
	}



	public void setLastName(String lName) {
		
		lastName.sendKeys(lName);
		
	}


	public void setPostalCode(String pCode) {
		
		postalCode.sendKeys(pCode);
	}



	public void setContinueButton() {
		
		continueButton.click();
	}
	
	

	
}
