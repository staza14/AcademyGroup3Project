package pages

import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import support.DriverManager
import utils.ConfigReader

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala

trait BasePage {
  def driver: WebDriver = DriverManager.driver

  def js: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]

  def browserLaunch(): Unit = {
    val testUrl = ConfigReader.get("base.url")
    driver.get(testUrl)
  }

  def refreshPage(): Unit = {
    driver.navigate().refresh()
  }

  def closeBrowser(): Unit = {
    driver.quit()
  }

  // Common Actions

  def inputText(selector: By, text: String): Unit = {
    val element = driver.findElement(selector)
    js.executeScript("arguments[0].scrollIntoView();", element)
    element.sendKeys(text)

  }

  def clickOn(selector: By): Unit = {
    val element = driver.findElement(selector)
    js.executeScript("arguments[0].scrollIntoView();", element)
    element.click()
  }

  def getText(selector: By): String = {
    val element = driver.findElement(selector)
    js.executeScript("arguments[0].scrollIntoView();", element)
    element.getText
    }

  def selectFromDropdown(dropdown: By, option: String): Unit = {
    val element = driver.findElement(dropdown)
    js.executeScript("arguments[0].scrollIntoView();", element)
    val select: Select = new Select(element)
    select.selectByVisibleText(option)
  }

  def elementIsDisplayed(selector: By): Boolean = {
    val element = driver.findElement(selector)
    js.executeScript("arguments[0].scrollIntoView();", element)
    element.isDisplayed
  }

  // findElements does not throw an error if it doesn't find any elements it returns an empty list.
  def elementIsPresent(selector: By): Boolean = {
    driver.findElements(selector).asScala.nonEmpty
  }

  def waitUntilClickable(selector: By): WebElement = {
    val wait = new WebDriverWait(driver, Duration.ofSeconds(5))
    wait.until(ExpectedConditions.elementToBeClickable(selector))
  }
}
