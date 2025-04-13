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

// Open a new browser window
WebUI.openBrowser('')

// Navigate to the specified URL
WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.verifyElementPresent(findTestObject('Page_Swag Labs/h4_Accepted usernames are'), 0)

WebUI.verifyElementPresent(findTestObject('Page_Swag Labs/h4_Password for all users'), 0)

// Set the username in the input field
WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), 'standard_user')

// Set the password in the input field
WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_password'), 'secret_sauce')

// Click the login button to submit the form
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button'))

// Verify that the products span is visible after logging in
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Swag Labs/span_Products'))

WebUI.verifyElementVisible(findTestObject('Page_Swag Labs/div_Sauce Labs Backpack'))

WebUI.verifyElementVisible(findTestObject('Page_Swag Labs/div_Sauce Labs Bike Light'))

not_run: WebUI.waitForElementClickable(findTestObject('Page_Swag Labs/button_Open Menu'), 0)

// Click the button to open the menu
not_run: WebUI.click(findTestObject('Page_Swag Labs/button_Open Menu'))

// Click the logout link to log out of the application
not_run: WebUI.click(findTestObject('Page_Swag Labs/a_Logout'))

// Tunggu sebentar sebelum next login
//    WebUI.delay(2)
//}
// Close the browser window
WebUI.closeBrowser()

