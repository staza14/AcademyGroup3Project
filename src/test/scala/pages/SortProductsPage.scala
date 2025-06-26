package pages

import org.openqa.selenium.{By, WebElement}

import scala.collection.mutable.ListBuffer

object SortProductsPage extends BasePage {

  // Gets a list of prices from the locator(s) given
  // The locator could be a locator that is for 1 element or multiple
  // for example by using position() > 0 to find all the locators that match
  // that path.
  def getListOfPrices(locators: By): ListBuffer[Double] = {
    // Initiate an empty mutable list
    val listOfPrices = ListBuffer.empty[Double]
    // Get list of WebElements from the locators in the order they appear on
    // the website
    val prices: java.util.List[WebElement] = driver.findElements(locators)
    // Loop through the WebElements which should be prices
    for (i <- 0 until prices.size()) {
      // Extract each price
      val price = prices.get(i)
      // Scroll that price into view, unsure if this is necessary
      js.executeScript("arguments[0].scrollIntoView();", price)
      // Removes anything that isn't a number or a fullstop
      val cleanedPrice = price.getText.replaceAll("[^\\d.]", "")
      // Converts this cleaned price into a Double
      listOfPrices += cleanedPrice.toDouble
    }
    // Returns a list of prices as doubles
    listOfPrices
  }

  // Very similar to the above function except there will be a list of strings
  // instead of doubles
  def getListOfNames(locators: By): ListBuffer[String] = {
    // Initiate an empty mutable list
    val listOfNames = ListBuffer.empty[String]
    // Get list of WebElements in the order they appear on the website
    val names: java.util.List[WebElement] = driver.findElements(locators)
    // Iterate through the list
    for (i <- 0 until names.size()) {
      // Extract each name
      val name = names.get(i)
      // Scroll the item into view, unsure if this is necessary
      js.executeScript("arguments[0].scrollIntoView();", name)
      //Adds the name as a string
      listOfNames += name.getText

    }
//    println(listOfNames)
    // Returns a lit of names as strings
    listOfNames
  }

}
