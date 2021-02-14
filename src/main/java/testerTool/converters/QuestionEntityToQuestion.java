package testerTool.converters;

import testerTool.entities.QuestionEntity;
import testerTool.models.Question;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionEntityToQuestion implements Converter<QuestionEntity, Question> {
    @Override
    public Question convert(QuestionEntity questionEntity) {
        Question question = new Question();
        question.setText(questionEntity.getText());
        question.setPoints(questionEntity.getPoints());
        return null;
    }

    public List<Question> convertList(List<QuestionEntity> questionEntities) {
        return questionEntities.stream().map(this::convert).collect(Collectors.toList());
    }
}
