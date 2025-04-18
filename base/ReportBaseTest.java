
package base;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.*;

import utils.ExtentReportManager;
import utils.ScreenshotUtil;

public class ReportBaseTest extends BaseTest {

    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getExtentReports();
       
        File screenshotDir = new File("test-output/screenshots/");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }
    }

    @BeforeMethod
    public void setupTest(Method method) {
        setup();
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDownTest(ITestResult result) {
    try
    {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            test.fail("Test Failed: " + result.getThrowable());
            if (screenshotPath != null) {
            test.addScreenCaptureFromPath(screenshotPath);
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped: " + result.getThrowable());
        }
        } catch (Exception e) {
            e.printStackTrace();
            test.warning("⚠️ Error occurred during result logging or screenshot capture.");
        } finally {

        tearDown();
    }
}
    @AfterSuite
    public void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
