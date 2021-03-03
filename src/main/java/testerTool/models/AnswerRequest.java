package testerTool.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class AnswerRequest {
    private UUID id;
    @JsonProperty("isCorrect")
    private boolean isCorrect;

    public AnswerRequest() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
