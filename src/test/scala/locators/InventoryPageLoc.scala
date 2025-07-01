package locators
import org.openqa.selenium.{By, WebElement}


object InventoryPageLoc {



  val inventrypage:By = By.className("inventory_list")
  val productItem: By = By.className("inventory_item")

  val Itemnames:By=By.className("inventory_item_name")
  val Itemprice: By = By.className("inventory_item_price")
  val images:By = By.className("inventory_item_img")

  val backpackname: By = By.id("item_4_title_link")
  val tshirtname: By = By.id("item_1_title_link")
  val babybodyname: By = By.id("item_2_title_link")
  val lightname:By = By.id("item_0_title_link")
  val jacketname: By=By.id("item_5_title_link")
  val redtshirtname:By= By.id("item_3_title_link")

  val twitterLink: By  = By.cssSelector("a[href*='twitter.com']")
  val facebookLink: By = By.cssSelector("a[href*='facebook.com']")
  val linkedinLink: By = By.cssSelector("a[href*='linkedin.com']")

  val privacy: By = By.className("footer_copy")


}
