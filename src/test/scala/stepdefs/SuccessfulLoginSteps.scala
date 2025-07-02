package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.SuccessfulLoginLocators.{errorMessageContainerLocator, loginButtonLocator, passwordLocator, usernameErrorIconLocator, usernameLocator}
import pages.AddToCartPage.{closeBrowser, elementIsPresent, getText, navigateTo, refreshPage, restartDriver}
import pages.SuccessfulLoginPage.{browserLaunch, clickOn, inputText}
import support.DriverManager.driver
import testdata.SuccessfulLoginData.{inventoryPageUrl, passwordText, userNameStandardText}

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
    refreshPage()
  }
  When("""I close the browser completely""") { () =>
    closeBrowser()
    // println("closed")
  }
  Then("""I should see a "x" icon next to the username and password fields""") { () =>
    assert(elementIsPresent(usernameErrorIconLocator))
    //println("username icon is there")
    assert(elementIsPresent(usernameErrorIconLocator))
    //println("password icon is there")
  }

  And("""I should see an error message "Username is required"""") { () =>
    assert(getText(errorMessageContainerLocator) == "Epic sadface: Username is required")
    //println("correct error message")
  }
  And("""I should see an error message "Password is required"""") { () =>
    assert(getText(errorMessageContainerLocator) == "Epic sadface: Password is required")
    //println("correct error message")
  }
  And("""I reopen the browser"""){()=>
    restartDriver()
    // println("reopened")
  }
  And("""I try to access the product listings page"""){()=>
    navigateTo(inventoryPageUrl)
  }
  Then("""I should be redirected to the login page"""){()=>
    assert(driver.getCurrentUrl != "https://www.saucedemo.com/inventory.html")
    // println("You are not on product inventory page")
  }
}