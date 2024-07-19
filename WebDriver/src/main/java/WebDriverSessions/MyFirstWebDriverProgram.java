package WebDriverSessions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MyFirstWebDriverProgram {

	public static void main(String[] args) throws InterruptedException {

		//Create an object of WebDriver	
		WebDriver driver;

		//Setup ChromeDriver from WebDriverManager
		WebDriverManager.chromedriver().setup();

		//Launch a ChromeDriver
		driver = new ChromeDriver();

		//maximize the window
		driver.manage().window().maximize();

		//timeOut
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//set resolution
		//driver.manage().window().setSize(new Dimension(1000, 600));

		//Open the url
		String siteUrl = "https://www.booking.com/";
		driver.get(siteUrl);


		//print the url
		System.out.println("CurrentUrl : "+driver.getCurrentUrl());

		String currentUrl = driver.getCurrentUrl();

		//		if(currentUrl.contains("booking1")) {
		//			System.out.println("True");
		//		}else {
		//			System.out.println("False");
		//		}

		Assert.assertEquals(currentUrl, "https://www.booking.com/");

		Assert.assertTrue(currentUrl.contains("booking"));

		Assert.assertTrue("PASS", currentUrl.contains("booking"));
		//print the page Title
		System.out.println("Title is : "+driver.getTitle());



		//minimize the window
		//	driver.manage().window().minimize();

		//crossPopUp XPath
		WebElement crossPopUp = driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
		crossPopUp.click();

		//find an element
		WebElement registerButton = driver.findElement(By.linkText("Register"));

		//perform click action
		registerButton.click();

		//print the page Title
		System.out.println("URL of Register Page is : "+driver.getCurrentUrl());

		driver.navigate().back();

		driver.navigate().forward();

		driver.navigate().to("https://www.google.co.in");

		WebElement googleSearchBox = driver.findElement(By.name("q"));

		googleSearchBox.sendKeys("Amazon");

		googleSearchBox.clear();

		googleSearchBox.sendKeys("Flipkart");
		
		googleSearchBox.sendKeys(Keys.ENTER);

		//		List<WebElement> googleSearchButton = driver.findElements(By.xpath("//input[@aria-label='Google Search']"));
		//		
		//		for( WebElement element : googleSearchButton ) {
		//			if(element.isDisplayed()) {
		//				element.click();
		//			}
		//		}

		Thread.sleep(5000);

		//close the session
		driver.close();


	}

}
