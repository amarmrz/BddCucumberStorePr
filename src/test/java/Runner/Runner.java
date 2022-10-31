package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(stepNotifications = true, plugin = {
		"html:target/Myreport.html" }, features = "Features\\Login.feature", glue = {
				"stepDifinition" },dryRun = false)
public class Runner {

}
