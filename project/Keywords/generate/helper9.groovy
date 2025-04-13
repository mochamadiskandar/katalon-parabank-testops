package generate

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class helper9 {
	@Keyword
	def generateRandomData() {

		Random rand = new Random()
		def firstName= "john" + rand.nextInt(10000)

		def data = [
			firstName: firstName,
			lastname: "dev" + rand.nextInt(10000),
			address: "jalan" + rand.nextInt(10000),
			city:"Jakarta",
			state: "Jakarta Raya",
			zipcode: String.format("%05d", rand.nextInt(100000)),
			phone: "0812-" + String.format("%03d", rand.nextInt(1000)) + "-" + String.format("%04d", rand.nextInt(1000)),
			ssn: String.format("%03d", rand.nextInt(1000)) + "-" + String.format("%02d", rand.nextInt(100)) + "-" + String.format("%04d", rand.nextInt(10000)),
			username: firstName,
			password: "demo",
		]

		return data
	}
}