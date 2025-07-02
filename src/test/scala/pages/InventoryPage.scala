package pages

import locators.InventoryPageLocators
import locators.InventoryPageLocators.inventrypage

import scala.jdk.CollectionConverters.CollectionHasAsScala

object InventoryPage extends BasePage {

  def allProductsHaveDetails: Boolean = {
    val products = driver.findElements(InventoryPageLocators.productItem).asScala.toList// Gets all product elements as a Scala list

    products.zipWithIndex.forall { case (product, index) =>
      val name = product.findElements(InventoryPageLocators.Itemnames).asScala.headOption// Tries to find the product name (first match)
      val price = product.findElements(InventoryPageLocators.Itemprice).asScala.headOption
      val image = product.findElements(InventoryPageLocators.images).asScala.headOption

      val isNameDisplayed = name.exists(_.isDisplayed)//  Is name displayed?
      val isPriceDisplayed = price.exists(_.isDisplayed)
      val isImageDisplayed = image.exists(_.isDisplayed)

      println(s"Product ${index + 1} - Name: $isNameDisplayed, Price: $isPriceDisplayed, Image: $isImageDisplayed")
      isNameDisplayed && isPriceDisplayed && isImageDisplayed
    }
  }
  def footersocial(): Boolean = {
    val twitter = driver.findElement(InventoryPageLocators.twitterLink)// Does the footer contain the correct text?
    val facebook = driver.findElement(InventoryPageLocators.facebookLink)
    val linkedin = driver.findElement(InventoryPageLocators.linkedinLink)
    println("Footer contains social media links.")

    twitter.isDisplayed && facebook.isDisplayed && linkedin.isDisplayed

  }
  def footerContainsCorrectText: Boolean = {
    val footerElement = driver.findElement(InventoryPageLocators.privacy)
    val expectedText = "© 2025 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"
    val actualText = footerElement.getText.trim

    println(s"Footer Text Found: $actualText")
    actualText == expectedText // Compares actual text with expected text and returns true if they match
  }

}





