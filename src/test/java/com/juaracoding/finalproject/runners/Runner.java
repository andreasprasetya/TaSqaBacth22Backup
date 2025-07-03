package com.juaracoding.finalproject.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
        "src/test/resources/features"
}, plugin = { "pretty:target/pretty.txt",
        "html:target/cucumber-reports/index.html",
        "json:target/cucumber-reports/index.json",


}, glue = {
        "com.juaracoding.finalproject.hooks",
        "com.juaracoding.finalproject.steps",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
})
public class Runner extends AbstractTestNGCucumberTests {

}
