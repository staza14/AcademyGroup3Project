package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.LockOutUserLocators.lockedOutErrorMessage
import locators.SuccessfulLoginLocators.{passwordLocator, usernameLocator}
import pages.SuccessfulLoginPage.{getText, inputText}
import support.DriverManager.driver
import testdata.LockOutUserData.userNameLockOutText
import testdata.SuccessfulLoginData.passwordText
import utils.ScreenCapture.takeScreenshot

class LockOutUserSteps extends ScalaDsl with EN {

  Given("""I have entered locked out username and locked out password""") { () =>
    // Code
    inputText(usernameLocator, userNameLockOutText)
    inputText(passwordLocator, passwordText)
  }

  Then("""I should see an error message""") { () =>
    // Code
    assert(getText(lockedOutErrorMessage) == "Epic sadface: Sorry, this user has been locked out.")

  }

  And("""I should not navigate to the products page""") { () =>
    // Code
    assert(driver.getCurrentUrl != "https://www.saucedemo.com/inventory.html")

  }
}