package WebDriverSessions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowsInSelenium {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://demoqa.com/browser-windows";

		JavascriptExecutor js;

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get(url);

		System.out.println(driver.getTitle());

		WebElement newTabButton = driver.findElement(By.id("tabButton"));

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", newTabButton);

		newTabButton.click();
		newTabButton.click();
		newTabButton.click();
		newTabButton.click();
		newTabButton.click();

		String parentHandle = driver.getWindowHandle();

		Set<String> allhandles = driver.getWindowHandles();

		System.out.println("Parent Handle : "+parentHandle);

		allhandles.forEach( x -> System.out.println("Window Handle : "+x));

		allhandles.forEach( x -> System.out.println("Window Handle Length : "+x.length()));

		for(String handles : allhandles) {
			if(!handles.equals(parentHandle)) {

				System.out.println("New Window is --> ");

				driver.switchTo().window(handles);

				System.out.println("Title is : "+driver.getTitle());
				System.out.println("CurrentUrl is : "+driver.getCurrentUrl());

				WebElement headingText = driver.findElement(By.id("sampleHeading"));

				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", headingText);

				Thread.sleep(1500);
				System.out.println(headingText.getText());

				driver.close();
			}


		}

		driver.switchTo().window(parentHandle);

		driver.close();
		//driver.quit();


	}

}
