package TesterTool.converter;

import TesterTool.entities.QuestionsEntity;
import TesterTool.models.Question;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class QuestionToQuestionsEntity implements Converter<Question, QuestionsEntity> {
    @Override
    public QuestionsEntity convert(Question question) {
        QuestionsEntity questionsEntity = new QuestionsEntity();
        AnswerToAnswersEntity answerToAnswersEntity = new AnswerToAnswersEntity();

        questionsEntity.setText(question.getText());
        questionsEntity.setPoints(question.getPoints());
        question.getAnswers().addAll(question.getTempAnswers());
        questionsEntity.setAnswers(answerToAnswersEntity.convertList(question.getAnswers()));

        return questionsEntity;
    }

    public List<QuestionsEntity> convertList(List<Question> questions) {
        List<QuestionsEntity> questionsEntities = new ArrayList<>();

        questions.forEach(question -> {
            QuestionsEntity questionsEntity = convert(question);

            questionsEntities.add(questionsEntity);
        });

        return questionsEntities;
    }
}
