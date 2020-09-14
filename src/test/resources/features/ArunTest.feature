Feature: ArunTest

	Scenario: TC_01:Valid login
		Given I am on login page
		And I login using username and password
	
	Scenario: TC_02:Invalid Login
		Given I am on login page
		And I login using username and password