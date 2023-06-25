package rough;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Apple {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple");
		Thread.sleep(2000);
		List<WebElement>list=driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
		
		for(WebElement element:list) {
			
			String alltext=element.getText();
			System.out.println(alltext);
			if(alltext.equals("apple earphones")) {
				element.click();
				break;
			}
		}
		
		
	}

}
