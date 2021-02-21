package testerTool.converters;

import org.springframework.core.convert.converter.Converter;
import testerTool.entities.AnswerEntity;
import testerTool.models.Answer;

public class AnswerEntityToAnswerModel implements Converter<AnswerEntity, Answer> {
    @Override
    public Answer convert(AnswerEntity answerEntity) {
        return new Answer(answerEntity.getId(), answerEntity.getText(), answerEntity.isCorrect());
    }
}
