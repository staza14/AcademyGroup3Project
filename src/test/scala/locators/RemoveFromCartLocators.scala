package locators

import org.openqa.selenium.By

object RemoveFromCartLocators {
  val removeFromCartButtonsLocator: By = By.className("btn_secondary")

  // this will find the button to add/remove the backpack regardless of
  // what state its in - aka says add or remove
  // it will also find it on the cart page if the product is in cart
  val backpackButtonLocator: By = By.cssSelector("button[id$='sauce-labs-backpack']")

  val cartLinkLocator: By = By.className("shopping_cart_link")
  val navMenuLocator: By = By.id("react-burger-menu-btn")
  val allItemsLinkLocator: By = By.id("inventory_sidebar_link")
  val cartItemsLocator: By = By.className("cart_item")
}
