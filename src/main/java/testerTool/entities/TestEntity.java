package testerTool.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "tests")
public class TestEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String name;

    private String description;

    private LocalDateTime creationTime;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "test_id")
    private List<QuestionEntity> questions;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "test_id")
    private List<AdditionalFieldEntity> additionalFields;

    public UUID getId() {
        return id;
    }

    public void setId(int UUID) {
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

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public List<AdditionalFieldEntity> getAdditionalFields() {
        return additionalFields;
    }

    public void setAdditionalFields(List<AdditionalFieldEntity> additionalFields) {
        this.additionalFields = additionalFields;
    }
}
