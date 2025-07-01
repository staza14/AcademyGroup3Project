package locators

import org.openqa.selenium.By

object ContinueCheckoutLocators {
  val continueCheckoutButtonLocator: By = By.id("continue")
  val continueCheckoutErrorLocator: By = By.className("error-message-container")
}
