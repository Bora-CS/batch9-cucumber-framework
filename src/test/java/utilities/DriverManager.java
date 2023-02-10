package utilities;

import java.util.Properties;
<<<<<<< Updated upstream

=======
import java.util.Set;

import org.openqa.selenium.By;
>>>>>>> Stashed changes
import org.openqa.selenium.WebDriver;

public class DriverManager {

	public static final String DRIVER_MAC = "src/test/resources/drivers/chromedriver_mac";
	public static final String DRIVER_MAC_M1 = "src/test/resources/drivers/chromedriver_mac_m1";
	public static final String DRIVER_WINDOWS = "src/test/resources/drivers/chromedriver_windows.exe";

	public static WebDriver driver;

<<<<<<< Updated upstream
	public static String getDriverPath() throws Exception {
		Properties sProps = System.getProperties();
		String os = sProps.getProperty("os.name").toLowerCase();
		String archType = sProps.getProperty("os.arch").toLowerCase();
=======
	public static void main(String[] args) {

		Properties sProps = System.getProperties();
		Set<Object> keys = sProps.keySet();

		for (Object key : keys) {
			System.out.println("Key: " + key + " - Value: " + sProps.get(key));
		}
		}
>>>>>>> Stashed changes

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
