package seleniumWebComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DragAndDrop {

	public String BaseUrl = "https://jqueryui.com/droppable/";

	WebDriver driver = new ChromeDriver();

	public void launch() {

		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	public void dragAndDrop() {
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@class,'demo-frame')]"));
		driver.switchTo().frame(frame);
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		System.out.println(
				"The color of the target element BEFORE Drag and Drop operation is :" + target.getCssValue("color"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
		System.out.println(
				"The color of the target element AFTER Drag and Drop operation is :" + target.getCssValue("color"));
		System.out.println("Text of the target element AFTER Drag and Drop operation is :" + target.getText());
		driver.close();

	}

	public static void main(String[] args) {

		DragAndDrop dd = new DragAndDrop();
		dd.launch();
		dd.dragAndDrop();

	}

}
