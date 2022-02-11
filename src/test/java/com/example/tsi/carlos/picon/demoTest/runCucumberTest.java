package com.example.tsi.carlos.picon.demoTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/Cucumber",
        glue="com.example.tsi.carlos.picon.demo")
public class runCucumberTest {


}
