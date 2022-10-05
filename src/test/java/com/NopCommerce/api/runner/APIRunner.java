package com.NopCommerce.api.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

@CucumberOptions(
		tags = "@API",
		features = "src/test/java/com/NopCommerce/api/feature",
		glue = {"com.NopCommerce.api.stepdefenition",
				 "com.NopCommerce.api.hooks",
		},
		plugin = {"pretty","json:target/API_cucumber.json"}
		)

public class APIRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = false) //For Non parallel execution set parallel = false
	@Override
	public Object[][] scenarios() { //Override method in the abstract class
		return super.scenarios();    //Returns a 2D array of all scenarios features
		
}
	
	@AfterSuite
    public static void teardown() {
        try {            
            File reportOutputDirectory = new File("target/API_maven-cucumber-report");
            List<String> jsonFiles = new ArrayList<String>();
            jsonFiles.add("target/API_cucumber.json");
            Configuration configuration = new Configuration(reportOutputDirectory, "NopCommerce");
            configuration.setBuildNumber("1");
            configuration.addClassifications("Environment", "QA");
            configuration.addClassifications("Platform", "Windows");
            configuration.addClassifications("Browser", "Chrome");
            configuration.setSortingMethod(SortingMethod.NATURAL);
            configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
            configuration.setTrendsStatsFile(new File("target/API_demo-trends.json"));
            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            reportBuilder.generateReports();
            
           
        }catch(Exception e) {
            e.printStackTrace();}
    }
}
