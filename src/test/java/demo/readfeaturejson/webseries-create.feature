@ignore
Feature: re-usable feature to create a single webSeries

Scenario:

Given url demoBaseUrl
And path 'webseries'
And request { name: '#(name)' }
When method post
Then status 200






