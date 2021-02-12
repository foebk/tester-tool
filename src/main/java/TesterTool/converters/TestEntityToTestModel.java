package TesterTool.converters;

import TesterTool.entities.TestEntity;
import TesterTool.models.TestModel;
import org.springframework.core.convert.converter.Converter;

public class TestEntityToTestModel implements Converter<TestEntity, TestModel> {
    @Override
    public TestModel convert(TestEntity testEntity) {
        TestModel test = new TestModel();

        test.setName(testEntity.getName());
        test.setDescription(testEntity.getDescription());
//        test.setQuestions(testEntity.getQuestions());

//        testEntity.getAdditionalFields().forEach();
        return null;
    }
}
