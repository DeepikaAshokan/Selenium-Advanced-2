package windowsAndFrames;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {
	WebDriver driver = new ChromeDriver();
	public String url = "https://the-internet.herokuapp.com/windows";
	public Set<String> allwindow = driver.getWindowHandles();
	String homewindow = driver.getWindowHandle();

	public void launch() {
		driver.get(url);
		driver.manage().window().maximize();
		homewindow = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("The Title  of the HOMEPAGE ---" + driver.getTitle() + "  " + homewindow);
	}

	public void switchWindow() {
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		allwindow = driver.getWindowHandles();
		
		/***for (String temp : allwindow) {
			System.out.println("All Window ---" + temp);
		}***/

		for (String temp : allwindow) {
			if (!temp.equals(homewindow)) {
				driver.switchTo().window(temp);
				String newwindow = driver.getWindowHandle();
				System.out.println("The Title  of the NEXTPAGE ---" + driver.getTitle() + "  " + newwindow);
				System.out.println("To Verify that the text \"New Window\" is present on the page --- "
						+ driver.findElement(By.xpath("//h3")).isDisplayed());
				driver.close();
			}
		}
	}

	public void activeWindow() {
		driver.switchTo().window(homewindow);
		String activepage = driver.getWindowHandle();
		System.out.println("The Title  of the ACTIVEPAGE ---" + driver.getTitle() + activepage);
		driver.quit();

	}

	public static void main(String[] args) {
		NewWindow window = new NewWindow();
		window.launch();
		window.switchWindow();
		window.activeWindow();
	}

}
