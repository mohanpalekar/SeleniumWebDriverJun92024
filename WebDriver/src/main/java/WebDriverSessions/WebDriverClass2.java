package WebDriverSessions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass2 {

	public static void main(String[] args) throws InterruptedException {

		JavascriptExecutor js;

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.booking.com");

		System.out.println(driver.getTitle());

		Assert.assertTrue(driver.getTitle().contains("flights"));

		Thread.sleep(5000);

		try {
			WebElement crossPopUp = driver.findElement(By.xpath("//button[starts-with(@aria-label, 'Dismiss')]"));

			if(crossPopUp.isDisplayed()) {

				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", crossPopUp);
				Thread.sleep(1500);
				js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid green;');", crossPopUp);

				crossPopUp.click();
			}

		}catch(NoSuchElementException ex) {
			System.out.println("Exception Occured : "+ex.getMessage());	
		}

		WebElement rentalCarsOption = driver.findElement(By.id("cars"));

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", rentalCarsOption);
		Thread.sleep(1500);
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid green;');", rentalCarsOption);

		rentalCarsOption.click();

		WebElement attractionsOption = driver.findElement(By.xpath("//a[@data-decider-header='attractions']"));

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", attractionsOption);
		Thread.sleep(1500);
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid green;');", attractionsOption);

		attractionsOption.click();

		WebElement customerSupportOption = driver.findElement(By.xpath("//a[@aria-label='Customer support']"));

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", customerSupportOption);
		Thread.sleep(1500);
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid green;');", customerSupportOption);

		customerSupportOption.click();

		WebElement howCanWeHelpText = driver.findElement(By.xpath("//h2[text()='How can we help?']"));

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", howCanWeHelpText);
		Thread.sleep(1500);
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid green;');", howCanWeHelpText);

		System.out.println(howCanWeHelpText.getText());

		Thread.sleep(5000);

		WebElement ConfirmationNumber = driver.findElement(By.xpath("//span[text()='Confirmation number']"));

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ConfirmationNumber);
		Thread.sleep(1500);
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid green;');", ConfirmationNumber);

		System.out.println(ConfirmationNumber.getText());

		Thread.sleep(5000);

		WebElement emailAddressField = driver.findElement(By.xpath("//span[text()='Email address']"));

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", emailAddressField);
		Thread.sleep(1500);
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid green;');", emailAddressField);

		System.out.println(emailAddressField.getText());

		Thread.sleep(5000);

		WebElement messageField = driver.findElement(By.xpath("//span[text()='Your message']"));

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", messageField);
		Thread.sleep(1500);
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid green;');", messageField);

		System.out.println(messageField.getText());

		Thread.sleep(5000);

		driver.close();

	}

}
