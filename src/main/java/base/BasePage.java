package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public static WebDriver driver;

	public BasePage(WebDriver driver) {
		
		BasePage.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public static String currentURL() {
		
		return driver.getCurrentUrl();
	}
	
	
	
	
	

}
