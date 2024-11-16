package training;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerts1 {

	WebDriver driver = new FirefoxDriver();

	public void launch() {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
	}

	public void simpleAlert() throws InterruptedException {

		WebElement element = driver.findElement(By.id("alertButton"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		System.out.println("SIMPLE:" + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	public void promptAlert() {
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys("DeepikaAshokan");
		System.out.println("PROMPT:" + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	public void confirmationAlert() {
		driver.findElement(By.id("promtButton")).click();
		System.out.println("CONFIRMATION:" + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

	}
	public void exit() {
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {

		Alerts1 alt = new Alerts1();
		alt.launch();
		alt.simpleAlert();
		alt.promptAlert();
		alt.confirmationAlert();
		alt.exit();

	}

}
