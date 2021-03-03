package testerTool.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.UUID;

public class TestRequest {
    private UUID id;
    @JsonProperty("additionalFields")
    private Map<UUID, AdditionalFieldRequest> additionalFields;
    @JsonProperty("additionalFields")
    private Map<UUID, QuestionRequest> questions;

    public TestRequest() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Map<UUID, AdditionalFieldRequest> getAdditionalFields() {
        return additionalFields;
    }

    public void setAdditionalFields(Map<UUID, AdditionalFieldRequest> additionalFields) {
        this.additionalFields = additionalFields;
    }

    public Map<UUID, QuestionRequest> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<UUID, QuestionRequest> questions) {
        this.questions = questions;
    }
}
