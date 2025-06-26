package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.RemoveFromCartLocators.{allItemsLinkLocator, backpackButtonLocator, cartLinkLocator, navMenuLocator, removeFromCartButtonsLocator}
import pages.AddToCartPage.{clickOn, clickOnMultiple, elementIsPresent, getText, waitUntilClickable}

class RemoveFromCartSteps extends ScalaDsl with EN {
  When("""I remove {int} products from the cart""") { (numberOfProducts: Int) =>
    clickOnMultiple(removeFromCartButtonsLocator, numberOfProducts)
  }
  Then("""on the cart page the product should be removed""") { () =>
    // go to cart
    clickOn(cartLinkLocator)
    // check that the backpack is not there
    !elementIsPresent(backpackButtonLocator)
//    println("Great, the backpack has been removed from cart.")
  }
  And("""on the product inventory page the button now says 'add to cart'""") { () =>
    // navigate to the inventory page
    clickOn(navMenuLocator)
    // println("clicked nav bar")
    // check on this use of .click()
    waitUntilClickable(allItemsLinkLocator).click()
    // println("clicked allItems")
    // check that button text has changed
   assert(getText(backpackButtonLocator) == "add to cart")
  }
  Given("""I navigate to the cart page""") { () =>
    // more to cart by clicking button
  }
  Then("""the cart should be empty""") { () =>
    // check cart is empty
  }
  And("""the cart icon should not display a number""") { () =>
    // check that there is no number icon
  }
}