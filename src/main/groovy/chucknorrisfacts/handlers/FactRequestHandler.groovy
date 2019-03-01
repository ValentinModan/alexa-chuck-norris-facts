package chucknorrisfacts.handlers

import static chucknorrisfacts.Constants.SKILL_TITLE

import chucknorrisfacts.icndb.Fact
import chucknorrisfacts.icndb.IcndbService
import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates
import groovy.transform.CompileStatic

@CompileStatic
class FactRequestHandler implements RequestHandler {

    @Override
     boolean canHandle(HandlerInput input) {
         input.matches(Predicates.intentName("FactIntent"))
    }

    @Override
     Optional<Response> handle(HandlerInput input) {
        Fact fact = IcndbService.getRandomFact()
        String speechText = fact.text
        System.out.println("speechText -> " + speechText)

        return input.getResponseBuilder()
            .withSpeech(speechText)
            .withSimpleCard(SKILL_TITLE, speechText)
            .withShouldEndSession(true)
            .build()
    }
}