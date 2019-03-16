# Chuck Norris Facts #

This is an Alexa skill for getting Chuck Norris Facts from http://icndb.com. The facts (jokes) are limited to the
 _nerdy_ type. For every execution the skill will connect the ICNDB API and will get a random fact.

Once deployed and created the Alexa skill, you can start it with:

> Alexa, open Chuck Norris facts

This repository contains 3 branches, each with a different implementation:
- `master`: Alexa SDK, Groovy, Json Slurper.
- `java-micronaut-http-client`: Alexa SDK, Java, Micronaut HTTP low-level client.
- `java-micronaut-alexa`: Java, Micronaut Alexa-AWS support, Micronaut declarative HTTP client.
