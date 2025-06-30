package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.InventoryPage
import pages.InventoryPage.{allProductsHaveDetails, footerContainsCorrectText, footersocial, productGridIsDisplayed}

class InventorySteps extends ScalaDsl with EN {


  Given("""User should be see the all product display grid layout""") { () =>
    assert(productGridIsDisplayed,"Product grid layout is not displayed.")
  }
    When("""all products should be displayed with images, names, and prices""") { () =>
      assert(allProductsHaveDetails, "all products have images, names, and prices.")
      println(" All products display name, price, and image successfully.")
    }
    Then("""the footer should be see contain links to social media""") { () =>

      assert(footersocial," Social media links visible in the footer.")
    }
    And("""User should see the text "2025 Sauce Labs All Rights of Service Privacy Policy in the footer""") { () =>
      footerContainsCorrectText
      println(" Footer text is correct.")

    }

}
