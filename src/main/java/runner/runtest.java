package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "StepDev",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class runtest extends AbstractTestNGCucumberTests {

}
