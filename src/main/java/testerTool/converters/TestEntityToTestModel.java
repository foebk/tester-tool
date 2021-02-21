package testerTool.converters;

import org.springframework.stereotype.Component;
import testerTool.entities.TestEntity;
import testerTool.models.TestModel;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

@Component
public class TestEntityToTestModel implements Converter<TestEntity, TestModel> {
    @Override
    public TestModel convert(TestEntity testEntity) {
        TestModel test = new TestModel();
        QuestionEntityToQuestion questionEntityToQuestion = new QuestionEntityToQuestion();

        test.setId(testEntity.getId());
        test.setName(testEntity.getName());
        test.setDescription(testEntity.getDescription());
        test.setQuestions(questionEntityToQuestion.convertList(testEntity.getQuestions()));

        return test;
    }
}
