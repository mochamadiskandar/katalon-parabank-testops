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

// create script for saucedemo, for feature sortitem by name A-Z
// Open the SauceDemo website
WebUI.openBrowser('https://www.saucedemo.com')

// Input username
WebUI.setText(findTestObject('Object Repository/SauceDemo/username'), 'standard_user')

// Input password
WebUI.setText(findTestObject('Object Repository/SauceDemo/password'), 'secret_sauce')

// Click on the login button
WebUI.click(findTestObject('Object Repository/SauceDemo/login_button'))

// Click on the sorting dropdown
WebUI.click(findTestObject('Object Repository/SauceDemo/sort_dropdown'))

// Select the option to sort items by name A-Z
WebUI.selectOptionByLabel(findTestObject('Object Repository/SauceDemo/sort_dropdown'), 'Name (A to Z)', false)

// Verify that the items are sorted by name A-Z
// (Assuming there is a method to verify the order of items, which is not implemented here)

// create script for saucedemo, for feature sortitem by name z-a
// Open the SauceDemo website
WebUI.openBrowser('https://www.saucedemo.com')

// Input username
WebUI.setText(findTestObject('Object Repository/Username_Field'), 'standard_user')

// Input password
WebUI.setText(findTestObject('Object Repository/Password_Field'), 'secret_sauce')

// Click on the login button
WebUI.click(findTestObject('Object Repository/Login_Button'))

// Click on the sorting dropdown
WebUI.click(findTestObject('Object Repository/Sorting_Dropdown'))

// Select the option to sort items by name Z-A
WebUI.selectOptionByLabel(findTestObject('Object Repository/Sorting_Option'), 'Name (Z to A)', false)

// Verify that the items are sorted correctly (this step may require additional implementation based on the application structure)
// Example: WebUI.verifyElementText(findTestObject('Object Repository/First_Item'), 'Expected Item Name')

// Close the browser
WebUI.closeBrowser()