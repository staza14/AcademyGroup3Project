package locators

import org.openqa.selenium.By

object ViewCartContentsLocators {

  val shoppingCartLinkLocator: By = By.className("shopping_cart_link")
  val continueShoppingLocator: By = By.id("continue-shopping")
  // Cart items will match all items in the cart
  // So if there are 2 items in the cart
  // It will match to 2 items.
  // Similarly for inventory items!
  val inventoryItemsLocator: By = By.className("inventory_item_description")
  val cartItemsLocator: By = By.className("cart_item")
}
