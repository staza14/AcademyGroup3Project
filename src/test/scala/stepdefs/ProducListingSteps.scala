package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.ProducListPage
import support.DriverManager.driver


class ProducListingSteps extends ScalaDsl with EN{



  When("""user should be see the all product grid layout""") { () =>
    //assert(ProducListPage.isProductGridVisible(driver))
   // Thread.sleep(5000)

  }
  Then("""all products should be displayed with images, names, and prices""") {() =>

  }
  And("""the footer should be see contain links to social media"""){ () =>

  }


}

