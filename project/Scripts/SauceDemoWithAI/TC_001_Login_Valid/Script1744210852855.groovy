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
 *  Automate the login process for the SauceDemo website and verify the login success.
 *
 *  1. Open a web browser and navigate to the SauceDemo login page.
 *  2. Input the username and password into the respective fields.
 *  3. Click the login button to attempt to log in.
 *  4. Verify if the inventory page header is present to confirm successful login.
 *  5. Log a message indicating whether the login was successful or failed.
 *  6. Take a screenshot of the current state of the browser.
 *  7. Close the browser (this step is not executed in this instance).
 *
 */


// Open the SauceDemo login page
WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

// Input username
WebUI.setText(findTestObject('Page_SauceDemo/input_Username'), 'standard_user')

// Input password
WebUI.setText(findTestObject('Page_SauceDemo/input_Password'), 'secret_sauce')

// Click the login button
WebUI.click(findTestObject('Page_SauceDemo/button_Login'))

// Verify login success by checking the presence of the inventory page header
boolean isLoginSuccessful = WebUI.verifyElementPresent(findTestObject('Page_SauceDemo/header_Inventory'), 10, FailureHandling.STOP_ON_FAILURE)

if (isLoginSuccessful) {
    WebUI.comment('Login successful!')
} else {
    WebUI.comment('Login failed!')
}

WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)

// Close the browser
not_run: WebUI.closeBrowser()
      

