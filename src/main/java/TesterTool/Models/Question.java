package TesterTool.Models;

import java.util.List;

public class Question {
    private List<Answer> answers;
    private List<Answer> tempAnswers;
    private String text;
    private short points;

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

    public short getPoints() {
        return points;
    }

    public void setPoints(short points) {
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