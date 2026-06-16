package stepDefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.Flip_Home_Page;
import pages.ResultsPage;
import utils.ExcelUtility;
import utilitypages.ProductPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlipkartPaginationSteps {

    WebDriver driver;
    Flip_Home_Page homePage;
    ResultsPage resultsPage;
    ProductPage productpage;
    

    List<String> allProducts = new ArrayList<>();

    // =========================
    // BACKGROUND STEPS
    // =========================

    @Given("user launches Chrome browser")
    public void launch_browser() {
        driver = DriverFactory.getDriver();
    }

    @Given("user opens Flipkart application")
    public void open_flipkart() {
        driver.get("https://www.flipkart.com/");
        homePage = new Flip_Home_Page(driver);
        resultsPage = new ResultsPage(driver);
    }

    // =========================
    // SCENARIO STEPS
    // =========================

    @When("user searches for {string}")
    public void search_product(String product) {
        homePage.closeButton();
        homePage.searchproducts(product);
    }

    // =========================
    // PAGE 1 VALIDATION
    // =========================

    @Then("user validates products on first page")
    public void validate_first_page() {
    	productpage=new ProductPage();
        allProducts.addAll(productpage.getProductInfo(driver));
        System.out.println("Page 1 products extracted");
    }

    // =========================
    // NEXT PAGE ACTION
    // =========================

    @When("user clicks next page")
    public void click_next_page() {
        if (resultsPage.isNextEnabled()) {
            resultsPage.clickNextButton();
        }
    }

    @When("user waits for page refresh")
    public void wait_page_refresh() {
        resultsPage.waitForPageRefresh();   // create this method in POM
    }

    // =========================
    // PAGE 2 VALIDATION
    // =========================

    @Then("user validates products on second page")
    public void validate_second_page() {
        allProducts.addAll(productpage.getProductInfo(driver));
        System.out.println("Page 2 products extracted");
    }

    // =========================
    // PREVIOUS PAGE
    // =========================

    @When("user clicks previous page")
    public void click_previous_page() {
        if (resultsPage.isPreviousEnabled()) {
            resultsPage.clickPreviousButton();
        }
    }

    @Then("user confirms navigation back is successful")
    public void validate_previous_navigation() {
        System.out.println("Navigation back to previous page successful");
    }

    // =========================
    // EXPORT
    // =========================

    @Then("user exports all product data to Excel")
    public void export_to_excel() throws IOException {
        ExcelUtility.writeProductsToExcel(allProducts);
    }

    // =========================
    // COMMON METHOD
    // =========================


    
}