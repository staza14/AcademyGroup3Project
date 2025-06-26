package support

import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import support.DriverManager.driver
import utils.ConfigReader
import utils.ScreenCapture.takeScreenshot

import java.io.File
import java.nio.file.Paths

class Hooks extends ScalaDsl with EN {

  //
  val options = new ChromeOptions()
  //options.addArguments("--headless=new") // stops chrome opening
  options.addArguments("--guest") // stops password pop up
  def userScreenshotDir: String = Paths.get(System.getProperty("user.home"), "Documents", "Screenshots").toString
  def handleScenarioFailure(scenario: Scenario): Unit = {
    println("Scenario failed! Taking screenshot...")
    val screenshotFile: File =    takeScreenshot(DriverManager.driver, userScreenshotDir, s"${scenario.getName}_failure")
    println(s"Saved screenshot to: ${screenshotFile.getPath} - ")
  }

  Before {
    println("Launching browser before scenario...")

    driver = new ChromeDriver(options)
    driver.manage().window().maximize()
    val testUrl = ConfigReader.get("base.url")
    driver.get(testUrl)
  }

  After { scenario: Scenario =>
    if (scenario.isFailed) { // If scenario fails, it will take a screenshot and save it locally.
      handleScenarioFailure(scenario)
      println("Scenario Failed: Screenshot taken")
    }
    println("Closing browser after scenario...")
    driver.quit()

  }


}
