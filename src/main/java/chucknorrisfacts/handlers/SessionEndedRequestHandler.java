package chucknorrisfacts.handlers;

import static chucknorrisfacts.Constants.BYE_MSG;
import static com.amazon.ask.request.Predicates.requestType;

import chucknorrisfacts.Constants;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;

import java.util.Optional;

public class SessionEndedRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(SessionEndedRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech(BYE_MSG)
                .withSimpleCard(Constants.SKILL_TITLE, BYE_MSG)
                .withShouldEndSession(true)
                .build();
    }
}
