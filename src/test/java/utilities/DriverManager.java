package utilities;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

	private static final String DRIVER_MAC = "src/test/resources/drivers/chromedriver_mac";
	private static final String DRIVER_MAC_M1 = "src/test/resources/drivers/chromedriver_mac_m1";
	private static final String DRIVER_WINDOWS = "src/test/resources/drivers/chromedriver_windows.exe";

	private static ThreadLocal<WebDriver> threadLocalDriver;
	private static ThreadLocal<String> threadLocalSessionId;

	private DriverManager() {
	};

	public static WebDriver getInstance() {
		try {
			if (threadLocalDriver == null) {
				threadLocalDriver = new ThreadLocal<WebDriver>();
			}

			if (threadLocalDriver.get() == null) {
				System.setProperty("webdriver.chrome.driver", getDriverPath());
				ChromeOptions cOption = new ChromeOptions();
				cOption.addArguments("--remote-allow-origins=*");
				WebDriver driver = new ChromeDriver(cOption);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				threadLocalDriver.set(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false, e.getMessage());
		}
		return threadLocalDriver.get();
	}

	public static String getSessionId() {
		if (threadLocalSessionId == null) {
			threadLocalSessionId = new ThreadLocal<String>();
		}

		if (threadLocalSessionId.get() == null) {
			String customSessionId = Util.get6DigitCode() + "";
			threadLocalSessionId.set(customSessionId);
		}
		return threadLocalSessionId.get();
	}

	public static void tearDown() {
		if (threadLocalDriver.get() != null) {
			threadLocalDriver.get().quit();
			threadLocalDriver.set(null);
		}
		if (threadLocalSessionId.get() != null) {
			threadLocalSessionId.set(null);
		}
	}

	private static String getDriverPath() throws Exception {
		Properties sProps = System.getProperties();
		String os = sProps.getProperty("os.name").toLowerCase();
		String archType = sProps.getProperty("os.arch").toLowerCase();

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
