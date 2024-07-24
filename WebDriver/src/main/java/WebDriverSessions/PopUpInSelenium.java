package WebDriverSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUpInSelenium {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://demo.guru99.com/test/delete_customer.php";

		JavascriptExecutor js;

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get(url);

		System.out.println(driver.getTitle());
		
		WebElement customerID = driver.findElement(By.name("cusid"));
		
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", customerID);
		
		customerID.sendKeys("1234");
		
		customerID.sendKeys(Keys.ENTER);
		
		Alert alert = driver.switchTo().alert();
		
		Thread.sleep(3000);
		
		System.out.println("Alert Text : "+alert.getText());
		
		alert.accept();
		
		Thread.sleep(3000);
		
		System.out.println("First Alert was handled");
		
		alert.accept();
		
		System.out.println("Second Alert was handled");

		
		Thread.sleep(3000);
		
		driver.close();
		
		
	}

}
