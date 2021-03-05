package testerTool.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "answer_request")
public class AnswerRequestEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private Boolean isMark;

    @ManyToOne
    private AnswerEntity answer;

    @ManyToOne
    private QuestionRequestEntity questionRequest;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getMark() {
        return isMark;
    }

    public void setMark(Boolean mark) {
        isMark = mark;
    }

    public AnswerEntity getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerEntity answer) {
        this.answer = answer;
    }

    public QuestionRequestEntity getQuestionRequest() {
        return questionRequest;
    }

    public void setQuestionRequest(QuestionRequestEntity questionRequest) {
        this.questionRequest = questionRequest;
    }
}
