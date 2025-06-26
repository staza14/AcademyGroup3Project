package pages

import locators.UnsuccessfulLoginLocators.errorMessageSelector

object UnsuccessfulLoginPage extends BasePage {
  def getErrorMessageText: String = {
    getText(errorMessageSelector)
  }
}
