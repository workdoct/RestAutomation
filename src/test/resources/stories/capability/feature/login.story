Meta:
@id login


Scenario: Login to application

Given User should be application Platform <URL>
When user enter username <USERNAME>
And enter password <PASSWORD> and click on submit button
Then HomePage should be displayed
Examples:
|USERNAME|PASSWORD|URL					  |
|workdoct|wkm754  |https://www.freecrm.com|