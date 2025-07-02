package support
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}



object DriverManager {
  var driver: WebDriver = _

  try {
    val options = new ChromeOptions()
    options.setAcceptInsecureCerts(true)
    val drv = new ChromeDriver(options)
    println("ChromeDriver created successfully.")
    drv
  } catch {
    case e: Exception =>
      println("Error creating ChromeDriver: " + e.getMessage)
      throw e
  }

}
