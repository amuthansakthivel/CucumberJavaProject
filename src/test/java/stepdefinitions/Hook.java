package stepdefinitions;


import java.io.PrintStream;
import java.io.StringWriter;
import java.util.HashMap;

import org.apache.commons.io.output.WriterOutputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.reports.ExtentManager;
import com.reports.ExtentReport;
import com.reports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook {

	public static HashMap<String, String> testdata;
	public static HashMap<String, HashMap<String, String>> testdata1;
	public static WebDriver driver;
	public static String currentScenario;
	protected StringWriter writer;
	protected PrintStream captor;

	@Before
	public void setUp(Scenario scenario) {
		testdata = new HashMap<String, String>();
		currentScenario = scenario.getName();
		testdata.put("scenarioName", scenario.getName());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		System.out.println(scenario.getId() + "-->"+ scenario.getName() +"--->"+scenario.getLine()+"-->"+scenario.getSourceTagNames());
		writer = new StringWriter();
		captor = new PrintStream(new WriterOutputStream(writer), true);
		ExtentManager.setExtentTest(ExtentReport.extent.createTest(scenario.getName()));
		//ExtentManager.getExtTest().createNode(scenario.getId());

	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("after");
		if(scenario.getStatus().toString().equalsIgnoreCase("passed")) {
			LogStatus.pass(scenario.getName()+" is passed");
		}
		else {
			LogStatus.fail( scenario.getName()+" is failed");
		}
		//ExtentReport.extent.endTest(ExtentManager.getExtTest());

	}


	public void writeRequestAndResponseInReport(String request,String response) {

		LogStatus.info("---- Request ---");
		formatAPIAndLogInReport(request);
		LogStatus.info("---- Response ---");
		formatAPIAndLogInReport(response);
	}

	/*
	 * Format the api string and log in Extent Report
	 * @author : Amuthan Sakthivel
	 * @param  : apicontent
	 */
	protected void formatAPIAndLogInReport(String content) {

		String prettyPrint = content.replace("\n", "<br>");
		LogStatus.info("<pre>" + prettyPrint + "</pre>");

	}


	static {
		testdata1 = new HashMap<String, HashMap<String, String>>();
//		testdata1.get(currentScenario).get("username");
		System.out.println("ab");
	}

	@BeforeStep
	public void BeforeEveryStep(Scenario scenario) {
		System.out.println("Before every step " + scenario.getId());

		// ((PickleStep)((PickleStepTestStep)
	}

	@AfterStep
	public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
		// System.out.println("Before every step " + stepTestStep.getId());
	}
	
	public static String getData(String colName) {
		return Hook.testdata1.get(Hook.currentScenario).get(colName);
	}

}
