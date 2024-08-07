package com.skillstorm;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
//Junit test suite allows you to group and execute multiple tests
@Suite
//specifies that the test suite should use the cucumber engine to run the tests
@IncludeEngines("cucumber")
//tells test suite to look for your feature file
@SelectClasspathResource("com/skillstorm")

@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")

public class RunCucumberTest {
}
