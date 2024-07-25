package WebDriverSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsInSelenium_ImplicitWait {

	public static void main(String[] args) {

		String siteUrl = "https://www.amazon.in/";

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.manage().window().maximize();

		driver.get(siteUrl);

		System.out.println(driver.getTitle());

		WebElement cartIcon = null;

		long startTime = System.currentTimeMillis();
		try {
			cartIcon = driver.findElement(By.id("nav-cart"));
		}catch(Exception ex) {
			System.out.println("Exception Occurred");
		}

		long endTime = System.currentTimeMillis();

		System.out.println("Time is : "+(endTime-startTime)+"ms");

		cartIcon.click();

		System.out.println(driver.getTitle());

		driver.close();

	}

}
