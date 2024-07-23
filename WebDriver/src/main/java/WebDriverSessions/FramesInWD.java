package WebDriverSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesInWD {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame";

		JavascriptExecutor js;

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get(url);

		System.out.println(driver.getTitle());
		
		WebElement Trainings = driver.findElement(By.xpath("//a[@title='Trainings']"));
		
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", Trainings);
		
		Trainings.click();
		
		Thread.sleep(3500);
		
		driver.close();
	}

}
