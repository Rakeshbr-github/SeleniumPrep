package testCases;

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

import pages.Flip_Home_Page;
import pages.ResultsPage;
import utils.ExcelUtility; 

public class Flipkart_validation  {


	public static void main(String[] args) throws InterruptedException {
			
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		try
		{
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
        Flip_Home_Page fh=new Flip_Home_Page(driver);
        ResultsPage rp=new ResultsPage(driver);
        fh.closeButton();
        fh.searchproducts("Laptops");
        
        List<String> allProducts = new ArrayList<>();

     // PAGE 1
     allProducts.addAll(productInfo(driver));
     System.out.println("Page 1 products extracted");

     // CLICK NEXT ONCE
     if (rp.isNextEnabled()) {
         rp.clickNextButton();
     }

     // capture first product before clicking next
     WebElement firstProductBefore =
             driver.findElement(By.xpath("//div[@class='RG5Slk']"));

     rp.clickNextButton();

     // WAIT until old page becomes stale
     wait.until(ExpectedConditions.stalenessOf(firstProductBefore));
     
     
     // PAGE 2
     allProducts.addAll(productInfo(driver));
     System.out.println("Page 2 products extracted");

     // CLICK PREVIOUS ONCE
     if (rp.isPreviousEnabled()) {
         rp.clickPreviousButton();
     }

     // IMPORTANT: do NOT extract again
     System.out.println("This page product info is already extracted");

            
        ExcelUtility.writeProductsToExcel(allProducts);

       
       
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
