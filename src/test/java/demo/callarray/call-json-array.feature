Feature: calling another feature file in a loop

Background:
* url demoBaseUrl

* def creator = read('webseries-create.feature')
* def episodes = read('episodes.json')
* def result = call creator episodes

# the above could be written in one line as follows
# * def result = call read('webseries-create.feature') read('webseries.json')

* def created = $result[*].response

Scenario: create parent webSeries using episodes

# create parent webseries
Given path 'webseries'
And request { name: 'Series1', episodes: '#(created)' }
When method post
Then status 200
And def seriesfound = response

# get episodes for webseries
Given path 'webseries', seriesfound.id, 'episodes'
When method get
Then status 200
And match each response == { id: '#number', name: '#string' }
And match response[*].name contains ['Episode3', 'Episode5']
And assert response.length == 6



