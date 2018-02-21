Feature: test set-up routines that run only once, similar to how @BeforeClass works

Background:

* url demoBaseUrl

* table episodes
    | name      | count |
    | 'Episode1'   | 2   |
    | 'Episode2'   | 1   |
    | 'Episode3'   | 3   |

* def result = callonce read('../callarray/webseries-create.feature') episodes

Scenario Outline: various tests on the cats created

    Given path 'webseries'
    When method get
    Then status 200
    And match response[*].name contains '<name>'

Scenario: create a webSeries with episodes

    # again, even though cucumber will re-run the 'Background:' section for each `Scenario:' in a feature file,
    # 'episodes-create.feature' will not be called and the value of 'result' will be retrieved from cache
    * def created = $result[*].response

    Given path 'webseries'
    And request { name: 'MyWebSeries', episodes: '#(created)' }
    When method post
    Then status 200
    And match response.episodes[*].name contains only ['Episode1', 'Episode2', 'Episode3']
    # the ultimate data-driven test
    And match response.episodes[*].name contains only $episodes[*].name




