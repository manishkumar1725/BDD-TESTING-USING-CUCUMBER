package com.example.cucumber_bdd;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature",plugin = "pretty",glue="demo")
public class CucumberBddApplicationTests {

}
