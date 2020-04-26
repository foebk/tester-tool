package TesterTool.Converter;

import TesterTool.Entities.QuestionsEntity;
import TesterTool.Entities.TestEntity;
import TesterTool.Models.TestModel;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

public class TestModelToTestEntityConverter implements Converter<TestModel, TestEntity> {
    @Override
    public TestEntity convert(TestModel testModel) {
        TestEntity testEntity = new TestEntity();
        QuestionToQuestionsEntity questionToQuestionsEntity = new QuestionToQuestionsEntity();

        testEntity.setName(testModel.getName());
        testEntity.setDescription(testModel.getDescription());
        testEntity.setCreationTime(LocalDateTime.now());
        testEntity.setQuestions(questionToQuestionsEntity.convertList(testModel.getQuestions()));

        return testEntity;
    }
}
