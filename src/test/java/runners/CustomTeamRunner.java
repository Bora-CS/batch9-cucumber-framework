package runners;

import static io.cucumber.junit.platform.engine.Constants.*;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/teamWork.feature")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/html-report/index.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value ="dataTransform, uiStepDefinitions, hooks")
@ConfigurationParameter(key =SNIPPET_TYPE_PROPERTY_NAME, value ="camelcase" )
@ConfigurationParameter(key =EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key =FILTER_TAGS_PROPERTY_NAME, value = "@done or @ui")
public class CustomTeamRunner {

}
