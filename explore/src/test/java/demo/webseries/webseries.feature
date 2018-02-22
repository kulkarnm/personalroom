Feature: webseries end-point

Background:
* url demoBaseUrl
* configure logPrettyRequest = true
* configure logPrettyResponse = true

Scenario: create and retrieve a webSeries

# create a new webSeries
Given path 'webseries'
And request { name: 'mywebseries' }
When method post
Then status 200
And match response == { id: '#number', name: 'mywebseries' }

* def id = response.id

# get by id
Given path 'webseries', id
When method get
Then status 200
And match response == { id: '#(id)', name: 'mywebseries' }

# get all webseries
Given path 'webseries'
When method get
Then status 200
And match response contains { id: '#(id)', name: 'mywebseries' }

# get webSeries but ask for xml
Given path 'webseries', id
And header Accept = 'application/xml'
When method get
Then status 200
And match response == <webSeries><id>#(id)</id><name>mywebseries</name></webSeries>



