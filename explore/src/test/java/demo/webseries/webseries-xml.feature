Feature: webseries end-point and xml

Background:
* url demoBaseUrl
* configure logPrettyRequest = true
* configure logPrettyResponse = true

# responses default to json otherwise
* configure headers = { Accept: 'application/xml' }

Scenario: create and retrieve a webseries

# create a new webseries
Given path 'webseries'
And request <webSeries><name>MyWebSeries</name></webSeries>
When method post
Then status 200
And match response == <webSeries><id>#notnull</id><name>MyWebSeries</name></webSeries>

* def id = /webSeries/id

# get by id
Given path 'webseries', id
When method get
Then status 200
And match response == <webSeries><id>#(id)</id><name>MyWebSeries</name></webSeries>






