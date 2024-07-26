package WebDriverSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExecutorService {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://www.google.co.in/";

		JavascriptExecutor js;

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get(url);

		System.out.println(driver.getTitle());

		WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

		js.executeScript("arguments[0].scrollIntoView();", searchBox);

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", searchBox);

		Thread.sleep(1500);

		//fromInputBox.click();

		js.executeScript("arguments[0].click();", searchBox);

		js.executeScript("arguments[0].value='Naukri';", searchBox);

		Thread.sleep(3000);

		driver.close();

	}

}
