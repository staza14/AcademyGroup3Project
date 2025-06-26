package testdata

object UnsuccessfulLoginData {
  val invalidUsernames: List[String] = List(
    "problem_user",
    "performance_glitch_user",
    "error_user"
  )

  val expectedErrorMessage: String = "Epic sadface: Username and password do not match any user in this service"
}
