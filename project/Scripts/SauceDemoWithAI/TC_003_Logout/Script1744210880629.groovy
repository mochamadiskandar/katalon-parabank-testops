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

WebUI.callTestCase(findTestCase('SauceDemoWithAI/TC_001_Login_Valid'), [:], FailureHandling.STOP_ON_FAILURE)

// Calls a test case to log in with valid credentials
WebUI.click(findTestObject('Page_SauceDemo/button_Menu'))

// Clicks the menu button to open the menu
WebUI.click(findTestObject('Page_SauceDemo/btn_Logout'))

// Clicks the logout button to log out the user
boolean isLoginPageDisplayed = WebUI.verifyElementPresent(findTestObject('Page_SauceDemo/input_Username'), 10, FailureHandling.STOP_ON_FAILURE)

// Verifies if the login page is displayed by checking the presence of the username input field
if (isLoginPageDisplayed) {
    // Checks if the login page is displayed
    WebUI.comment('User is redirected to the login page as expected!') // Logs a message indicating the user is redirected to the login page
    // If the login page is not displayed
    // Logs a message indicating the user is not redirected to the login page
} else {
    WebUI.comment('User is NOT redirected to the login page!')
}

WebUI.takeScreenshot()

// Takes a screenshot after validation
WebUI.closeBrowser()

