package TesterTool.Entities;

import org.aspectj.weaver.ast.Test;

import javax.persistence.*;
import java.util.List;

@Entity(name = "questions")
public class QuestionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    private int points;

    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswersEntity> answers;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private TestEntity test;

    public TestEntity getTest() {
        return test;
    }

    public void setTest(TestEntity test) {
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<AnswersEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswersEntity> answers) {
        this.answers = answers;
    }
}
