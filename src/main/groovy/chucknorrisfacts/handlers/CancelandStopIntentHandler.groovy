package chucknorrisfacts.handlers

import static chucknorrisfacts.Constants.BYE_MSG
import static com.amazon.ask.request.Predicates.intentName

import chucknorrisfacts.Constants
import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import groovy.transform.CompileStatic

@CompileStatic
class CancelandStopIntentHandler implements RequestHandler {

    @Override
    boolean canHandle(HandlerInput input) {
        input.matches(
            intentName("AMAZON.StopIntent")
                .or(intentName("AMAZON.CancelIntent"))
                .or(intentName("AMAZON.NoIntent"))
        )
    }

    @Override
    Optional<Response> handle(HandlerInput input) {
        input.getResponseBuilder()
            .withSpeech(BYE_MSG)
            .withSimpleCard(Constants.SKILL_TITLE, BYE_MSG)
            .withShouldEndSession(true)
            .build()
    }
}
