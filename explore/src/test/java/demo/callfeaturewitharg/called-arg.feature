@ignore
Feature: using __arg

Scenario:
Given url demoBaseUrl
And path 'webseries'
And request __arg
When method post
Then status 200
