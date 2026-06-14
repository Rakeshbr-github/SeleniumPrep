package Live_Automation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExcelUtility; 

public class Flipkart_validation {

	public static void main(String[] args) throws InterruptedException {
			
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		try
		{
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
       WebElement  searchbox=driver.findElement(By.xpath("//input[contains(@placeholder,'Search for Products')]"));
      WebElement closebutton=driver.findElement(By.xpath("//span[@role='button' and @class='b3wTlE']"));
       if(closebutton.isDisplayed())
       {
    	   closebutton.click();
       }
		
       wait.until(ExpectedConditions.visibilityOf(searchbox));
       searchbox.sendKeys("Laptops");
       searchbox.sendKeys(Keys.ENTER);
       List<String> resultprodinfo=productInfo(driver);
//       for(String res:resultprodinfo)
//       {
//    	   
//    	   System.out.println(res);
//       }
       ExcelUtility.writeProductsToExcel(resultprodinfo);
       
       
       
		}
		
		
		
		
			
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		
		finally
		{
		    Thread.sleep(3000);
			driver.quit();
		}

		
	}
	   public static List<String> productInfo(WebDriver driver)
	   {
		   List<String> products=new ArrayList<>();
		   List<WebElement>  productname=driver.findElements(By.xpath("//div[@class='RG5Slk']"));
		   List<WebElement> productprice=driver.findElements(By.xpath("//div[@class='hZ3P6w DeU9vF']"));
           for(int i=0;i<productname.size();i++)
           {
        	   String product=productname.get(i).getText() +":::::"+productprice.get(i).getText();
        	   products.add(product);
           }
		   
		return products;
		   
	   }

}
