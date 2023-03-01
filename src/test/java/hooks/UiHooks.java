package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;

public class UiHooks {

	@Before("@UI or @ui")
	public void setUp() throws Exception {
		DriverManager.getInstance();
	}

	@After("@UI or @ui")
	public void cleanUp() {
		DriverManager.tearDown();
	}

}
