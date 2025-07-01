package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.CompletePurchaseLocators.{backHomeButton, finishButton, orderCompleteHeader, orderCompleteMessage, totalPriceLocator}
import locators.ViewCartContentsLocators.cartItemsLocator
import pages.AddToCartPage.{clickOn, elementIsDisplayed, getText}
import pages.CompleteCheckoutPage.{extractDoubleFromString, totalCostOfItemsInCart}
import pages.ViewCartContentsPage.getAllCartItems
import support.DriverManager.driver
import support.MapOfItemsAdded.mapOfItemsAdded


class CompletePurchaseSteps extends ScalaDsl with EN {

  Then("""I see the item details""") { () =>
    // Checks the set of items added is the same as the set of items in the
    // final checkout page
    assert(mapOfItemsAdded.toSet == getAllCartItems(cartItemsLocator).toSet)
  }
  And("""I see the total cost""") { () =>
    val priceOnCheckout = extractDoubleFromString(getText(totalPriceLocator))
    assert(totalCostOfItemsInCart(mapOfItemsAdded) == priceOnCheckout)

  }
  When("""I click the 'Finish' button""") { () =>
    clickOn(finishButton)
  }
  Then("""I see the order confirmation message""") { () =>
    assert(getText(orderCompleteHeader) == "Thank you for your order!")
    assert(getText(orderCompleteMessage) == "Your order has been dispatched, and will arrive just as fast as the pony can get there!")
  }
  And("""I see the 'Back Home' button""") { () =>
    assert(elementIsDisplayed(backHomeButton))
  }

}