package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.InventoryPage.{allProductsHaveDetails, footerContainsCorrectText}
import support.DriverManager.driver

class InventorySteps extends ScalaDsl with EN {



  Given("""user is on inventory page"""){ () =>
    assert(driver.getCurrentUrl == "https://www.saucedemo.com/inventory.html")

  }
  When("""all products should be displayed with images, names, and prices"""){ () =>
    assert(allProductsHaveDetails)
  }

  Then("""User should see the text 2025 Sauce Labs All Rights of Service Privacy Policy in the footer"""){ () =>
    assert(footerContainsCorrectText)
  }

}