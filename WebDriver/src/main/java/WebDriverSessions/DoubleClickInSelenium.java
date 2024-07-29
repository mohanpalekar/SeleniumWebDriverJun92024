package WebDriverSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickInSelenium {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://codepen.io/blink172/pen/vERyxK";

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(url);

		System.out.println(driver.getCurrentUrl());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.switchTo().frame("result");

		WebElement doubleClickOnElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='click']")));
		
		WebElement resetButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='reset']")));

		
		Actions action = new Actions(driver);
		
		action.scrollToElement(resetButton).perform();
		
		action.doubleClick(doubleClickOnElement).perform();
		
		action.doubleClick(doubleClickOnElement).perform();
		
		action.doubleClick(doubleClickOnElement).perform();
		
		action.contextClick(doubleClickOnElement).perform();
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
