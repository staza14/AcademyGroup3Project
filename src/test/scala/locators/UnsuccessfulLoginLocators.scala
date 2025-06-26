package locators

import org.openqa.selenium.By

object UnsuccessfulLoginLocators {
  val errorMessageSelector: By = By.cssSelector("h3[data-test='error']")
}
