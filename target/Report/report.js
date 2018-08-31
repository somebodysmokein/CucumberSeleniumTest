$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/features/amazonTest.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Feature Definition Template"
    }
  ],
  "line": 3,
  "name": "Amazon Test - feature for validating Aamzon website with Nikon DX product",
  "description": "",
  "id": "amazon-test---feature-for-validating-aamzon-website-with-nikon-dx-product",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@TestAmazon"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "Test If Nikon D3X is the second priciest product of Nikon in Amazon Website",
  "description": "",
  "id": "amazon-test---feature-for-validating-aamzon-website-with-nikon-dx-product;test-if-nikon-d3x-is-the-second-priciest-product-of-nikon-in-amazon-website",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@001_Test_Nikon_D3X"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Environment is \"Firefox\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Amazon WebPage is \"https://www.amazon.com\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I search for \"Nikon\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I sort the page based on \"Price: High to Low\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I select the second item from the list",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I validate that the product title contains \"Nikon D3400\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Firefox",
      "offset": 16
    }
  ],
  "location": "NikonSearch.environment_is(String)"
});
formatter.result({
  "duration": 6446614580,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.amazon.com",
      "offset": 19
    }
  ],
  "location": "NikonSearch.aamazon_WebPage_is(String)"
});
formatter.result({
  "duration": 11013001239,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Nikon",
      "offset": 14
    }
  ],
  "location": "NikonSearch.i_search_for(String)"
});
formatter.result({
  "duration": 4711938833,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Price: High to Low",
      "offset": 26
    }
  ],
  "location": "NikonSearch.i_sort_the_page_based_on(String)"
});
formatter.result({
  "duration": 5514048705,
  "status": "passed"
});
formatter.match({
  "location": "NikonSearch.i_select_the_second_item_from_the_list()"
});
formatter.result({
  "duration": 30050557774,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: (.//*[normalize-space(text()) and normalize-space(.)\u003d\u0027Compact yet capable\u0027])[1]/following::h2[1]\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.11.0\u0027, revision: \u0027e59cfb3\u0027, time: \u00272018-03-11T20:26:55.152Z\u0027\nSystem info: host: \u0027VENKY\u0027, ip: \u0027192.168.0.15\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002710.0.2\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities {acceptInsecureCerts: true, browserName: firefox, browserVersion: 61.0.2, javascriptEnabled: true, moz:accessibilityChecks: false, moz:headless: false, moz:processID: 47004, moz:profile: C:\\Users\\venkatesh\\AppData\\..., moz:useNonSpecCompliantPointerOrigin: false, moz:webdriverClick: true, pageLoadStrategy: normal, platform: XP, platformName: XP, platformVersion: 10.0, rotatable: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}}\nSession ID: 9b03a22d-778a-45db-a768-6d165d5ee9a0\n*** Element info: {Using\u003dxpath, value\u003d(.//*[normalize-space(text()) and normalize-space(.)\u003d\u0027Compact yet capable\u0027])[1]/following::h2[1]}\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:319)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:421)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:311)\r\n\tat com.amazon.test.StepDefinitions.NikonSearch.i_select_the_second_item_from_the_list(NikonSearch.java:85)\r\n\tat ✽.And I select the second item from the list(src/main/features/amazonTest.feature:11)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Nikon D3400",
      "offset": 44
    }
  ],
  "location": "NikonSearch.i_validate_that_the_product_title_contains(String)"
});
formatter.result({
  "status": "skipped"
});
});