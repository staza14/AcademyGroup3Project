package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.SortProductsLocators.{nameLocators, priceLocators, sortDropdownLocator}
import pages.SortProductsPage.{getListOfNames, getListOfPrices, selectFromDropdown}


class SortProductsSteps extends ScalaDsl with EN {

  When("""I click sort by Price low to high""") { () =>
    selectFromDropdown(sortDropdownLocator, "Price (low to high)")
  }

  Then("""the products are sorted from lowest to highest""") { () =>
    assert(getListOfPrices(priceLocators).sorted == getListOfPrices(priceLocators))
    println("Yay! They are sorted correctly!")
  }

  When("""I click sort by Price high to low""") { () =>
    selectFromDropdown(sortDropdownLocator, "Price (high to low)")
  }

  Then("""the products are sorted from highest to lowest""") { () =>
    assert(getListOfPrices(priceLocators).sorted(Ordering[Double].reverse) == getListOfPrices(priceLocators))
    println("Yay! They are sorted correctly!")
  }

  When("""I click sort by Name A to Z""") { () =>
    selectFromDropdown(sortDropdownLocator, "Name (A to Z)")
  }

  Then("""the products are sorted alphabetically""") { () =>
    assert(getListOfNames(nameLocators).sorted == getListOfNames(nameLocators))
    println("Yay! They are sorted correctly!")
  }

  When("""I click sort by Name Z to A""") { () =>
    selectFromDropdown(sortDropdownLocator, "Name (Z to A)")
  }

  Then("""the products are sorted in reverse alphabetical order""") { () =>
    assert(getListOfNames(nameLocators).sorted(Ordering[String].reverse) == getListOfNames(nameLocators))
    println("Yay! They are sorted correctly!")
  }


}