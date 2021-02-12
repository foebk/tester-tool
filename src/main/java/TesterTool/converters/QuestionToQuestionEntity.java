package TesterTool.converters;

import TesterTool.entities.QuestionEntity;
import TesterTool.models.Question;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class QuestionToQuestionEntity implements Converter<Question, QuestionEntity> {
    @Override
    public QuestionEntity convert(Question question) {
        QuestionEntity questionsEntity = new QuestionEntity();
        AnswerToAnswersEntity answerToAnswersEntity = new AnswerToAnswersEntity();

        questionsEntity.setText(question.getText());
        questionsEntity.setPoints(question.getPoints());
        question.getAnswers().addAll(question.getTempAnswers());
        questionsEntity.setAnswers(answerToAnswersEntity.convertList(question.getAnswers()));

        return questionsEntity;
    }

    public List<QuestionEntity> convertList(List<Question> questions) {
        List<QuestionEntity> questionsEntities = new ArrayList<>();

        questions.forEach(question -> {
            QuestionEntity questionsEntity = convert(question);

            questionsEntities.add(questionsEntity);
        });

        return questionsEntities;
    }
}
