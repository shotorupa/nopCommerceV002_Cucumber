package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
      (
		features=".//Features/customers.feature",
		glue="stepDefination",
		dryRun=false,
		monochrome=true,
		
		plugin= {"pretty", "json:target/cucumber.json","html:test-output"}
		
		)
public class Runner  {
	
}