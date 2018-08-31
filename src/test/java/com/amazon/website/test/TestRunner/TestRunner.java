package com.amazon.website.test.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/***
 * Specifying pretty as a format option ensure that HTML report will be generated. 
 * When we specify html:target/Destination - It will generate the HTML report
 * inside the Destination folder, in the target folder of the maven project. 	
 * @author 
 *
 */

@RunWith(Cucumber.class) 
@CucumberOptions( features="src/main/features/amazonTest.feature",
glue= {"com.amazon.test.StepDefinitions"},
format = {"pretty","json:target/cucumber.json", "html:target/Report"} ) 
public class TestRunner {

}




