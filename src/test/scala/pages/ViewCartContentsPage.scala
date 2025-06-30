package pages

import org.openqa.selenium.{By, WebDriver}
import support.DriverManager.driver

import scala.jdk.CollectionConverters.ListHasAsScala

object ViewCartContentsPage extends BasePage {

//   The function below takes the locators for the parent element
  // In this case it would be inventory items
  // It then finds their subsequent child elements that correspond to the
  // correct classNames.
  def addToCartAndStoreItemDetails(by: By, count: Int): List[Map[String, String]] = {
    val allItems = driver.findElements(by).asScala.take(count)

    allItems.map { item =>
      // This creates a map so that the text from each web element found
      // is added to it's corresponding Key.
      val name = item.findElement(By.className("inventory_item_name")).getText
      val price = item.findElement(By.className("inventory_item_price")).getText
      val desc = item.findElement(By.className("inventory_item_desc")).getText
      // The function then adds this item to the cart
      item.findElement(By.tagName("button")).click()

      Map(
        "Name" -> name,
        "Description" -> desc,
        "Price" -> price
      )
      // Finally it returns a list of maps with all the information from each
      // item that has been added to the cart.
    }.toList
  }

  // This function is very similar to the one above except that it doesn't click
  // the button associated.
  // In refactoring these 2 functions could be merged by adding a boolean
  // to the click button option.
  // Also worth noting that By.tagName("button") will find any button that is
  // there. So if it was already added to cart it would instead remove from cart.
  def getAllCartItems(by: By): List[Map[String, String]] = {
    val allItems = driver.findElements(by).asScala

    allItems.map { item =>
      val name = item.findElement(By.className("inventory_item_name")).getText
      val price = item.findElement(By.className("inventory_item_price")).getText
      val desc = item.findElement(By.className("inventory_item_desc")).getText

      Map(
        "Name" -> name,
        "Description" -> desc,
        "Price" -> price
      )
    }.toList
  }

}
