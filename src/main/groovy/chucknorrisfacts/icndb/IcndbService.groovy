package chucknorrisfacts.icndb

import groovy.json.JsonSlurper

class IcndbService {

    private static final URL API_URL = 'http://api.icndb.com/jokes/random/?limitTo=[nerdy]'.toURL()

    /*
{
    "type": "success",
    "value": {
        "id": 536,
        "joke": "Don't worry about tests, Chuck Norris's test cases cover your code too.",
        "categories": ["nerdy"]
    }
}
     */

    static Fact getRandomFact() {
        def response = new JsonSlurper().parse(API_URL)
        new Fact(text: response.value.joke, factId: response.value.id)
    }
}
