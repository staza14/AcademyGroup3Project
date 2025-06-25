package utils

import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriver}

import java.io.File
import java.nio.file.{Files, Paths}
import java.text.SimpleDateFormat
import java.util.Date
import org.openqa.selenium.io.FileHandler


object ScreenCapture {
  def takeScreenshot(driver: WebDriver, folderPath: String, fileName: String): File = {
    val timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date())// Generate a timestamp to append to the screenshot filename.
   val screenshotDir = Paths.get(folderPath) // Create a path object for the folder where the screenshot will be saved.
   if (!Files.exists(screenshotDir)) Files.createDirectories(screenshotDir) // Check if the directory exists; if not, create it.
   val srcFile = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)// This allows you to capture the screenshot as a file.
   val screenshotFile = screenshotDir.resolve(s"${fileName}_$timestamp.png").toFile // Create the full path for the screenshot file by combining folder path, filename, and timestamp.
   FileHandler.copy(srcFile, screenshotFile)    // Copy the screenshot to the specified location.
   screenshotFile  // Return the screenshot file.
   }
 }