package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.LogoutLocators.{burgermenu, logoutclick}
import pages.LogoutPase.{burgerMenuButton, clickOn, logout}

object LogoutSteps extends ScalaDsl with EN  {



  When("""user clicks on the menu button""") { () =>
    burgerMenuButton()

  }
  And("""user selects Logout and user redirect login page""" ) { () =>
    logout()



  }


}
