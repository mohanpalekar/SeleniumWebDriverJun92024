package WebDriverSessions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotInSelenium {

	public static void main(String[] args) throws InterruptedException, IOException {

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

		Thread.sleep(3000);
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File("target//Screenshot.png");
		
		FileUtils.copyFile(sourceFile, destinationFile);
		
		//		TakesScreenshot screenshot = (TakesScreenshot)driver;
		//		
		//		File scr = screenshot.getScreenshotAs(OutputType.FILE);
		//		
		//		File location = new File("/target/ScreenShot1.png");
		//		
		//		FileUtils.copyFile(scr, location);

		driver.close();
	}

}
