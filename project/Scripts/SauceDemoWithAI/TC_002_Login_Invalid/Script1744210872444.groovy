import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/*
 *  Automate the login process on the SauceDemo website with invalid credentials and verify the error message.
 *
 *  1. Open a web browser and navigate to the SauceDemo login page.
 *  2. Input an invalid username and password into the respective fields.
 *  3. Click the login button to attempt to log in.
 *  4. Verify if the error message is displayed within a specified timeout.
 *  5. Log a comment based on whether the error message is displayed or not.
 *  6. Take a screenshot after the validation process.
 *  7. Close the web browser.
 *
 */

// Open the SauceDemo login page
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.saucedemo.com/')

// Input invalid username
WebUI.setText(findTestObject('Page_SauceDemo/input_Username'), 'invalid_user')

// Input invalid password
WebUI.setText(findTestObject('Page_SauceDemo/input_Password'), 'wrong_password')

// Click the login button
WebUI.click(findTestObject('Page_SauceDemo/button_Login'))

// Verify the error message is displayed
boolean isErrorMessageDisplayed = WebUI.verifyElementPresent(findTestObject('Page_SauceDemo/label_ErrorMessage'), 10, FailureHandling.STOP_ON_FAILURE)

if (isErrorMessageDisplayed) {
	WebUI.comment('Error message displayed as expected!')
} else {
	WebUI.comment('Error message not displayed!')
}

// Take a screenshot after validation
WebUI.takeScreenshot()

// Close the browser
WebUI.closeBrowser()
     