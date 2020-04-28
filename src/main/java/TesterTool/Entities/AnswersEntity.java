package TesterTool.Entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "answers")
public class AnswersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    private boolean isCorrect;

    @ManyToOne
    private QuestionsEntity questions;

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

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public QuestionsEntity getQuestions() {
        return questions;
    }

    public void setQuestions(QuestionsEntity questions) {
        this.questions = questions;
    }
}
