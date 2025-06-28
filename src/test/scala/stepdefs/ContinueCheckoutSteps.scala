package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.ContinueCheckoutLocators.{continueCheckoutButtonLocator, continueCheckoutErrorLocator}
import locators.InitiateCheckoutLocators.{firstNameCheckoutInputLocator, lastNameCheckoutInputLocator, postcodeCheckoutInputLocator}
import pages.AddToCartPage.{clickOn, elementIsPresent, inputText}
import support.DriverManager.driver
import testdata.ContinueCheckoutData.{checkoutFirstNameText, checkoutLastNameText, checkoutPostalCodeText}

class ContinueCheckoutSteps extends ScalaDsl with EN {
  When("""I fill in the First Name field""") { () =>
    inputText(firstNameCheckoutInputLocator,checkoutFirstNameText)
  }
  And("""I fill in the Last Name field""") { () =>
    inputText(lastNameCheckoutInputLocator,checkoutLastNameText)
  }
  And("""I fill in the Postal Code field""") { () =>
    inputText(postcodeCheckoutInputLocator,checkoutPostalCodeText)
  }
  And("""I click the ‘Continue’ button""") { () =>
    clickOn(continueCheckoutButtonLocator)
  }
  Then("""I should be navigated to the Checkout Overview page""") { () =>
    assert(driver.getCurrentUrl == "https://www.saucedemo.com/checkout-step-two.html")
  }
  When("""I incorrectly fill in the {string}, {string} and {string}""") { (firstName: String, lastName: String, postalCode: String) =>
    inputText(firstNameCheckoutInputLocator,firstName)
    inputText(lastNameCheckoutInputLocator,lastName)
    inputText(postcodeCheckoutInputLocator,postalCode)
  }
  Then("""I should remain on the Checkout Information page""") { () =>
    assert(driver.getCurrentUrl == "https://www.saucedemo.com/checkout-step-one.html")
  }
  And("""I should see a checkout error message""") { () =>
    assert(elementIsPresent(continueCheckoutErrorLocator))
  }
}