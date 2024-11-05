package seleniumWebComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	WebDriver driver = new ChromeDriver();
	public String url = "https://jqueryui.com/datepicker/";

	public void launch() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void dataPicker() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		WebElement date = driver.findElement(By.xpath("//input[@class='hasDatepicker']"));
		date.click();
		driver.findElement(By.xpath("//a[@title='Next']")).click();
		driver.findElement(By.xpath("//a[@data-date='22']")).click();
		//Thread.sleep(5000);
		System.out.println("The Selected Date is :" + date.getAttribute("value"));
		driver.close();
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		Frames frames = new Frames();
		frames.launch();
		frames.dataPicker();
	}

}
