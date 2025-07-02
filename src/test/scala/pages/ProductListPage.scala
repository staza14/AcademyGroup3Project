package pages

import org.openqa.selenium.{WebDriver, WebElement}
import locators.ProductPageLoc.{productImage, productName, productPrice}
import org.openqa.selenium.support.ui.WebDriverWait

import scala.jdk.CollectionConverters.CollectionHasAsScala



object ProductListPage extends BasePage {


  def areProductNamesVisible()(implicit driver: WebDriver): Boolean = { //im helps evvery time call the function
    try {
      val nameElements = driver.findElements(productName)
      nameElements.asScala.foreach(e => println(s"Product name text: '${e.getText}'"))
      nameElements.size() > 0 && nameElements.asScala.forall(_.getText.nonEmpty) // Boolean sonucu döndür
    }catch {
      case e:Exception=>
        println(s"Exception in areProductNamesVisible: ${e.getMessage}")
        false
    }

}
  def areProductPricesVisible(): Boolean = {
    val priceElements = driver.findElements(productPrice)
    priceElements.size() > 0 && priceElements.asScala.forall(_.getText.nonEmpty)
  }

  def areProductImageVisible()(implicit driver: WebDriver): Boolean = {
    val nameElements = driver.findElements(productImage)
    nameElements.size() > 0 && nameElements.asScala.forall(_.isDisplayed)


  }
  }
