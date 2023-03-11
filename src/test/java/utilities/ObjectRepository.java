package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectRepository {

	private static FileInputStream fis = null;
	private static Properties props = null;

	private static void prepare() {
		try {
			fis = new FileInputStream("src/test/resources/properties/ObjectRepository.properties");
			props = new Properties();
			props.load(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static By locator(String objectName) {

		By locator = null;

		try {
			if (props == null) {
				prepare();
			}

			String value = props.getProperty(objectName);
			String[] parts = value.split("->");
			String locatorType = parts[0].toLowerCase().trim();
			String locatorValue = parts[1].trim();

			switch (locatorType) {
			case "css":
			case "cssselector":
				locator = By.cssSelector(locatorValue);
				break;
			case "xpath":
				locator = By.xpath(locatorValue);
				break;
			case "name":
				locator = By.name(locatorValue);
				break;
			case "linktext":
			case "partiallinktext":
				locator = By.partialLinkText(locatorValue);
				break;
			case "text":
				locator = By.xpath("//*[contains(text(), " + locatorValue + ")]");
				break;
			case "id":
				locator = By.id(locatorValue);
				break;
			case "classname":
			case "class":
				locator = By.className(locatorValue);
				break;
			case "tagname":
			case "tag":
				locator = By.tagName(locatorValue);
				break;
			default:
				throw new Exception("Locator type [" + locatorType + "] is not supported");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return locator;
	}

}
