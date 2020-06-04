package com.cucumber.hooks;

import com.cucumber.driver.DriverSingletonFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void browserSetup() {
        DriverSingletonFactory.getDriver();
    }

    @After
    public void browserTearDown() {
        DriverSingletonFactory.closeDriver();
    }
}
