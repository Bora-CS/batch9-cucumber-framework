package utilities;

import java.util.Properties;
<<<<<<< HEAD
import java.util.Set;

import org.openqa.selenium.By;
=======

>>>>>>> 3d163881e870782f18b360bbb93ad04e375a917a
import org.openqa.selenium.WebDriver;

public class DriverManager {

	public static final String DRIVER_MAC = "src/test/resources/drivers/chromedriver_mac";
	public static final String DRIVER_MAC_M1 = "src/test/resources/drivers/chromedriver_mac_m1";
	public static final String DRIVER_WINDOWS = "src/test/resources/drivers/chromedriver_windows.exe";

	public static WebDriver driver;

<<<<<<< HEAD
	public static void main(String[] args) {
		
		Properties sProps = System.getProperties();
		
		Set<Object> keys = sProps.keySet();

		for (Object key : keys) {
			System.out.println("Key: " + key + " - Value: " + sProps.get(key));
		}

//		try {
//			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver_mac_m1");
//			driver = new ChromeDriver();
//			driver.get("https://boratech-practice-app.onrender.com/");
//			driver.findElement(By.xpath("//*[contains(text(), 'Login')]")).click();
//			Thread.sleep(3000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			driver.quit();
//		}

=======
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
>>>>>>> 3d163881e870782f18b360bbb93ad04e375a917a
	}

}
