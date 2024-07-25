package WebDriverSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits_Explicit {

	public static void main(String[] args) {
		
		String siteUrl = "https://www.amazon.in/";

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(siteUrl);
		
		System.out.println(driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("nav-cart"))));
		
		cartIcon.click();
		
		System.out.println(driver.getTitle());
		
		driver.close();
	}

}
