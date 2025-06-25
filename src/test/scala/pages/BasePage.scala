package pages

import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}
import support.DriverManager
import utils.ConfigReader

trait BasePage {
  def driver: WebDriver = DriverManager.driver

  def js: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]

  def browserLaunch(): Unit = {
    val testUrl = ConfigReader.get("base.url")
    driver.get(testUrl)
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

}
