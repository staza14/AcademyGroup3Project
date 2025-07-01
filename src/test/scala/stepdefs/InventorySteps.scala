package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.InventoryPage.{allProductsHaveDetails, footerContainsCorrectText, footersocial, inventoryPageIsDisplayed}

class InventorySteps extends ScalaDsl with EN {



  Given("""user is on inventory page"""){ () =>
    assert(inventoryPageIsDisplayed,"user on the inventory page is not displayed.")

  }
  When("""all products should be displayed with images, names, and prices"""){ () =>
    assert(allProductsHaveDetails, "all products have images, names, and prices")
    println(" All products display name, price, and image successfully ")
  }

  When("""user sees links to social media in the footer"""){ () =>
    assert(footersocial, "Social media links are not visible in the footer")
  }
  Then("""User should see the text 2025 Sauce Labs All Rights of Service Privacy Policy in the footer"""){ () =>
    assert(footerContainsCorrectText,"Footer text is incorrect ")
    println(" Footer text is correct.")

  }

}