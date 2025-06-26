package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.SuccessfulLoginLocators.{passwordLocator, usernameLocator}
import pages.SuccessfulLoginPage.inputText
import pages.UnsuccessfulLoginPage.getErrorMessageText
import support.DriverManager.driver
import testdata.SuccessfulLoginData.passwordText
import testdata.UnsuccessfulLoginData.expectedErrorMessage

class UnsuccessfulLoginSteps extends ScalaDsl with EN {
  Given("""I have entered an incorrect {string} and correct password""") { (username: String) =>
    // at the moment this looks at the examples table I think instead of the test data file
    // is that ok?
    inputText(usernameLocator, username)
    inputText(passwordLocator, passwordText)
  }
  Then("""An error message is displayed""") { () =>
    assert(getErrorMessageText == expectedErrorMessage)
  }
  And("""I remain on the login page""") { () =>
    assert(driver.getCurrentUrl == "https://www.saucedemo.com/")
  }

}