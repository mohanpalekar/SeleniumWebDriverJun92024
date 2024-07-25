package WebDriverSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitInSelenium {

	public static void main(String[] args) throws InterruptedException {

		String siteUrl = "https://demoqa.com/browser-windows";

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(siteUrl);

		System.out.println(driver.getTitle());
		
		FluentWait wait = new FluentWait(driver);
		
		wait.withTimeout(Duration.ofSeconds(15));
		
		wait.pollingEvery(Duration.ofSeconds(3));
		
		wait.ignoring(NoSuchElementException.class);
		
		WebElement cartIcon = (WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("windowButton"))));
		
		cartIcon.click();
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.quit();
		
		

	}

}
