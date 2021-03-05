package testerTool.entities;

import org.hibernate.annotations.GenericGenerator;
import testerTool.models.TestRequest;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "question_request")
public class QuestionRequestEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_request_id")
    private List<AnswerRequestEntity> answers;

    @ManyToOne
    private QuestionEntity questionEntity;

    @ManyToOne
    private TestRequestEntity testRequest;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<AnswerRequestEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerRequestEntity> answers) {
        this.answers = answers;
    }

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

    public TestRequestEntity getTestRequest() {
        return testRequest;
    }

    public void setTestRequest(TestRequestEntity testRequest) {
        this.testRequest = testRequest;
    }
}
