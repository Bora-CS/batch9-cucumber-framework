package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;

public class UiHooks {

	@Before
	public void setUp() throws Exception {
		DriverManager.getInstance();
	}

	@After
	public void cleanUp() {
		DriverManager.tearDown();
	}

}
