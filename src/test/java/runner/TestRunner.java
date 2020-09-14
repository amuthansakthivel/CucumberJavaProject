package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.DataProvider;
import com.constants.Constants;
import com.reports.ExtentReport;

@CucumberOptions(features = {"src/test/resources/runnablefeatures"} , plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue = "stepdefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {


	@BeforeClass
	public static void beforeClass() {
		ExtentReport.initialize();
	}

	@AfterClass
	public static void afterClass() throws IOException {
		ExtentReport.closeReports();

		File htmlFile = new File(Constants.EXTENTREPORTPATH);
		Desktop.getDesktop().browse(htmlFile.toURI());
	}
	
    @Override
    @DataProvider (parallel = true) 
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
