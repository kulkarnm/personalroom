Feature: create webseries

Background:
* url demoBaseUrl

Scenario: create webseries

# create bob webSeries
Given path 'webseries'
And request { name: 'MySeries' }
When method post
Then status 200
And def myseries = response

# create wild webSeries
Given path 'webseries'
And request { name: 'YourSeries' }
When method post
Then status 200
And def yourseries = response





