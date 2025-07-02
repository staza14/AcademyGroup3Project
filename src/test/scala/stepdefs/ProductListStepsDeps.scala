package stepdefs
import org.scalatest.Assertions._
import io.cucumber.scala.{EN, ScalaDsl}
import locators.ProductPageLoc.productName
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import pages.ProductListPage.{areProductImageVisible, areProductNamesVisible, areProductPricesVisible}

import java.time.Duration




class ProductListStepsDeps extends ScalaDsl with EN{


  implicit val driver: WebDriver = new ChromeDriver()

    Given("""the product listings load the user should see the product name""") { () =>
      Thread.sleep(5000)
      assert(areProductNamesVisible(),"Product names are not vivible")

      }

    When("""the user should see the product price"""){ ()=>
      assert(areProductPricesVisible(), "Product prices are not visible ")
    }
    Then("""the user should see the product image"""){ ()=>
      assert(areProductImageVisible(), "Product prices are not visible")

    }




  Given("""the user is on any page"""){()=>

  }
  When("""the user footer loads,the footer should contain a Twitter link"""){()=>

  }
  Then("""the user footer should contain a Facebook link"""){()=>

  }
    And("""the user footer should contain a LinkedIn link"""){ ()=>

    }

}
