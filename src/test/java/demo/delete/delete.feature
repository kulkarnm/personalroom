Feature: delete entity by itself or by id

Background:
* url demoBaseUrl

Given path 'webseries'
And request { name: 'MyWebSeries' }
When method post
Then status 200
* def webSeries = response

Scenario: normal delete without a body

Given path 'webseries', webSeries.id
When method delete
Then status 200

Scenario: delete with a request body

Given path 'webseries'
And request webSeries
When method delete
Then status 200

