package TesterTool.converter;

import TesterTool.entities.AnswersEntity;
import TesterTool.models.Answer;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class AnswerToAnswersEntity implements Converter<Answer, AnswersEntity> {
    @Override
    public AnswersEntity convert(Answer answer) {
        AnswersEntity answersEntity = new AnswersEntity();

        answersEntity.setText(answer.getText());
        answersEntity.setCorrect(answer.isCorrect());

        return answersEntity;
    }

    public List<AnswersEntity> convertList(List<Answer> answers) {
        List<AnswersEntity> answersEntities = new ArrayList<>();

        answers.forEach(answer -> {
            AnswersEntity answersEntity = convert(answer);

            answersEntities.add(answersEntity);
        });

        return answersEntities;
    }
}
