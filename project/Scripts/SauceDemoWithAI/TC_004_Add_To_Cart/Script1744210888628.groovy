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

//// Open the SauceDemo login page
//WebUI.openBrowser('')
//WebUI.navigateToUrl('https://www.saucedemo.com/')
//
//// Input valid username
//WebUI.setText(findTestObject('Page_SauceDemo/input_Username'), 'standard_user')
//
//// Input valid password
//WebUI.setText(findTestObject('Page_SauceDemo/input_Password'), 'secret_sauce')
//
//// Click the login button
//WebUI.click(findTestObject('Page_SauceDemo/button_Login'))

WebUI.callTestCase(findTestCase('SauceDemoWithAI/TC_001_Login_Valid'), [:], FailureHandling.STOP_ON_FAILURE)

// Add a product to the cart (e.g., "Sauce Labs Backpack")
WebUI.click(findTestObject('Page_SauceDemo/button_AddToCart_Backpack'))

// Navigate to the cart
WebUI.click(findTestObject('Page_SauceDemo/button_Cart'))

// Verify that the product appears in the cart
boolean isProductInCart = WebUI.verifyElementPresent(findTestObject('Page_SauceDemo/label_ProductInCart'), 10, FailureHandling.STOP_ON_FAILURE)

if (isProductInCart) {
    WebUI.comment('Product is successfully added to the cart!')
} else {
    WebUI.comment('Product is NOT found in the cart!')
}

// Take a screenshot after validation
WebUI.takeScreenshot() 

// Call the test case for logging out
WebUI.callTestCase(findTestCase('SauceDemoWithAI/TC_003_Logout'), [:], FailureHandling.STOP_ON_FAILURE) 

// Close the browser
WebUI.closeBrowser() 

