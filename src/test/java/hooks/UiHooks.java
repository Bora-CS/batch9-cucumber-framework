package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;
import utilities.PageManager;

public class UiHooks {

	@Before("@UI or @ui")
	public void setUp() throws Exception {
		DriverManager.getInstance();
		PageManager.getInstance();
	}

	@After("@UI or @ui")
	public void cleanUp() {
		DriverManager.tearDown();
		PageManager.cleanup();
	}

}
