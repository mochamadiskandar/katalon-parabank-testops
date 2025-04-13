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

// create script for saucedemo, for feature sortitem by price
// Open the SauceDemo website
WebUI.openBrowser('https://www.saucedemo.com')

// Input username
WebUI.setText(findTestObject('Object Repository/Username_Input'), 'standard_user')

// Input password
WebUI.setText(findTestObject('Object Repository/Password_Input'), 'secret_sauce')

// Click on the login button
WebUI.click(findTestObject('Object Repository/Login_Button'))

// Select the sorting option by price (low to high)
WebUI.selectOptionByValue(findTestObject('Object Repository/Sort_Dropdown'), 'lohi', false)

// Verify that items are sorted by price
// (Assuming there is a method to verify the order of items, which is not implemented here)