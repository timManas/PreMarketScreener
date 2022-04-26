Feature: Chrome - Verify Elements on HomePage

Scenario:
	Given I access prescreen_page
	Then I fetch all data from Most Active
	And I fetch all data from Gainers
	And I fetch all data from Decliners
	Then I put them all into a JSON file
	