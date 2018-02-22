@ignore
Feature: the name is expected to be set as a call arg

Scenario:
Given url demoBaseUrl
And path 'webseries'
And request { name: '#(name)' }
When method post
Then status 200
