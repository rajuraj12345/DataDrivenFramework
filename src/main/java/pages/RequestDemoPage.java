package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;

public class RequestDemoPage extends BasePage {

	public RequestDemoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void naviate() {
		
		driver.navigate().back();
	}

}
