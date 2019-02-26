package chucknorrisfacts.handlers;

import static chucknorrisfacts.Constants.SKILL_TITLE;
import static chucknorrisfacts.Constants.WELCOME_MSG;
import static com.amazon.ask.request.Predicates.requestType;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder()
                .withSimpleCard(SKILL_TITLE, WELCOME_MSG)
                .withSpeech(WELCOME_MSG)
                .withReprompt(WELCOME_MSG)
                .build();
    }
}
