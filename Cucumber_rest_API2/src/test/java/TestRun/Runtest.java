package TestRun;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/restAssuresStatus"},
		glue = {"stepDefine"},
		plugin = {"html:target/html-output"}
		)
public class Runtest extends AbstractTestNGCucumberTests {

}

