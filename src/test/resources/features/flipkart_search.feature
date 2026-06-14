Feature: Flipkart Pagination Data Extraction

  Background:
    Given user launches Chrome browser
    And user opens Flipkart application

  Scenario: Validate pagination and product extraction
    When user searches for "Laptops"
    Then user validates products on first page
    When user clicks next page
    And user waits for page refresh
    Then user validates products on second page
    When user clicks previous page
    Then user confirms navigation back is successful
    And user exports all product data to Excel