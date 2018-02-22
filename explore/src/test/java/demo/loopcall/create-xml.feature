@ignore
Feature: create xml

Scenario:

Given url demoBaseUrl
And path 'webseries'
And header Accept = 'application/xml'
And request <webSeries><name>#(name)</name></webSeries>
When method post
Then status 200

* def id = /webSeries/id