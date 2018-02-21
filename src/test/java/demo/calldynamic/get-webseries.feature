@ignore
Feature:

Background:
* url demoBaseUrl

Scenario:
Given path 'webseries', id
When method get
Then status 200
