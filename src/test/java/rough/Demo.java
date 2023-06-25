package rough;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://google.com");
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("testng");
		Thread.sleep(2000);
		
//		List<WebElement>list=driver.findElements(By.xpath("//div[@role='presentation']/div/div"));
//		
//		for(WebElement element:list) {
//			
////			String alltext=element.getText();
////			System.out.println(alltext);
			List<WebElement>allelemensts=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			
			for(WebElement allelement:allelemensts) {
				String selectedlist=allelement.getText();
				System.out.println(selectedlist);
				if(selectedlist.equals("testng maven dependency")) {
					allelement.click();
					break;
				}
			}
			
		}
		
		
	}

//}
