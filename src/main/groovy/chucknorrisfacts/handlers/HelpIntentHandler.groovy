package chucknorrisfacts.handlers

import static chucknorrisfacts.Constants.HELP_MSG
import static com.amazon.ask.request.Predicates.intentName

import chucknorrisfacts.Constants
import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import groovy.transform.CompileStatic

@CompileStatic
class HelpIntentHandler implements RequestHandler {

    @Override
    boolean canHandle(HandlerInput input) {
        input.matches(intentName("AMAZON.HelpIntent"))
    }

    @Override
    Optional<Response> handle(HandlerInput input) {
        input.getResponseBuilder()
            .withSpeech(HELP_MSG)
            .withSimpleCard(Constants.SKILL_TITLE, HELP_MSG)
            .withReprompt(HELP_MSG)
            .build()
    }
}
