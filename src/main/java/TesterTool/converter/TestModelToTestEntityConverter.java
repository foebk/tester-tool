package TesterTool.converter;

import TesterTool.entities.AdditionalFieldsEntity;
import TesterTool.entities.TestEntity;
import TesterTool.models.TestModel;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestModelToTestEntityConverter implements Converter<TestModel, TestEntity> {
    @Override
    public TestEntity convert(TestModel testModel) {
        TestEntity testEntity = new TestEntity();
        QuestionToQuestionsEntity questionToQuestionsEntity = new QuestionToQuestionsEntity();

        testEntity.setName(testModel.getName());
        testEntity.setDescription(testModel.getDescription());
        testEntity.setCreationTime(LocalDateTime.now());
        testEntity.setQuestions(questionToQuestionsEntity.convertList(testModel.getQuestions()));

        List<AdditionalFieldsEntity> additionalFieldsEntityList = new ArrayList<>();
        testModel.getAdditionalFields().forEach(field -> {
            AdditionalFieldsEntity additionalFieldsEntity = new AdditionalFieldsEntity();

            additionalFieldsEntity.setText(field);
            additionalFieldsEntityList.add(additionalFieldsEntity);
        });

        testEntity.setAdditionalFields(additionalFieldsEntityList);

        return testEntity;
    }
}
