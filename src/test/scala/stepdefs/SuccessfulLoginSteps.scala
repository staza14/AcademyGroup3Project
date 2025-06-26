package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.SuccessfulLoginLocators.{loginButtonLocator, passwordLocator, usernameLocator}
import pages.SuccessfulLoginPage.{browserLaunch, clickOn, inputText}
import sbt.testing.Task
import support.DriverManager.driver
import testdata.SuccessfulLoginData.{passwordText, userNameStandardText}

class SuccessfulLoginSteps extends ScalaDsl with EN {

  Given("""I am on the login page""") { () =>
    // Code
    browserLaunch()

  }
  Given("""I have entered the correct username and password.""") { () =>
    // Code
    inputText(usernameLocator, userNameStandardText)
    inputText(passwordLocator, passwordText)

  }

  When("""I click on Login""") { () =>
    // Code
    clickOn(loginButtonLocator)
    Thread.sleep(50000)

  }


  Then("""I am taken to the product listings page.""") { () =>
    // Code
    assert(driver.getCurrentUrl == "https://www.saucedemo.com/inventory.html")
  }
}