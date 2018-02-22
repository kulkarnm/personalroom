Feature: webseries with episodes

Background:
* url demoBaseUrl

Scenario: create webSeries with episodes

# create series1 webSeries
Given path 'webseries'
And request { name: 'MySeries' }
When method post
Then status 200
And def series1 = response

# create series2 webSeries
Given path 'webseries'
And request { name: 'YourSeries' }
When method post
Then status 200
And def series2 = response

# create mom webSeries
Given path 'webseries'
And request ({ name: 'ThirdSeries', episodes: [series1, series2] })
When method post
Then status 200
And match response == read('thirdseries-expected.json')
And def series3 = response

# get episodes for ThirdSeries
Given path 'webseries', series3.id, 'episodes'
When method get
Then status 200
And match each response == { id: '#number', name: '#string' }
And match response contains { id: '#(series2.id)', name: 'YourSeries' }



