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

//Create a Katalon test case script for "TC 005 - Add Multiple Items" with the following steps:
//
//1. Open SauceDemo login page.
//2. Enter a valid username and password.
//3. Click the "Login" button.
//4. Select two products: "Sauce Labs Backpack" and "Sauce Labs Bike Light".
//5. Click "Add to Cart" for each selected product.
//6. Click the "Cart" icon at the top-right.
//7. Verify that both selected products appear in the cart.
//8. Click the "Menu" button.
//9. Click "Logout" to end the session.
//
//Use best practices for test automation, including:
//- Proper element locators (XPath, CSS).
//- Assertions to verify that both items exist in the cart.
//- Error handling if elements are not found.
//
//Generate the script using **WebUI methods** in **Groovy**.
// Select two products: "Sauce Labs Backpack" and "Sauce Labs Bike Light".
WebUI.callTestCase(findTestCase('SauceDemoWithAI/TC_001_Login_Valid'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_SauceDemo/div_SauceLabsBackpack') // Clicks on the Sauce Labs Backpack product
    )

WebUI.click(findTestObject('Page_SauceDemo/button_AddToCart_Backpack') // Clicks "Add to Cart" for the Backpack
    )

WebUI.click(findTestObject('Page_SauceDemo/div_SauceLabsBikeLight') // Clicks on the Sauce Labs Bike Light product
    )

WebUI.click(findTestObject('Page_SauceDemo/button_addToCartBikeLight') // Clicks "Add to Cart" for the Bike Light
    )

// Click the "Cart" icon at the top-right.
WebUI.click(findTestObject('Page_SauceDemo/link_cartIcon') // Clicks the cart icon
    )

// Verify that both selected products appear in the cart.
WebUI.verifyElementPresent(findTestObject('Page_SauceDemo/div_backpackInCart'), 10 // Verifies Backpack is in the cart
    )

WebUI.verifyElementPresent(findTestObject('Page_SauceDemo/div_bikeLightInCart'), 10 // Verifies Bike Light is in the cart
    )

// Take a screenshot of the current screen
WebUI.takeScreenshot()
	
// Calls a test case for logging out from the application
WebUI.callTestCase(findTestCase('SauceDemoWithAI/TC_003_Logout'), [:], FailureHandling.STOP_ON_FAILURE)

