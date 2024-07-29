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

public class ActionClassInSelenium {
	
	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://www.globalsqa.com/demo-site/draganddrop/";
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(url);
		
		System.out.println(driver.getCurrentUrl());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		
		driver.switchTo().frame(3);
		
		WebElement draggable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='High Tatras']/following-sibling::img")));
		//WebElement draggable = driver.findElement(By.xpath("//img[@id='drag1']"));
		
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", draggable);

		
		WebElement droppable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='trash']")));
		//WebElement droppable = driver.findElement(By.xpath("//div[@id='div1']"));
		
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", droppable);

		
		Actions action = new Actions(driver);
		
		//action.dragAndDrop(draggable, droppable).perform();
		
		action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
		
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
