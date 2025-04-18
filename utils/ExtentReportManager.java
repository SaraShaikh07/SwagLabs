package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getExtentReports() {
		if (extent == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
			reporter.config().setReportName("SauceDemo Test Report");
			reporter.config().setDocumentTitle("Automation Report");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}
}
