package pages

import locators.InventoryPageLoc
import locators.InventoryPageLoc.{ gridLayout}

import scala.jdk.CollectionConverters.CollectionHasAsScala

object InventoryPage extends BasePage {


  def productGridIsDisplayed: Boolean = {
    val grid = driver.findElement(gridLayout)
    grid.isDisplayed

  }

  def allProductsHaveDetails: Boolean = {
    val products = driver.findElements(InventoryPageLoc.productItem).asScala.toList

    products.zipWithIndex.forall { case (product, index) =>
      val name = product.findElements(InventoryPageLoc.Itemnames).asScala.headOption
      val price = product.findElements(InventoryPageLoc.Itemprice).asScala.headOption
      val image = product.findElements(InventoryPageLoc.images).asScala.headOption

      val isNameDisplayed = name.exists(_.isDisplayed)
      val isPriceDisplayed = price.exists(_.isDisplayed)
      val isImageDisplayed = image.exists(_.isDisplayed)

      println(s"Product ${index + 1} - Name: $isNameDisplayed, Price: $isPriceDisplayed, Image: $isImageDisplayed")
      isNameDisplayed && isPriceDisplayed && isImageDisplayed
    }
  }
  def footersocial(): Boolean = {

    val twitter = driver.findElement(InventoryPageLoc.twitterLink)
    val facebook = driver.findElement(InventoryPageLoc.facebookLink)
    val linkedin = driver.findElement(InventoryPageLoc.linkedinLink)
    println("Footer contains social media links.")

    twitter.isDisplayed && facebook.isDisplayed && linkedin.isDisplayed

  }
  def footerContainsCorrectText: Boolean = {
    val footerElement = driver.findElement(InventoryPageLoc.privacy)
    val expectedText = "2025 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"
    val actualText = footerElement.getText.trim

    println(s"Footer Text Found: $actualText")
    actualText == expectedText
  }

}





