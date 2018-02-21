Feature: demo reading files and using in a test

Background:
* url demoBaseUrl
# a POST to /echo will simply echo the request payload
* path '/webseries'

Scenario: using json from a file
    * table nwebseries
        | episode1      | episode2      |
        | 'Episode1'    | 'Episode2'    |
        | 'Episode3'    | 'Episode4'    |
    Given request ({ nwebseries: nwebseries })
    When method post
    Then status 200
    And match $ == read('sample.json')

