@ignore
Feature: re-usable feature to create a single webSeries

Scenario:

# just to demo that we have two special variables __loop and __arg
* match __arg == karate.get('episodes[' + __loop + ']')

Given url demoBaseUrl
And path 'webseries'
And request { name: '#(name)' }
When method post
Then status 200






