package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amz_Cart_Quantity_Validation {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//a[@aria-label='ACs']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='a-autoid-1-announce']"))).click(); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='a-autoid-2-announce']"))).click(); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='a-autoid-3-announce']"))).click();
		Thread.sleep(5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='nav-cart-count']"))).click(); 
		String quantity = driver.findElement(By.xpath("//div[starts-with(@id, 'sc-active-')]//span[@data-a-selector='value']")).getText();
		System.out.println(quantity);
		
		
	}

}
