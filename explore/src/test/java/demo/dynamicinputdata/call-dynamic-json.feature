Feature: dynamically creating json for a data-driven test

Background:
* url demoBaseUrl

* def creator = read('../readfeaturejson/webseries-create.feature')

* def episodesFn =
"""
function(count) {
  var out = [];
  for (var i = 0; i < count; i++) { 
    out.push({ name: 'Episode' + i });
  }
  return out;
}
"""

Scenario: create episodes and validate

* def episodes = call episodesFn 5
* def result1 = call creator episodes
* def created = $result1[*].response
* assert created.length == 5
* match each created == { id: '#number', name: '#regex Episode[0-4]' }
* match created[*].name contains [ 'Episode0', 'Episode1', 'Episode2', 'Episode3', 'Episode4' ]

# for each episode created, 'get by id' and validate
* def result2 = call read('get-webseries.feature') created
* match result2[*].response contains created
