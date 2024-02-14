package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/com.features/HomePage.feature", glue = {
		"com.stepDefinition" }, monochrome = true, // for displaying console output in readable format
		dryRun = false, plugin = { "pretty", "html:target/cucumberTestReport.html" })

public class TestRunner extends AbstractTestNGCucumberTests {

}
