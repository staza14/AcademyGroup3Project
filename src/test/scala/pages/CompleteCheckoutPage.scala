package pages

object CompleteCheckoutPage extends BasePage {

  def totalCostOfItemsInCart(cartItems: List[Map[String, String]]): Double = {
    // Initiate a total of 0 as a Double
    var total = 0.0
    for (i <- 0 until cartItems.size) {
      // Get the string that contains the price from each Map
      val priceString = cartItems(i).getOrElse("Price", "")
      // Removes anything that isn't a number or a fullstop
      val cleanedPrice = priceString.replaceAll("[^\\d.]", "").toDouble
      // Add price to the total
      total += cleanedPrice
    }
    // Return total
    total
  }

  def extractDoubleFromString(string: String): Double = {
    string.replaceAll("[^\\d.]", "").toDouble
  }
}