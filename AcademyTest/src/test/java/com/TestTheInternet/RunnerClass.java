package com.TestTheInternet;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(format= {"pretty","html:target/cucumber-html"},
//tags= {"@login"},
//tags= {"@Scroll"},
//tags= {"@KeyPress"},

				features = {".\\src\\test\\java\\com\\TestCases"},
				glue = {"com.TestTheInternet"})




public class RunnerClass {

	
	
   }
