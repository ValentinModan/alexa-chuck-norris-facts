package chucknorrisfacts.handlers;

import static chucknorrisfacts.Constants.SKILL_TITLE;

import chucknorrisfacts.icndb.Fact;
import chucknorrisfacts.icndb.IcndbService;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class FactRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("FactIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Optional<Fact> fact = IcndbService.getRandomFact();
        String speechText = fact
                .map(Fact::getText)
                .orElse("There was a problem getting a fact");

        System.out.println("speechText -> " + speechText);

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(SKILL_TITLE, speechText)
                .withShouldEndSession(true)
                .build();
    }
}