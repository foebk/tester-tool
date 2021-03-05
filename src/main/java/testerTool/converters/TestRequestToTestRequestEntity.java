package testerTool.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import testerTool.entities.TestRequestEntity;
import testerTool.models.TestRequest;
import testerTool.repos.TestRepository;

@Component
public class TestRequestToTestRequestEntity
        implements Converter<TestRequest, TestRequestEntity> {
    private final QuestionRequestToQuestionRequestEntity questionRequestToQuestionRequestEntity;
    private final AdditionalFieldRequestToAdditionalFieldRequestEntity additionalFieldRequestToAdditionalFieldRequestEntity;
    private final TestRepository testRepository;

    public TestRequestToTestRequestEntity(QuestionRequestToQuestionRequestEntity questionRequestToQuestionRequestEntity,
                                          AdditionalFieldRequestToAdditionalFieldRequestEntity additionalFieldRequestToAdditionalFieldRequestEntity,
                                          TestRepository testRepository) {
        this.questionRequestToQuestionRequestEntity = questionRequestToQuestionRequestEntity;
        this.additionalFieldRequestToAdditionalFieldRequestEntity = additionalFieldRequestToAdditionalFieldRequestEntity;
        this.testRepository = testRepository;
    }

    @Override
    public TestRequestEntity convert(TestRequest testRequest) {
        TestRequestEntity testRequestEntity = new TestRequestEntity();
        testRequestEntity.setAdditionalFieldRequestEntity(additionalFieldRequestToAdditionalFieldRequestEntity
                .convertList(testRequest.getAdditionalFields()));
        testRequestEntity.setQuestionRequestEntity(questionRequestToQuestionRequestEntity.convertList(testRequest.getQuestions()));
        testRequestEntity.setTestEntity(testRepository.findById(testRequest.getId()).orElse(null));

        return testRequestEntity;
    }
}
