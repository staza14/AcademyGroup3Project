package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.AddToCartLocators.{addToCartButtonsLocator, cartNumberIconLocator}
import locators.ViewCartContentsLocators.{cartItemLocator, continueShoppingLocator, shoppingCartLinkLocator}
import pages.AddToCartPage.{clickOn, clickOnMultiple, getText}
import support.DriverManager.driver

class ViewCartContentsSteps extends ScalaDsl with EN {

  When("""I click on the cart icon""") { () =>
    clickOn(shoppingCartLinkLocator)
  }

  Then("""I am taken to the cart page""") { () =>
    assert(driver.getCurrentUrl == "https://www.saucedemo.com/cart.html")

  }

  Then("""I see an empty cart""") { () =>
    driver.findElements(cartItemLocator)
  }

  When("""I click on Continue Shopping""") { () =>
    clickOn(continueShoppingLocator)
  }

  Then("""I see the same products in my cart""") { () =>

  }

}