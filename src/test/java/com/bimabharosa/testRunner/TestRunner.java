package com.bimabharosa.testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./Feature",
        glue = {"com/bimabharosa/stepDefinitions", "com/bimabharosa/hooks"},
        plugin = {"pretty", "html:target/cucumber-report/BimaBharosaReport.html",
                "json:target/cucumber-report/BimaBharosaReport.json",
                "junit:target/cucumber-report/BimaBharosaReport.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true)
public class TestRunner {
}
