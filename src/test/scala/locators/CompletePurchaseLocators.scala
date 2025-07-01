package locators

import org.openqa.selenium.By

object CompletePurchaseLocators {

  val finishButton: By = By.id("finish")
  val orderCompleteHeader: By = By.className("complete-header")
  val orderCompleteMessage: By = By.className("complete-text")
  val backHomeButton: By = By.id("back-to-products")
  val totalPriceLocator: By = By.className("summary_subtotal_label")
}
