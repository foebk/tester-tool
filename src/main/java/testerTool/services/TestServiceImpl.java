package testerTool.services;

import testerTool.converters.TestEntityToTestModel;
import testerTool.converters.TestModelToTestEntity;
import testerTool.converters.TestRequestToTestRequestEntity;
import testerTool.entities.*;
import testerTool.models.*;
import testerTool.repos.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import testerTool.repos.TestRequestRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {
    private final TestModelToTestEntity testModelToTestEntityConverter;
    private final TestEntityToTestModel testEntityToTestModel;
    private final TestRepository testRepository;
    private final TestRequestToTestRequestEntity testRequestToTestRequestEntity;
    private final TestRequestRepository testRequestRepository;

    @Autowired
    public TestServiceImpl(TestModelToTestEntity testModelToTestEntityConverter, TestEntityToTestModel testEntityToTestModel, TestRepository testRepository, TestRequestToTestRequestEntity testRequestToTestRequestEntity, TestRequestRepository testRequestRepository) {
        this.testModelToTestEntityConverter = testModelToTestEntityConverter;
        this.testEntityToTestModel = testEntityToTestModel;
        this.testRepository = testRepository;
        this.testRequestToTestRequestEntity = testRequestToTestRequestEntity;
        this.testRequestRepository = testRequestRepository;
    }

    @Override
    public ResponseEntity<UUID> addTest(TestModel testModel) {
        TestEntity savedTest = testRepository.save(Objects.requireNonNull(testModelToTestEntityConverter.convert(testModel)));
        return ResponseEntity.ok().body(savedTest.getId());
    }

    @Override
    public TestModel getTest(UUID uuid) {
        TestEntity entity = testRepository.findById(uuid).orElse(null);

        return Optional.ofNullable(entity).map(e -> {
            TestModel testModel = testEntityToTestModel.convert(e);
            testModel.setAdditionalFields(e.getAdditionalFields().stream()
                    .map(field -> new AdditionalField(field.getId(), field.getText())).collect(Collectors.toList()));

            return testModel;
        }).orElse(null);
    }

    @Override
    public void saveTestResult(TestRequest testRequest) {
        testRequestRepository.save(testRequestToTestRequestEntity.convert(testRequest));
    }


    @Override
    public ResultModel getTestResult(TestRequest testRequest) {
        TestEntity test = testRepository.findById(testRequest.getId()).orElse(null);
        Map<UUID, Boolean> answersMap = new HashMap<>();
        testRequest.getQuestions().forEach(q -> {
            answersMap.putAll(q.getAnswers().stream()
                    .collect(Collectors.toMap(AnswerRequest::getId, AnswerRequest::isCorrect)));
        });

        ResultModel result = new ResultModel();
        result.setQuestionResults(test.getQuestions().stream().map(q -> {
            if (q.getAnswers().stream().anyMatch(a -> a.isCorrect() != answersMap.get(a.getId()))) {
                return new QuestionResultModel(q.getText(), q.getPoints(), false);
            } else {
                return new QuestionResultModel(q.getText(), q.getPoints(), true);
            }
        }).collect(Collectors.toList()));

        return setStatisticsInfo(result);
    }

    @Override
    public MainResult getAllResults(UUID uuid) {
        TestEntity testEntity = testRepository.findById(uuid).orElse(null);
        Map<UUID, Boolean> answersMap = testEntity.getQuestions().stream().flatMap(q -> q.getAnswers().stream())
                .collect(Collectors.toMap(AnswerEntity::getId, AnswerEntity::isCorrect));
        Map<UUID, String> additionalFieldsMap = testEntity.getAdditionalFields().stream()
                .collect(Collectors.toMap(AdditionalFieldEntity::getId, AdditionalFieldEntity::getText));
        Map<UUID, Integer> ratingMap = testEntity.getQuestions().stream().collect(Collectors.toMap(
                QuestionEntity::getId, q -> 0));

        MainResult mainResult = new MainResult();
        List<TestRequestEntity> testRequestEntities = testEntity.getTestRequestEntities();
        mainResult.setResultModels(testRequestEntities.stream().map(entity -> {
            ResultModel resultModel = new ResultModel();
            resultModel.setAdditionalFields(entity.getAdditionalFieldRequestEntity().stream()
                    .map(f -> new AdditionalFieldResponse(additionalFieldsMap.get(f.getAdditionalField().getId()), f.getValue()))
                    .collect(Collectors.toList()));

            resultModel.setQuestionResults(entity.getQuestionRequestEntity().stream().map(q -> {
                if (q.getAnswers().stream().anyMatch(a -> a.getMark() != answersMap.get(a.getAnswer().getId()))) {
                    ratingMap.replace(q.getQuestionEntity().getId(), ratingMap.get(q.getQuestionEntity().getId()) + 1);
                    return new QuestionResultModel(q.getQuestionEntity().getText(), q.getQuestionEntity().getPoints(),
                            false);
                } else {
                    return new QuestionResultModel(q.getQuestionEntity().getText(), q.getQuestionEntity().getPoints(),
                            true);
                }
            }).collect(Collectors.toList()));

            return setStatisticsInfo(resultModel);
        }).collect(Collectors.toList()));

        mainResult.setQuestionRatings(createQuestionRating(ratingMap, testEntity.getQuestions()));
        mainResult.setTestName(testEntity.getName());
        mainResult.setTestDescription(testEntity.getDescription());

        return setMainResultStatistics(mainResult);
    }

    private ResultModel setStatisticsInfo(ResultModel result) {
        result.setCorrectAnswers((int) result.getQuestionResults().stream().filter(QuestionResultModel::isCorrect).count());
        result.setPercentage(Math.round((float) result.getCorrectAnswers() / (float) result.getQuestionResults().size() * 100));
        result.setPoints(result.getQuestionResults().stream().filter(QuestionResultModel::isCorrect)
                .mapToInt(QuestionResultModel::getPointsForCorrect).sum());
        result.setPointsTotal(result.getQuestionResults().stream().mapToInt(QuestionResultModel::getPointsForCorrect).sum());

        return result;
    }

    private List<QuestionRating> createQuestionRating(Map<UUID, Integer> ratingMap, List<QuestionEntity> questionEntities) {
        Map<UUID, String> questionMap = questionEntities.stream().collect(Collectors.toMap(QuestionEntity::getId, QuestionEntity::getText));

        return ratingMap.entrySet().stream().map(e -> new QuestionRating(questionMap.get(e.getKey()), e.getValue()))
                .sorted(Comparator.comparing(QuestionRating::getCountOfWrongAnswers).reversed())
                .collect(Collectors.toList());
    }

    private MainResult setMainResultStatistics(MainResult mainResult) {
        IntSummaryStatistics percentage = mainResult.getResultModels().stream().mapToInt(ResultModel::getPercentage).summaryStatistics();
        mainResult.setLowestPoints(percentage.getMin());
        mainResult.setHighestPercentage(percentage.getMax());
        mainResult.setAveragePercentage((int) Math.round(percentage.getAverage()));
        
        IntSummaryStatistics points =  mainResult.getResultModels().stream().mapToInt(ResultModel::getPoints).summaryStatistics();
        mainResult.setLowestPoints(points.getMin());
        mainResult.setHighestPoints(points.getMax());
        mainResult.setAveragePoints((int) Math.round(points.getAverage()));

        return mainResult;
    }
}
