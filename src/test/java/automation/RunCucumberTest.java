package automation;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
<<<<<<< HEAD
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("automation")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:target/html-report/index.html")
=======

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("automation")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/html-report/index.html")
>>>>>>> 8d5515dac4ebbf7808996bf12f79ed6fc6cdd93b
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "automation")
public class RunCucumberTest {
}
