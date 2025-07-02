package locators

import org.openqa.selenium.By

object ProductPageLoc {


  val page: By = By.id("By.id(\"inventory_list\")")
  val usernameLocator: By = By.id("user-name")
  val passwordLocator: By = By.cssSelector("#password")
  val loginButtonLocator: By = By.cssSelector("#login-button")

  val productName:By = By.className("inventory_item_name")
  val productPrice: By = By.className("inventory_item_price")
  val productImage:By=By.className("inventory_item_img")
}
