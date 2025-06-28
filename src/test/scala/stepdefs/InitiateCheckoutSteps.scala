package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InitiateCheckoutLocators.{firstNameCheckoutInputLocator, initiateCheckoutButtonLocator, lastNameCheckoutInputLocator, postcodeCheckoutInputLocator}
import pages.AddToCartPage.{clickOn, elementIsPresent}
import support.DriverManager.driver

class InitiateCheckoutSteps extends ScalaDsl with EN {
  When("""I click the "Checkout" button""") { () =>
    clickOn(initiateCheckoutButtonLocator)
  }
  Then("""I should be taken to the checkout information page""") { () =>
    assert(driver.getCurrentUrl == "https://www.saucedemo.com/checkout-step-one.html")
  }
  And("""I should be prompted to enter my personal information""") { () =>
    assert(elementIsPresent(firstNameCheckoutInputLocator))
    assert(elementIsPresent(lastNameCheckoutInputLocator))
    assert(elementIsPresent(postcodeCheckoutInputLocator))
  }
}