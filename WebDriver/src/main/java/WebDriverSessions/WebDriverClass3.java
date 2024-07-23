package WebDriverSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass3 {


	public static void main(String[] args) throws InterruptedException {

		String url = "https://demo.guru99.com/test/newtours/register.php";

		JavascriptExecutor js;

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get(url);

		System.out.println(driver.getTitle());

		WebElement selectCountryDD = driver.findElement(By.name("country"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", selectCountryDD);

		Select countryDD = new Select(selectCountryDD);

		countryDD.selectByVisibleText("INDIA");

		//		js.executeScript("arguments[0].scrollIntoView(true);", selectValueDropDown);
		//
		//		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", selectValueDropDown);
		//		Thread.sleep(1500);
		//		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid green;');", selectValueDropDown);
		//
		//		selectValueDropDown.click();

		Thread.sleep(3500);

		driver.close();
	}

}
