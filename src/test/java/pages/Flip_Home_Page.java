package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Flip_Home_Page  extends RootClass{
	
	
    public Flip_Home_Page(WebDriver driver) {
		super(driver);
	}
    
    @FindBy(xpath="//input[contains(@placeholder,'Search for Products')]")
    WebElement searchbox;
    
    @FindBy(xpath="//span[@role='button' and @class='b3wTlE']")
    WebElement closebutton;
	
    public WebElement closeButton()
    {
    	if(closebutton.isDisplayed())
    	{
    		closebutton.click();
    	}
		return closebutton;
    }
    
    public void searchproducts(String product)
    {
    	searchbox.sendKeys(product);
    	searchbox.sendKeys(Keys.ENTER);
    }

}
