package testerTool.models;

import java.util.List;
import java.util.UUID;

public class TestModel {
    private UUID id;
    private String name;
    private String description;
    private List<String> additionalFields;
    private List<Question> questions;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAdditionalFields() {
        return additionalFields;
    }

    public void setAdditionalFields(List<String> additionalFields) {
        this.additionalFields = additionalFields;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", additionalFields=" + additionalFields +
                ", questions=" + questions +
                '}';
    }
}
