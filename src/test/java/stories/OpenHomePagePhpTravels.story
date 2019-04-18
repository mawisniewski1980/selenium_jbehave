Meta:
@page PHPTRAVELS
@author sternu

Narrative:
As a user
I want to open the Home page
So that I can see the page

Scenario: Open the Home page of PHPTRAVELS.NET

Given open the page on http://www.phptravels.net/
Then check title of the page PHPTRAVELS | Travel Technology Partner
Then wait 5 seconds
Then scroll to bottom
Then wait 2 seconds
Then finish test

