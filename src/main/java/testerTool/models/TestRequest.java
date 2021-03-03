package testerTool.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class TestRequest {
    private UUID id;
    @JsonProperty("additionalFields")
    private List<AdditionalFieldRequest> additionalFields;
    @JsonProperty("questions")
    private List<QuestionRequest> questions;

    public TestRequest() {
    }

    public TestRequest(UUID id, List<AdditionalFieldRequest> additionalFields, List<QuestionRequest> questions) {
        this.id = id;
        this.additionalFields = additionalFields;
        this.questions = questions;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<AdditionalFieldRequest> getAdditionalFields() {
        return additionalFields;
    }

    public void setAdditionalFields(List<AdditionalFieldRequest> additionalFields) {
        this.additionalFields = additionalFields;
    }

    public List<QuestionRequest> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionRequest> questions) {
        this.questions = questions;
    }
}
