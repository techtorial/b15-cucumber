package com.etsy.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/etsy",//feature files
        glue = "com/etsy/stepdefinitions", //step definitions
        dryRun = false,//getting snips without executing
        tags = "@scenarioOutline",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
        //and refers to one scenario
        //or refers to multiple scenarios
)
public class EtsyRunner {
}
