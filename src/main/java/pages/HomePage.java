package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {
	
	
	

	public HomePage(WebDriver driver) {
		super(driver);
	}



	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	private WebElement threedots;
	
	@FindBy(xpath="//a[text()='About']")
	private WebElement about;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	private List<WebElement> itemElements; 
	
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']")
	private List<WebElement> addToCartButtons; 
		
	
	@FindBy(xpath="//div[@id='shopping_cart_container']")
	private WebElement addCartButton;


	public void setThreedots() {
		
		threedots.click();
	}



	public RequestDemoPage setAbout() {
		
		about.click();
		return new RequestDemoPage(driver);
		
	}
	
	public void highestItem() {
		
		List<Double> values = new ArrayList<>();

        // Extract and store the values
        for (WebElement itemElement : itemElements) {
            String valueWithSymbol = itemElement.getText();
            String valueWithoutSymbol = valueWithSymbol.replace("$", "").replaceAll("[^\\d.]", "");
            valueWithoutSymbol = valueWithoutSymbol.trim();

            if (!valueWithoutSymbol.isEmpty()) {
                double value = Double.parseDouble(valueWithoutSymbol);
                values.add(value);
            }
        }

        // Find the index of the highest value
     // Find the highest value
        double highestValue = Double.MIN_VALUE;
        int highestValueIndex = 0;
        int currentIndex = 0;

        for (double value : values) {
            if (value > highestValue) {
                highestValue = value;
                highestValueIndex = currentIndex;
            }
            currentIndex++;
        }

        // Click the "Add to Cart" button corresponding to the highest value
        addToCartButtons.get(highestValueIndex).click();

}
	
	
	public void cartButton() {
		
		addCartButton.click();
		
	}
	

	
}
