package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.AddToCartLocators.{addToCartButtonsLocator, cartNumberIconLocator}
import pages.AddToCartPage.{clickOnMultiple, getText}
import support.DriverManager.driver

class AddToCartSteps extends ScalaDsl with EN {
  When("""I add {int} products to the cart""") { (numberOfProducts: Int) =>
    clickOnMultiple(addToCartButtonsLocator, numberOfProducts)
  }
  Then("""the cart icon displays {string}""") { (expectedCount: String) =>
    assert(getText(cartNumberIconLocator) == expectedCount)
  }
}