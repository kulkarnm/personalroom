@ignore
Feature: create xml

Scenario:

Given url demoBaseUrl
And path 'webseries'
And request { name: '#(name)' }
When method post
Then status 200

* def id = response.id
