package testSuiteBDD1;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/testSuiteBDD1/demoblaze1.feature"},
        glue= {"testSuiteBDD1"},
        tags= "@demoblaze"
        
)
@RunWith(Cucumber.class)

public class TestRunner1 extends AbstractTestNGCucumberTests
{

}
