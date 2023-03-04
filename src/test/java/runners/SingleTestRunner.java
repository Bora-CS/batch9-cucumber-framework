package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/html-report/index.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "dataTransform, apiStepDefinitions, uiStepDefinitions, hooks")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Login and @UI and @Smoke")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
public class SingleTestRunner {
}
