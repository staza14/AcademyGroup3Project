package pages

import locators.LogoutLocators.{burgermenu, logoutclick}
import org.openqa.selenium.{By, JavascriptExecutor}

object LogoutPage extends BasePage {


  def burgerMenuButton(): Unit = {
    clickOn(burgermenu)
  }

  def logout(): Unit = {
//    val element = driver.findElement(logoutclick)
//    if (element.isDisplayed && element.isEnabled) {
//      val jsExecutor = driver.asInstanceOf[JavascriptExecutor]
//      jsExecutor.executeScript("arguments[0].click();", element)
//      println("I clicked!")
//    }
    waitUntilClickable(logoutclick).click()
  }
}