package com.revature.employeereimbursementsystem.integration;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

// These allow for this class to be considered a TestRunner class
@Suite
@SelectClasspathResource("features") // To specify the location of test resources we are using
// (look inside of the resources folder in the classpath)
public class IntegrationTestRunner {
}
