package utilities;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	public static final String DRIVER_MAC = "src/test/resources/drivers/chromedriver_mac";
	public static final String DRIVER_MAC_M1 = "src/test/resources/drivers/chromedriver_mac_m1";
	public static final String DRIVER_WINDOWS = "src/test/resources/drivers/chromedriver_windows.exe";

	public static WebDriver driver;

	public static String getDriverPath() throws Exception {
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
