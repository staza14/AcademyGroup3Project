package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InitiateCheckoutLocators.{firstNameCheckoutInputLocator, lastNameCheckoutInputLocator, postcodeCheckoutInputLocator}
import pages.AddToCartPage.inputText
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
    clickOn()
  }
  Then("""I should be navigated to the Checkout Overview page""") { () =>

  }
  When("""I incorrectly fill in the {string}, {string} and {string}""") { () =>

  }
  Then("""I should remain on the Checkout Information page""") { () =>

  }
  And("""I should see a checkout error message""") { () =>

  }
}