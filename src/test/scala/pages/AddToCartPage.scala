package pages
import org.openqa.selenium.By
import scala.jdk.CollectionConverters.ListHasAsScala

object AddToCartPage extends BasePage {
  def clickOnMultiple(selector: By, count: Int): Unit = {
    // remember find elements returns a java list, we need to turn this to a scala collection
    val buttons = driver.findElements(selector).asScala
    for (button <- buttons.take(count)) {
      js.executeScript("arguments[0].scrollIntoView();", button)
      button.click()
    }
  }
}
