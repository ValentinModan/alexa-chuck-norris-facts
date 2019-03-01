package chucknorrisfacts

import chucknorrisfacts.handlers.FactRequestHandler
import com.amazon.ask.Skill
import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import chucknorrisfacts.handlers.CancelandStopIntentHandler
import chucknorrisfacts.handlers.HelpIntentHandler
import chucknorrisfacts.handlers.LaunchRequestHandler
import chucknorrisfacts.handlers.SessionEndedRequestHandler
import groovy.transform.CompileStatic

@CompileStatic
class ChuckStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills
            .standard()
            .addRequestHandlers(
            new LaunchRequestHandler(),
            new CancelandStopIntentHandler(),
            new SessionEndedRequestHandler(),
            new HelpIntentHandler(),
            new FactRequestHandler()
        )
        // .withSkillId("your-skill-id")
        .build()
    }

    ChuckStreamHandler() {
        super(getSkill())
    }
}
