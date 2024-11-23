package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\Mr. Swapnil\\eclipse-workspace83\\CRM_CucuFram\\Features\\Marketing.feature",
		glue="StepsDefinations",
		dryRun = false,//check correct action method 
		plugin= {"pretty","html:target/HtmlReports"},
		//plugin = {"json:target/cucumber.json"}),

	    monochrome=true // used for readable output
	   // tags="@KiranAcademy"
		)



public class TestRunner {

}
