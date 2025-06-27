package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.ViewCartContentsLocators.{cartItemsLocator, continueShoppingLocator, inventoryItemsLocator, shoppingCartLinkLocator}
import pages.AddToCartPage.clickOn
import pages.ViewCartContentsPage.{addToCartAndStoreItemDetails, getAllCartItems}
import support.DriverManager.driver

class ViewCartContentsSteps extends ScalaDsl with EN {

  var mapOfItemsAdded: List[Map[String, String]] = List.empty

  Given("""I add {int} items to the cart""") { (numberOfItems: Int) =>
    mapOfItemsAdded = addToCartAndStoreItemDetails(inventoryItemsLocator, numberOfItems)
  }

  When("""I click on the cart icon""") { () =>
    clickOn(shoppingCartLinkLocator)
  }

  Then("""I am taken to the cart page""") { () =>
    assert(driver.getCurrentUrl == "https://www.saucedemo.com/cart.html")
  }

  Then("""I see an empty cart""") { () =>
    driver.findElements(cartItemsLocator).size() == 0
  }

  When("""I click on Continue Shopping""") { () =>
    clickOn(continueShoppingLocator)
  }

  Then("""I see the same products in my cart""") { () =>
    assert(mapOfItemsAdded.toSet == getAllCartItems(cartItemsLocator).toSet)
  }

}