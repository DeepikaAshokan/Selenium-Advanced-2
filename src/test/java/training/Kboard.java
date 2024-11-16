package training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Kboard {
	
	public String link = "https://www.facebook.com/";
	WebDriver driver = new EdgeDriver();
	Actions action = new Actions(driver);
	
	
	public void launch() {
		driver.get(link);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	}
	public void result() {
	WebElement email =	driver.findElement(By.id("email"));
	email.click();
	action.keyDown(Keys.SHIFT).sendKeys("deepikaashokan1912@gmail.com").keyUp(Keys.SHIFT).build().perform();
	action.sendKeys(Keys.TAB).sendKeys("9952325355").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
    action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
	}

	public void close () {
		driver.close();
		driver.quit();
	}
	public static void main(String[] args) {

		Kboard kb = new Kboard();
		kb.launch();
		kb.result();
		kb.close();
		
	}

}
