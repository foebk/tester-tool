package testerTool.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class AdditionalField {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("name")
    private String name;

    public AdditionalField() {
    }

    public AdditionalField(UUID id, String text) {
        this.id = id;
        this.name = text;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return name;
    }

    public void setText(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AdditionalField{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
