package testerTool.models;

import java.util.Map;
import java.util.UUID;

public class QuestionRequest {
    private UUID id;
    Map<String, Boolean> answers;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Map<String, Boolean> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, Boolean> answers) {
        this.answers = answers;
    }
}
