package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	public ExcelReader excel = new ExcelReader(".//src//test//resources//excel//testdata.xlsx");
	
	
	
	public void setUp(String browser) {
		
		prop = new Properties();
		
		try {
			fis = new FileInputStream("C:\\Users\\venka\\interview\\Demo\\src\\test\\java\\properties\\config.Properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String browser=prop.getProperty("browser");

		if(browser.equals("chrome")) {
			
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			//
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "D:\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver(options);
			
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
