package testerTool.models;

public class QuestionResultModel {
    private String questionText;
    private int pointsForCorrect;
    private boolean isCorrect;

    public QuestionResultModel(String questionText, int pointsForCorrect, boolean isCorrect) {
        this.questionText = questionText;
        this.pointsForCorrect = pointsForCorrect;
        this.isCorrect = isCorrect;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public int getPointsForCorrect() {
        return pointsForCorrect;
    }

    public void setPointsForCorrect(int pointsForCorrect) {
        this.pointsForCorrect = pointsForCorrect;
    }
}
