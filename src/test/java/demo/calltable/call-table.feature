Feature: calling another feature file in a loop

Background:
* url demoBaseUrl

* table episodes
    | name          | count    |
    | 'Episode1'    | 2        |
    | 'Episode2'    | 1        |
    | 'Episode3'    | 3        |
    | 'Episode4'    | 5        |
    | 'Episode5'    | 3        |
    | 'Episode6'    | 2        |

* def result = call read('episode-create.feature') episodes

# use json-path to 'un-pack' the array of episodes created
* def created = $result[*].response

# for each iteration, a variable called '__loop' is set for convenience
# which can be accessed in the called feature as well
* match result[*].__loop == [0, 1, 2, 3, 4, 5]

# which is not even needed for most data-driven assertions
* match created[*].name == $episodes[*].name

Scenario: create parent webSeries using episodes

# create webSeries
Given path 'webseries'
And request { name: 'MyWebSeries', episodes: '#(created)' }
When method post
Then status 200
# the '^^' is an embeddable short-cut for 'contains only' !
And match response == { id: '#number', name: 'MyWebSeries', episodes: '#(^^created)' }

# get episodes for billie using the id from the previous response
Given path 'webseries', $.id, 'episodes'
When method get
Then status 200

# some demo match examples
* match each response == { id: '#number', name: '#string' }
* match response == "#[6] { id: '#number', name: '#string' }"

# pure data-driven assertion, compare with the original data
* match response[*].name contains only $episodes[*].name

* assert response.length == 6
# prefer match instead of assert
* match response == '#[6]'



