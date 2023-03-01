package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DataManager;

public class ApiHooks {

	@Before("@API or @api")
	public void setUp() throws Exception {
		DataManager.getInstance();
	}

	@After("@API or @api")
	public void cleanUp() {
		DataManager.cleanUp();
	}

}
