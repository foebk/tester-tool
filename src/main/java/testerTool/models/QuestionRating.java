package testerTool.models;

public class QuestionRating {
    private String text;
    private int countOfWrongAnswers;

    public QuestionRating(String text, int countOfWrongAnswers) {
        this.text = text;
        this.countOfWrongAnswers = countOfWrongAnswers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCountOfWrongAnswers() {
        return countOfWrongAnswers;
    }

    public void setCountOfWrongAnswers(int countOfWrongAnswers) {
        this.countOfWrongAnswers = countOfWrongAnswers;
    }
}
