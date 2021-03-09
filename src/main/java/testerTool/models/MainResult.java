package testerTool.models;

import java.util.List;

public class MainResult {
    private String testName;
    private String testDescription;
    private double averagePoints;
    private int lowestPoints;
    private int highestPoints;
    private double averagePercentage;
    private int lowestPercentage;
    private int highestPercentage;
    private List<ResultModel> resultModels;
    private List<QuestionRating> questionRatings;

    public List<ResultModel> getResultModels() {
        return resultModels;
    }

    public void setResultModels(List<ResultModel> resultModels) {
        this.resultModels = resultModels;
    }

    public List<QuestionRating> getQuestionRatings() {
        return questionRatings;
    }

    public void setQuestionRatings(List<QuestionRating> questionRatings) {
        this.questionRatings = questionRatings;
    }

    public int getLowestPoints() {
        return lowestPoints;
    }

    public void setLowestPoints(int lowestPoints) {
        this.lowestPoints = lowestPoints;
    }

    public int getHighestPoints() {
        return highestPoints;
    }

    public void setHighestPoints(int highestPoints) {
        this.highestPoints = highestPoints;
    }

    public int getLowestPercentage() {
        return lowestPercentage;
    }

    public void setLowestPercentage(int lowestPercentage) {
        this.lowestPercentage = lowestPercentage;
    }

    public int getHighestPercentage() {
        return highestPercentage;
    }

    public void setHighestPercentage(int highestPercentage) {
        this.highestPercentage = highestPercentage;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public double getAveragePoints() {
        return averagePoints;
    }

    public void setAveragePoints(double averagePoints) {
        this.averagePoints = averagePoints;
    }

    public double getAveragePercentage() {
        return averagePercentage;
    }

    public void setAveragePercentage(double averagePercentage) {
        this.averagePercentage = averagePercentage;
    }
}
