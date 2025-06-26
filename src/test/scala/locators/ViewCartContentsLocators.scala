package locators

import org.openqa.selenium.By

object ViewCartContentsLocators {

  val shoppingCartLinkLocator: By = By.className("shopping_cart_link")
  val continueShoppingLocator: By = By.id("continue-shopping")
  // Cart item will match all items in the cart
  // So if there are 2 items in the cart
  // It will match to 2 items.
  val cartItemLocator: By = By.className("cart_item")
}
