package testerTool.models;

import java.util.List;
import java.util.UUID;

public class QuestionRequest {
    private UUID id;
    List<AnswerRequest> answers;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<AnswerRequest> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerRequest> answers) {
        this.answers = answers;
    }
}
