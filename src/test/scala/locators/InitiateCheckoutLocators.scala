package locators

import org.openqa.selenium.By

object InitiateCheckoutLocators {
  val initiateCheckoutButtonLocator: By = By.id("checkout")
  val firstNameCheckoutInputLocator: By = By.id("first-name")
  val lastNameCheckoutInputLocator: By = By.id("last-name")
  val postcodeCheckoutInputLocator: By = By.id("postal-code")
}
