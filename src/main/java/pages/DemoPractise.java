package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DemoPractise {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		//entering username
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		//entering password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		//clicking login button
		//login-button
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Thread.sleep(3000);
		//clicking leftside 3lines button
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		//clicking about button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='About']")).click();
		
		String expectedTitle=driver.getCurrentUrl();
		String actualTitle="https://saucelabs.com/";
		Assert.assertEquals(expectedTitle, actualTitle);
		
		driver.navigate().back();
		String currentTitle=driver.getCurrentUrl();
		Assert.assertEquals(currentTitle, "https://www.saucedemo.com/inventory.html");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='react-burger-cross-btn']")).click();
		
		Thread.sleep(2000);
		
		
		List<WebElement> itemElements =driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
		int highestValue = Integer.MIN_VALUE;
		WebElement highestItemElement =null;
		
		for(WebElement itemElement:itemElements) {
			
			String valueWithSymbol=itemElement.getText();
			String valueWithoutSymbol=valueWithSymbol.replace("$", "").replaceAll("[^\\d.]", "");
			valueWithoutSymbol=valueWithoutSymbol.trim();
//			int value=Integer.parseInt(valueWithoutSymbol);
			
			
			if(!valueWithoutSymbol.isEmpty()) {
				
				double value=Double.parseDouble(valueWithoutSymbol);
				
				if(value>highestValue) {
				highestValue=(int) value;
				highestItemElement=itemElement;
				
			}
		}
			highestItemElement.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
			break;
			

	}
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
		String cartTitle=driver.getTitle();
		
		Assert.assertEquals(cartTitle, "Swag Labs");
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		
		String checkOutpage=driver.getTitle();
		Assert.assertEquals(checkOutpage, "Swag Labs");
		
		driver.findElement(By.id("first-name")).sendKeys("raju");
		driver.findElement(By.id("last-name")).sendKeys("pedda");
		driver.findElement(By.id("postal-code")).sendKeys("515671");
		driver.findElement(By.id("continue")).click();
		
		List<WebElement>total=driver.findElements(By.xpath("//div[@class='summary_info_label summary_total_label']"));
		
		for(WebElement allprice:total) {
			String totalprice=allprice.getText();
			System.out.println(totalprice);
		}
		
	}

}
