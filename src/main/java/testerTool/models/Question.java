package testerTool.models;

import java.util.List;
import java.util.UUID;

public class Question {
    private UUID id;
    private List<Answer> answers;
    private List<Answer> tempAnswers;
    private String text;
    private int points;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getTempAnswers() {
        return tempAnswers;
    }

    public void setTempAnswers(List<Answer> tempAnswers) {
        this.tempAnswers = tempAnswers;
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

    @Override
    public String toString() {
        return "Question{" +
                "answers=" + answers +
                ", tempAnswers=" + tempAnswers +
                ", text='" + text + '\'' +
                ", points=" + points +
                '}';
    }
}
