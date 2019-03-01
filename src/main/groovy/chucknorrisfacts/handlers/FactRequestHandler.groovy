package chucknorrisfacts.handlers

import static chucknorrisfacts.Constants.SKILL_TITLE

import chucknorrisfacts.icndb.Fact
import chucknorrisfacts.icndb.IcndbService
import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@Slf4j
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
        log.debug "speechText -> {}", speechText

        return input.getResponseBuilder()
            .withSpeech(speechText)
            .withSimpleCard(SKILL_TITLE, speechText)
            .withShouldEndSession(true)
            .build()
    }
}