package testproject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.session.FirefoxFilter;
import org.openqa.selenium.support.ui.Select;


public class Test {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		WebDriver driver ;
		
		System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		System.out.println("hi");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("sadhasivaam@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Adhvik@123");
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
		
		driver.findElement(By.xpath("//div[@id='center_column']/div/div/ul/li[3]/a/span")).click();
		driver.findElement(By.xpath("//div[@id='center_column']/div/a/span")).click();
		driver.findElement(By.id("company")).sendKeys("fidelity");
		driver.findElement(By.id("address1")).sendKeys("taramani");
		driver.findElement(By.id("address2")).sendKeys("omr");
		driver.findElement(By.id("city")).sendKeys("chennai");
		
		Select sel = new Select(driver.findElement(By.id("id_state")));
		sel.selectByVisibleText("Alabama");
		
		driver.findElement(By.id("postcode")).sendKeys("34343");
		
		Select sele = new Select(driver.findElement(By.id("id_country")));
		sele.selectByVisibleText("United States");
		
		driver.findElement(By.id("phone")).sendKeys("897-987-8755");
		driver.findElement(By.id("other")).sendKeys("sample test");
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("rock1 address");
		driver.findElement(By.id("submitAddress")).click();
		
		driver.findElement(By.id("search_query_top")).sendKeys("shirt");
		driver.findElement(By.name("submit_search")).click();
		
		WebElement pageelement = driver.findElement(By.cssSelector(".top-pagination-content > .product-count"));
		js.executeScript("arguments[0].scrollIntoView()", pageelement);
		
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector(".right-block"));
		action.moveToElement(ele).perform();
		
		driver.findElement(By.cssSelector(".ajax_add_to_cart_button > span")).click();
		
		
		Robot robot = new Robot();
		robot.mouseMove(504, 344);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		
		
		driver.findElement(By.cssSelector(".button-medium:nth-child(2) > span")).click();
		
		WebElement downcheckout1 = driver.findElement(By.cssSelector(".standard-checkout > span"));
		js.executeScript("arguments[0].scrollIntoView();", downcheckout1);
		
		driver.findElement(By.cssSelector(".standard-checkout > span")).click();
		
		WebElement downcheckout2 = driver.findElement(By.cssSelector(".button:nth-child(4) > span"));
		js.executeScript("arguments[0].scrollIntoView();", downcheckout2);
		
		driver.findElement(By.cssSelector(".button:nth-child(4) > span")).click();
		
		
		WebElement downcheckout3 = driver.findElement(By.id("cgv"));
		js.executeScript("arguments[0].scrollIntoView();", downcheckout3);
		
		driver.findElement(By.id("cgv")).click();
		
		driver.findElement(By.cssSelector(".standard-checkout > span")).click();
		
		driver.findElement(By.cssSelector(".account > span")).click();
		
		driver.findElement(By.xpath("//div[@id='center_column']/div/div/ul/li/a/span")).click();
		
		Date date = new Date();
		Timestamp tmp = new Timestamp(date.getTime());
		String time = tmp.toString();
		time = time.replace(" ", "_");
		time = time.replace(":", "_");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(".\\screenshot\\snapshot" + time + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.linkText("Sign out")).click();
	}

}
