Feature: call multiple scenarios but use a common validation routine

Background:
* def types = ['json', 'xml'];
* def webSeries = { name: 'Tom' }
* def fun = read('loop.js')

Scenario: main loop
* def response = fun(types, webSeries)
* assert response.length == 2
* match each response == { id: '#number', name: 'Tom' }
* match each response contains webSeries
* match response == '#[2] ^webSeries'
