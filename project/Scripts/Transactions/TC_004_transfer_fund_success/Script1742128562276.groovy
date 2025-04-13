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
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement as Keys

WebUI.callTestCase(findTestCase('UserAuthentication/TC_001_valid_login'), [('username') : 'john', ('password') : 'demo'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Dashboard/nav_transferFunds'))

WebUI.waitForElementPresent(findTestObject('Page_TransferFunds/label_TransferPageTitle'), 10)

WebUI.setText(findTestObject('Page_TransferFunds/input_amount'), '100')

// Ambil kembali nilai yang diinput menggunakan getAttribute, bukan getText!
String amountInput = WebUI.getAttribute(findTestObject('Page_TransferFunds/input_amount'), 'value')

//------------------------------------------------------------------------------------
// get all elemen dari dropdown fromAcount
TestObject fromAccountDropdown = findTestObject('Page_TransferFunds/dropdown_fromAccount')
WebUI.waitForElementPresent(fromAccountDropdown, 10)

List<TestObject> optionsFromAccount = WebUI.findWebElements(fromAccountDropdown, 10)

//check dropdown and select by index
if (optionsFromAccount.size() > 0) {
	WebUI.selectOptionByIndex(fromAccountDropdown, 0) // pilih option pertama
} else {
	WebUI.comment("Tidak ada opsi pada dropdown fromAccount")
}

String selectFromAccount = WebUI.getText(findTestObject('Page_TransferFunds/select_fromAccount'))
println('Rekening Sumber yang dipilih:' + selectFromAccount)
WebUI.comment('Rekening Sumber yang dipilih:' + selectFromAccount)

//------------------------------------------------------------------------------------

// get all elemen dari dropdown toAcount
TestObject toAccountDropdown = findTestObject('Page_TransferFunds/dropdown_toAccount')
WebUI.waitForElementPresent(findTestObject('Page_TransferFunds/dropdown_toAccount'), 10)

List<TestObject> optionsToAccount = WebUI.findWebElements(toAccountDropdown, 10)

//check dropdown and select by index
if (optionsToAccount.size() > 0) {
	WebUI.selectOptionByIndex(toAccountDropdown, 1) // pilih option kedua
} else {
	WebUI.comment("Tidak ada opsi pada dropdown toAccount")
}

String selectToAccount = WebUI.getText(findTestObject('Page_TransferFunds/select_toAccount'))
println('Rekening Tujuan yang dipilih:' + selectToAccount)
WebUI.comment('Rekening Tujuan yang dipilih:' + selectToAccount)

//------------------------------------------------------------------------------------
// jika pilih fromAccount dan to Acount secara manual - *disable
//WebUI.selectOptionByValue(findTestObject('Page_TransferFunds/dropdown_fromAccount'), account, false)
//WebUI.selectOptionByValue(findTestObject('Page_TransferFunds/dropdown_toAccount'), account, false)

WebUI.click(findTestObject('Page_TransferFunds/button_transfer'))

// Mengecek apakah transfer berhasil
WebUI.waitForElementPresent(findTestObject('Page_TransferFunds/label_transferComplete'), 10)

WebUI.verifyMatch(WebUI.getText(findTestObject('Page_TransferFunds/label_transferComplete')), 'Transfer Complete!', false, 
    FailureHandling.STOP_ON_FAILURE)

// Verifikasi --------------------------------------------------------------------------

WebUI.waitForElementVisible(findTestObject('Page_TransferFunds/label_transferDetails'), 10)

// Verifikasi total amount
String actualAmount = WebUI.getText(findTestObject('Page_TransferFunds/span_amountResult'))
String expectedAmount = ('$' + amountInput) + '.00'
WebUI.verifyMatch(actualAmount, expectedAmount, false, FailureHandling.STOP_ON_FAILURE)

// Verifikasi fromAccount
String actualFromAccount = WebUI.getText(findTestObject('Page_TransferFunds/span_fromAccountResult'))
String expectedFromAccount = selectFromAccount
WebUI.verifyMatch(actualFromAccount, expectedFromAccount, false, FailureHandling.STOP_ON_FAILURE)

// Verifikasi toAccount
String actualToAccount = WebUI.getText(findTestObject('Page_TransferFunds/span_toAccountResult'))
String expectedToAccount = selectToAccount
WebUI.verifyMatch(actualToAccount, expectedToAccount, false, FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot(FailureHandling.OPTIONAL)

