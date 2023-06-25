package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> itemElements = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));

        // ArrayList to store the extracted values
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

}
