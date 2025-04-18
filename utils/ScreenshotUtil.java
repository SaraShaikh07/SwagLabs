package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Path dest = Paths.get("test-output", "screenshots", screenshotName + ".png");
			Files.createDirectories(dest.getParent()); // Ensure the folder exists
			Files.copy(src.toPath(), dest, StandardCopyOption.REPLACE_EXISTING); // 🔄 Overwrite if exists
			return dest.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
