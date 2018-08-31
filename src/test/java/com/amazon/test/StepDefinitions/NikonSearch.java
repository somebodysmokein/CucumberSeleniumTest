package com.amazon.test.StepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class NikonSearch {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Given("^Environment is \"([^\"]*)\"$")
  public void environment_is(String browser) throws Throwable {
	  if(browser.equalsIgnoreCase("Chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\venkatesh\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }else if(browser.equalsIgnoreCase("FireFox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\venkatesh\\geckodriver.exe");
		    driver = new FirefoxDriver();
	  }
    
    
  }
  
  @Given("^Amazon WebPage is \"([^\"]*)\"$")
  public void aamazon_WebPage_is(String homePageUrl) throws Throwable {
	  baseUrl = homePageUrl;
	  System.out.println(homePageUrl);
	  driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @When("^I search for \"([^\"]*)\"$")
  public void i_search_for(String srchTxt)
  {
	  	//driver.get("https://www.amazon.com/");
	  	WebElement seachBox=driver.findElement(By.id("twotabsearchtextbox"));
	  	fluientWaitforElement(seachBox, 30, 5); 
	    driver.findElement(By.id("twotabsearchtextbox")).click();
	    driver.findElement(By.id("twotabsearchtextbox")).clear();
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(srchTxt);
	    WebElement srchButton=driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Go'])[1]/following::input[1]"));
	    fluientWaitforElement(srchButton, 60, 5);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Go'])[1]/following::input[1]")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @And("^I sort the page based on \"([^\"]*)\"$")
  public void i_sort_the_page_based_on(String sortOrder)
  {
	  WebElement sortList=driver.findElement(By.id("sort"));
	  fluientWaitforElement(sortList, 30, 5);
	  new Select(driver.findElement(By.id("sort"))).selectByVisibleText(sortOrder);
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @And("^I select the second item from the list$")
  public void i_select_the_second_item_from_the_list()
  {
	  WebElement resultTable=driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Compact yet capable'])[1]/following::h2[1]"));
	  fluientWaitforElement(resultTable, 60, 5);
	  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Compact yet capable'])[1]/following::h2[1]")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  
  @Then("^I validate that the product title contains \"([^\"]*)\"$")
  public void i_validate_that_the_product_title_contains(String prdtToSrch)
  {
	  System.out.println("Product to Search"+prdtToSrch);
	  try {
		  assertTrue(driver.findElement(By.id("productTitle")).getText().contains(prdtToSrch));
	      //assertEquals(prdtToSrch, driver.findElement(By.id("productTitle")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	 
	    try {
			tearDown();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
  }
  
 
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

 /* private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }*/

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
//Waiting for an element to be present on the page, checking
  // for its presence once every polling seconds.
  public WebElement fluientWaitforElement(WebElement element, int timoutSec, int pollingSec) {

	    FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(timoutSec, TimeUnit.SECONDS)
	        .pollingEvery(pollingSec, TimeUnit.SECONDS)
	        .ignoring(NoSuchElementException.class, TimeoutException.class).ignoring(StaleElementReferenceException.class);

	    for (int i = 0; i < 2; i++) {
	        try {
	            //fWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='reportmanager-wrapper']/div[1]/div[2]/ul/li/span[3]/i[@data-original--title='We are processing through trillions of data events, this insight may take more than 15 minutes to complete.']")));
	        fWait.until(ExpectedConditions.visibilityOf(element));
	        fWait.until(ExpectedConditions.elementToBeClickable(element));
	        } catch (Exception e) {

	        System.out.println("Element Not found trying again - " + element.toString().substring(70));
	        e.printStackTrace();

	        }
	    }

	    return element;

	    }
}

