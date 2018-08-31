#Feature Definition Template
@TestAmazon
Feature: Amazon Test - feature for validating Aamzon website with Nikon DX product
 	
  @001_Test_Nikon_D3X
  Scenario: Test If Nikon D3X is the second priciest product of Nikon in Amazon Website
  	Given Environment is "Firefox"
    Given Amazon WebPage is "https://www.amazon.com"
    When I search for "Nikon"
    And I sort the page based on "Price: High to Low"
    And I select the second item from the list
    Then I validate that the product title contains "Nikon D3400" 
 