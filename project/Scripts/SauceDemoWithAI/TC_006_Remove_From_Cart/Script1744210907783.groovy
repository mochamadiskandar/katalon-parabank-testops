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

// create script for saucedemo, for feature remove product from cart and validate that
// Open the SauceDemo website
WebUI.openBrowser('https://www.saucedemo.com')

// Input username
WebUI.setText(findTestObject('Object Repository/SauceDemo/username'), 'standard_user')

// Input password
WebUI.setText(findTestObject('Object Repository/SauceDemo/password'), 'secret_sauce')

// Click on the login button
WebUI.click(findTestObject('Object Repository/SauceDemo/login_button'))

// Add a product to the cart
WebUI.click(findTestObject('Object Repository/SauceDemo/add_to_cart_button'))

// Navigate to the cart
WebUI.click(findTestObject('Object Repository/SauceDemo/cart_icon'))

// Remove the product from the cart
WebUI.click(findTestObject('Object Repository/SauceDemo/remove_button'))

// Validate that the cart is empty
WebUI.verifyElementNotPresent(findTestObject('Object Repository/SauceDemo/cart_item'), 0)