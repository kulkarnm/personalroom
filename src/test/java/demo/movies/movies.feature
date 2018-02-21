Feature: books end-point that uses jdbc as part of the test

Background:
* url demoBaseUrl

Scenario: create and retrieve a movie

# create a movie
Given path 'movie'
And request { name: 'ScoobyDo' }
When method post
Then status 200
And match response == { id: '#number', name: 'ScoobyDo' }

* def id = response.id

# get by id
Given path 'movie', id
When method get
Then status 200
And match response == { id: '#(id)', name: 'ScoobyDo' }

# get all dogs
Given path 'movie'
When method get
Then status 200
And match response contains { id: '#(id)', name: 'ScoobyDo' }

# use jdbc to validate
* def config = { username: 'sa', password: '', url: 'jdbc:h2:mem:testdb', driverClassName: 'org.h2.Driver' }
* def DbUtils = Java.type('com.karate.library.demo.util.DbUtils')
* def db = new DbUtils(config)

# since the DbUtils returns a Java Map, it becomes normal JSON here !
# which means that you can use the full power of Karate's 'match' syntax
* def movies = db.readRows('SELECT * FROM MOVIES')
* match movies contains { ID: '#(id)', NAME: 'ScoobyDo' }

* def movie = db.readRow('SELECT * FROM MOVIES M WHERE M.ID = ' + id)
* match movie.NAME == 'ScoobyDo'

* def test = db.readValue('SELECT ID FROM MOVIES M WHERE M.ID = ' + id)
* match test == id
