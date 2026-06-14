package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class ResultsPage extends RootClass{
	
	
	public ResultsPage(WebDriver driver)
	{
		super(driver);
	}
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	@FindBy(xpath="//span[text()='Next']")
	WebElement Nextbutton;
	
	@FindBy(xpath="//span[text()='Previous']")
	WebElement Previous;
	
    public boolean isNextEnabled() {
        try {
            return Nextbutton.isDisplayed() && Nextbutton.isEnabled();
        } 
        catch (Exception e) {
            return false;
        }
    }
	
     public boolean isPreviousEnabled()
     {
    	 try {
    		 return Previous.isEnabled() && Previous.isDisplayed();
    		 
    	 }
    	 catch(Exception e)
    	 {
    		 return false;
    	 }
     }
	
     
     public void clickNextButton() {
         if (isNextEnabled()) {
             wait.until(ExpectedConditions.elementToBeClickable(Nextbutton)).click();
         }
     }
     
     
     public void clickPreviousButton() {
         if (isPreviousEnabled()) {
             wait.until(ExpectedConditions.elementToBeClickable(Previous)).click();
         }
     }
     
     public void waitForPageRefresh() {

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    // capture first product BEFORE refresh
    	    WebElement oldFirstProduct =
    	            driver.findElement(By.xpath("//div[@class='RG5Slk']"));

    	    // wait until old page becomes stale
    	    wait.until(ExpectedConditions.stalenessOf(oldFirstProduct));
    	}
     
     
     
	}
	
	


