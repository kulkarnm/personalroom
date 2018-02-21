Feature: karate syntax

Scenario: demo of json handling

* def mywebseries =
"""
{
  name: 'mywebseries',
  episodes: [
      { id: 23, name: 'epic23' },
      { id: 42, name: 'epic42' }
  ]
} 
"""
* match mywebseries.episodes contains { id: 42, name: 'epic42' }

* match mywebseries.episodes contains { id: '#? _ > 25', name: '#string' }




