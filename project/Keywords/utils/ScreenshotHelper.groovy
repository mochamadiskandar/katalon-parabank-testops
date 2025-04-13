package utils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class ScreenshotHelper {
	/**
	 * take screenshot with dynamic name
	 * @param fileName: the name of ss file (without the .png extension)
	 * @param filePath: the name of ss file (without the .png extension)
	 * 
	 */

	@Keyword
	def takeScreenshot() {
		String executionName = RunConfiguration.getExecutionSourceName()
		String timestamp = new Date().format("yyyyMMdd_HHmmss")

		String testCasePath = RunConfiguration.getExecutionSourceId() // Dapatkan full path Test Case
		String testCaseName = testCasePath.tokenize('/').last() // Ambil nama Test Case terakhir dari path
		println(testCasePath)
		println(testCaseName)

		String fileName = "${testCaseName}_${timestamp}.png"
		String filePath = RunConfiguration.getProjectDir() + "/Screenshots/" + fileName
		WebUI.takeScreenshot(filePath)
		println("Screenshot saved at: " + filePath)
	}
}
