package chucknorrisfacts.handlers

import static chucknorrisfacts.Constants.BYE_MSG
import static com.amazon.ask.request.Predicates.requestType

import chucknorrisfacts.Constants
import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.model.SessionEndedRequest
import groovy.transform.CompileStatic

@CompileStatic
class SessionEndedRequestHandler implements RequestHandler {

    @Override
    boolean canHandle(HandlerInput input) {
        input.matches(requestType(SessionEndedRequest.class))
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        input.getResponseBuilder()
            .withSpeech(BYE_MSG)
            .withSimpleCard(Constants.SKILL_TITLE, BYE_MSG)
            .withShouldEndSession(true)
            .build()
    }
}
