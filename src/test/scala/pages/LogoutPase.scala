package pages

import locators.LogoutLocators.{burgermenu, logoutclick}
import org.openqa.selenium.{By, JavascriptExecutor}

object LogoutPase extends BasePage {


  def burgerMenuButton(): Unit = {
    clickOn(burgermenu)
    println(s" click on ")
  }

  def logout(): Unit = {
    val element = driver.findElement(logoutclick)
    if (element.isDisplayed && element.isEnabled) {
      val jsExecutor = driver.asInstanceOf[JavascriptExecutor]
      jsExecutor.executeScript("arguments[0].click();", element)
      println("Clicked logout with JavaScript")
    } else {
      println("Logout link is not interactable")
    }

  }
}