package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(stepNotifications = true, plugin = { "pretty",
		"html:target/Myreport.html"},
        features = "Features\\Customers.feature", 
        glue = { "stepDifinition" },
        dryRun = false,
        monochrome = true,
        tags = "@smoke")
public class Runner {

}
