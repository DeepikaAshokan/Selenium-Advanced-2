package training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction1 {

	WebDriver driver = new FirefoxDriver();
	public String URL = "https://www.apple.com/";

	public void launch() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	}

	public void mouse() throws InterruptedException {
		WebElement mac = driver.findElement(By.xpath("//span[text()='Mac']"));
		WebElement ipad = driver.findElement(By.xpath("//span[text()='iPad']"));
		WebElement airpods = driver
				.findElement(By.xpath("//Span[text()='AirPods'][contains(@class,'globalnav-link-text')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mac).build().perform();
		Thread.sleep(3000);
		actions.moveToElement(airpods).build().perform();
		Thread.sleep(3000);
		actions.doubleClick(ipad).build().perform();
		Thread.sleep(3000);
		System.out.println("Current URL :" + driver.getTitle());
		WebElement shopipad = driver.findElement(By.xpath("//span[text()='Shop iPad'][@class='chapternav-label']"));
		actions.clickAndHold(shopipad).build().perform();
		driver.navigate().back();
		WebElement bag = driver.findElement(By.xpath("//a[@id='globalnav-menubutton-link-bag']"));
		actions.contextClick(bag).build().perform();
		WebElement aplewallet = driver.findElement(By.xpath("//h3/span[text()='Apple Wallet']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", aplewallet);

	}

	public void exit() {
		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		MouseAction1 ma = new MouseAction1();
		ma.launch();
		ma.mouse();
		ma.exit();

	}

}
