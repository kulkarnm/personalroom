Feature: webseries with episodes

Background:
* url demoBaseUrl

Scenario: create webSeries with episodes

# create series1 webSeries
Given path 'webseries'
And request { name: 'series1' }
When method post
Then status 200
And def series1 = response

# create series2 webSeries
Given path 'webseries'
And request { name: 'series2' }
When method post
Then status 200
And def series2 = response

# create mom webSeries
Given path 'webseries'
# sometimes, enclosed javascript is more convenient than embedded expressions
And request ({ name: 'series3', episodes: [epic1, epic2] })
When method post
Then status 200
And match response == read('billie-expected.json')
And def billie = response

# get episodes for billie
Given path 'webseries', billie.id, 'episodes'
When method get
Then status 200
And match each response == { id: '#number', name: '#string' }
And match response contains { id: '#(wild.id)', name: 'Wild' }



