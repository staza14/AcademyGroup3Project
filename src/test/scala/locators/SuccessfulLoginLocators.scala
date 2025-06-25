package locators

import org.openqa.selenium.By

object SuccessfulLoginLocators {

  val usernameLocator: By = By.id("user-name")
  val passwordLocator: By = By.id("password")
  val loginButtonLocator: By = By.id("login-button")
//  val lockedOutErrorMessage: By = By.tagName("h3")

}
