package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.SuccessfulLoginLocators.{loginButtonLocator, passwordLocator, usernameLocator}
import pages.SuccessfulLoginPage.{browserLaunch, clickOn, inputText}
import support.DriverManager.driver
import testdata.SuccessfulLoginData.{passwordText, userNameStandardText}

class SuccessfulLoginSteps extends ScalaDsl with EN {

  Given("""I am on the login page""") { () =>
    browserLaunch()
  }
  Given("""I have entered the correct username and password.""") { () =>
    inputText(usernameLocator, userNameStandardText)
    inputText(passwordLocator, passwordText)
  }
  When("""I click on Login""") { () =>
    clickOn(loginButtonLocator)
  }
  Then("""I am taken to the product listings page.""") { () =>
    assert(driver.getCurrentUrl == "https://www.saucedemo.com/inventory.html")
  }


  When("""I enter a username but leave the password blank""") { () =>
    inputText(usernameLocator, userNameStandardText)
  }
  When("""I enter a password but leave the username blank""") { () =>
    inputText(passwordLocator, passwordText)
  }
  When("""I refresh the page""") { () =>

  }
  When("""I close the browser completely""") { () =>

  }
  Then("""I should see a "x" icon next to the username field""") { () =>

  }
  And("""I should see a "x" icon next to the password field""") { () =>

  }
  And("""I should see an error message "Username is required"""") { () =>

  }
  And("""I should see an error message "Password is required"""") { () =>

  }
  And("""I reopen the browser"""){()=>

  }
  And("""I try to access the product listings page"""){()=>

  }
  Then("""I should be redirected to the login page"""){()=>

  }
}