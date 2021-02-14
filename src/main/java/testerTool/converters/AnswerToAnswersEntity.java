package testerTool.converters;

import testerTool.entities.AnswerEntity;
import testerTool.models.Answer;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class AnswerToAnswersEntity implements Converter<Answer, AnswerEntity> {
    @Override
    public AnswerEntity convert(Answer answer) {
        AnswerEntity answersEntity = new AnswerEntity();

        answersEntity.setText(answer.getText());
        answersEntity.setCorrect(answer.isCorrect());

        return answersEntity;
    }

    public List<AnswerEntity> convertList(List<Answer> answers) {
        List<AnswerEntity> answersEntities = new ArrayList<>();

        answers.forEach(answer -> {
            AnswerEntity answersEntity = convert(answer);

            answersEntities.add(answersEntity);
        });

        return answersEntities;
    }
}
