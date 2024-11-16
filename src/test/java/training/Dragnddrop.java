package training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dragnddrop {

	public String link = "https://artoftesting.com/samplesiteforselenium";
	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);

	public void launch() {
		driver.get(link);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	}
	
	public void Scroll() {
	
	WebElement scroll = driver.findElement(By.xpath("//button[text()='Generate Confirm Box']"));
	Actions action = new Actions(driver);
	action.scrollToElement(scroll).build().perform();
	}
	
	public void result() {
		WebElement source = driver.findElement(By.id("myImage"));
		WebElement target = driver.findElement(By.id("targetDiv"));
		action.dragAndDrop(source, target).build().perform();
	}
	public void close() {
		driver.close();
		driver.quit();
	}
	public static void main(String[] args) {
		Dragnddrop dd = new Dragnddrop();
		dd.launch();
		dd.Scroll();
		dd.result();
		dd.close();
	}

}
