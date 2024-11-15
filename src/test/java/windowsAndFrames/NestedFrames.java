package windowsAndFrames;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NestedFrames {

	WebDriver driver = new ChromeDriver();
	public String link = "https://the-internet.herokuapp.com/nested_frames";
	WebElement top, middle, left, right, bottom;
	List<WebElement> topframes;

	public void launch() {
		driver.get(link);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void topframe() {
		WebElement top = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(top);

		List<WebElement> topframes = driver.findElements(By.xpath("//frameset[@name='frameset-middle']/frame"));
		System.out.println("Number of frames on TOP: " + topframes.size());

		/***
		 * for (WebElement NumberofTopframes : topframes) {
		 * System.out.println(NumberofTopframes.getAttribute("name") + " " +
		 * NumberofTopframes.getSize()); }
		 ***/
	}

	public void pagetitle() {
		driver.switchTo().parentFrame();
		String url = driver.getCurrentUrl();
		String output = "frames";
		System.out.println("To Verify that the page title is Frames : " + url.contains(output));
		}
	

	public void leftframe() {
		WebElement left = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(left);
		String lefttext = driver.findElement(By.tagName("body")).getText();
		System.out.println("The text in the LEFT frame is : " + lefttext);
	}

	public void middleframe() {
		driver.switchTo().parentFrame();
		WebElement middle = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middle);
		String middletext = driver.findElement(By.id("content")).getText();
		System.out.println("The text in the MIDDLE frame is : " + middletext);
		driver.switchTo().frame(top);
	}

	public void rightframe() {
		driver.switchTo().parentFrame();
		WebElement right = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(right);
		String righttext = driver.findElement(By.tagName("body")).getText();
		System.out.println("The text in the RIGHT frame is : " + righttext);
	}

	public void bottomframe() {
		driver.switchTo().frame(top);
		WebElement bottom = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(bottom);
		String bottomtext = driver.findElement(By.tagName("body")).getText();
		System.out.println("The text in the BOTTOM frame is : " + bottomtext);
		driver.switchTo().frame(top);

	}

	public void close() {
		driver.close();
	}

	public static void main(String[] args) {
		NestedFrames nf = new NestedFrames();
		nf.launch();
		nf.topframe();
		nf.leftframe();
		nf.rightframe();
		nf.middleframe();
		nf.bottomframe();
		nf.pagetitle();
		nf.close();

	}

}
