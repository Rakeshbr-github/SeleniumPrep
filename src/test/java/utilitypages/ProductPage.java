package utilitypages;

import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;

public class ProductPage {

    public static List<String> getProductInfo(WebDriver driver) {

        List<String> products = new ArrayList<>();

        List<WebElement> productNames =
                driver.findElements(By.xpath("//div[@class='RG5Slk']"));

        List<WebElement> productPrices =
                driver.findElements(By.xpath("//div[@class='hZ3P6w DeU9vF']"));

        int size = Math.min(productNames.size(), productPrices.size());

        for (int i = 0; i < size; i++) {

            String name = productNames.get(i).getText();
            String price = productPrices.get(i).getText();

            products.add(name + ":::::" + price);
        }

        return products;
    }


    
}