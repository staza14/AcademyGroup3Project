package runner

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith // Import JUnit’s @RunWith annotation to delegate execution to an external runner

@RunWith(classOf[Cucumber]) // Tell JUnit to execute this test suite with Cucumber’s JUnit engine
@CucumberOptions( // Begin Cucumber configuration block
  features = Array("src/test/resources/features"), // Path(s) to your .feature files (Gherkin scenarios)
  glue = Array("stepdefs", "support"), // Packages that contain step definitions, hooks, and other glue code
  tags = "not @known_defect",
  plugin = Array("pretty", //  • “pretty” prints colour‑coded steps to the console
    "html:target/cucumber-report.html" //  • Generates an HTML report at target/cucumber-report.html
//    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Generates Allure Report
  ),
  monochrome = true // Strips ANSI colours from console output for easier reading in plain terminals
) // End of @CucumberOptions block
class TestRunner // Empty body is fine; class merely acts as a configuration holder
