package testerTool.models;

import java.util.List;

public class MainResultModel {
    List<ResultModel> resultModels;
    List<QuestionRating> questionRatings;

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
}
