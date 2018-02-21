Feature: calling another feature file

Background:
* url demoBaseUrl

Scenario: calling a feature with parameters
    * def result = call read('called-normal.feature') { name: 'MySeries', epiccount: 10 }
    * def series = result.response
    * match series == { id: '#number', name: 'MySeries' }

Scenario: called feature uses '__arg', you can use variable references as the call argument
    * def series = { name: 'MySeries' }
    * def result = call read('called-arg.feature') series
    * match result.response contains series

Scenario: called features will inherit parent scope
    # this variable will be available in the called feature
    * def name = 'MySeries'
    # and we can call without an argument
    * def result = call read('called-normal.feature')
    * match result.response contains { name: '#(name)' }

Scenario: create episodes and then create parent webSeries
    * def episodes = call read('create-two-webseries.feature')
    * def myseries = episodes.myseries
    * def yourseries = episodes.yourseries

    # create mom webSeries
    Given path 'webseries'
    # sometimes, enclosed javascript is more convenient than embedded expressions
    And request ({ name: 'ThirdSeries', episodes: [myseries, yourseries] })
    When method post
    Then status 200
    And match response == read('../webseries/thirdseries-expected.json')
    And def thirdseries = response

    # get episodes for thirdseries
    Given path 'webseries', thirdseries.id, 'episodes'
    When method get
    Then status 200
    And match each response == { id: '#number', name: '#string' }
    And match response contains { id: '#(yourseries.id)', name: 'YourSeries' }
