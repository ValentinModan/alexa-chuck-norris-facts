package chucknorrisfacts;

import static chucknorrisfacts.Constants.BYE_MSG;
import static chucknorrisfacts.Constants.HELP_MSG;
import static chucknorrisfacts.Constants.SKILL_TITLE;

import chucknorrisfacts.icndb.Fact;
import chucknorrisfacts.icndb.IcndbClient;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import io.micronaut.function.aws.alexa.AlexaIntents;
import io.micronaut.function.aws.alexa.annotation.IntentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class AlexaApplication {

    private static final Logger LOG = LoggerFactory.getLogger(AlexaApplication.class);

    private final IcndbClient icndbClient;

    public AlexaApplication(IcndbClient icndbClient) {
        this.icndbClient = icndbClient;
    }

    @IntentHandler({AlexaIntents.CANCEL, AlexaIntents.STOP})
    public Optional<Response> cancel(HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech(BYE_MSG)
                .withSimpleCard(Constants.SKILL_TITLE, BYE_MSG)
                .withShouldEndSession(true)
                .build();
    }

    @IntentHandler(AlexaIntents.HELP)
    public Optional<Response> help(HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech(HELP_MSG)
                .withSimpleCard(Constants.SKILL_TITLE, HELP_MSG)
                .withReprompt(HELP_MSG)
                .build();
    }

    @IntentHandler("FactIntent")
    public Optional<Response> fact(HandlerInput input) {
        Optional<Fact> fact = icndbClient.getRandomFact();
        String speechText = fact
                .map(Fact::getText)
                .orElse("There was a problem getting a fact");
        LOG.info("speechText -> {}", speechText);

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard(SKILL_TITLE, speechText)
                .withShouldEndSession(true)
                .build();
    }
}
