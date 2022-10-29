package Features;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(stepNotifications = true,plugin= {"html:target/Myreport.html"}/*features = "src/test/java/Features",glue={"stepdefinition"}*/)
public class Runner {

}
