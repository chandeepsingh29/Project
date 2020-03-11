Feature: Login Unsuccessful on Mercury Tours Page

Scenario: Validate user is not able to login with invalid details 
	Given User opens a browser
	When User navigates to Mercury Tours Page
	And User enters the invalid details
	Then User should not be able to login