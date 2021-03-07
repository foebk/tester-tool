package testerTool.models;

import java.util.List;

public class ResultModel {
    private int percentage;
    private int correctAnswers;
    private int points;
    private int pointsTotal;
    private List<QuestionResultModel> questionResults;

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(int pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    public List<QuestionResultModel> getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(List<QuestionResultModel> questionResults) {
        this.questionResults = questionResults;
    }
}
