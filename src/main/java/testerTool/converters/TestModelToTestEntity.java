package testerTool.converters;

import testerTool.entities.AdditionalFieldEntity;
import testerTool.entities.TestEntity;
import testerTool.models.TestModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestModelToTestEntity implements Converter<TestModel, TestEntity> {
    @Override
    public TestEntity convert(TestModel testModel) {
        TestEntity testEntity = new TestEntity();
        QuestionToQuestionEntity questionToQuestionsEntity = new QuestionToQuestionEntity();

        testEntity.setName(testModel.getName());
        testEntity.setDescription(testModel.getDescription());
        testEntity.setCreationTime(LocalDateTime.now());
        testEntity.setQuestions(questionToQuestionsEntity.convertList(testModel.getQuestions()));

        List<AdditionalFieldEntity> additionalFieldEntityList = new ArrayList<>();
        testModel.getAdditionalFields().forEach(field -> {
            AdditionalFieldEntity additionalFieldEntity = new AdditionalFieldEntity();

            additionalFieldEntity.setText(field.getText());
            additionalFieldEntityList.add(additionalFieldEntity);
        });

        testEntity.setAdditionalFields(additionalFieldEntityList);

        return testEntity;
    }
}
