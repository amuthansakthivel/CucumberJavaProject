package stepdefinitions;

import io.cucumber.java.en.*;

public class Login {


	
	@Given("^I am on login page$")
    public void navigateToLoginPage() throws Throwable {
		System.out.println("in login page");
		System.out.println("Sceario name is "+Hook.testdata.get("scenarioName"));
	}
	
	@And("^I login using username and password$")
    public void enterUsername_Password() throws Throwable {
		System.out.println("logged in");
		System.out.println("Sceario name is "+Hook.testdata.get("scenarioName"));
	}
	
	

}
