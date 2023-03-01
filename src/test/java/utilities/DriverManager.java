package utilities;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	private static final String DRIVER_MAC = "src/test/resources/drivers/chromedriver_mac";
	private static final String DRIVER_MAC_M1 = "src/test/resources/drivers/chromedriver_mac_m1";
	private static final String DRIVER_WINDOWS = "src/test/resources/drivers/chromedriver_windows.exe";

	private static WebDriver driver;
	private static String customSessionId;

	private DriverManager() {
	};

	public static WebDriver getInstance() {
		try {
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", getDriverPath());
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			}
		} catch (Exception e) {
			assertTrue(false, e.getMessage());
		}
		return driver;
	}

	public static String getSessionId() {
		if (customSessionId == null) {
			customSessionId = Util.get6DigitCode() + "";
		}
		return customSessionId;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		if (customSessionId != null) {
			customSessionId = null;
		}
	}

	private static String getDriverPath() throws Exception {
		Properties sProps = System.getProperties();
		String os = sProps.getProperty("os.name").toLowerCase();
		String archType = sProps.getProperty("os.arch").toLowerCase();
		
		System.out.println(os);
		System.out.println(archType);

		if (os.startsWith("mac")) {
			if (archType.startsWith("aarch64")) {
				return DRIVER_MAC_M1;
			} else {
				return DRIVER_MAC;
			}
		} else if (os.startsWith("windows")) {
			return DRIVER_WINDOWS;
		} else {
			throw new Exception("No driver available for your system");
		}
	}

}
