package testerTool.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "test_request")
public class TestRequestEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @ManyToOne
    private TestEntity testEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_request_id")
    private List<QuestionRequestEntity> questionRequestEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_request_id")
    private List<AdditionalFieldRequestEntity> additionalFieldRequestEntity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TestEntity getTestEntity() {
        return testEntity;
    }

    public void setTestEntity(TestEntity testEntity) {
        this.testEntity = testEntity;
    }

    public List<QuestionRequestEntity> getQuestionRequestEntity() {
        return questionRequestEntity;
    }

    public void setQuestionRequestEntity(List<QuestionRequestEntity> questionRequestEntity) {
        this.questionRequestEntity = questionRequestEntity;
    }

    public List<AdditionalFieldRequestEntity> getAdditionalFieldRequestEntity() {
        return additionalFieldRequestEntity;
    }

    public void setAdditionalFieldRequestEntity(List<AdditionalFieldRequestEntity> additionalFieldRequestEntity) {
        this.additionalFieldRequestEntity = additionalFieldRequestEntity;
    }
}
