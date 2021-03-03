package testerTool.services;

import testerTool.converters.TestEntityToTestModel;
import testerTool.converters.TestModelToTestEntity;
import testerTool.entities.AdditionalFieldEntity;
import testerTool.entities.TestEntity;
import testerTool.models.AdditionalField;
import testerTool.models.TestModel;
import testerTool.repos.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {
    private final TestModelToTestEntity testModelToTestEntityConverter;
    private final TestEntityToTestModel testEntityToTestModel;
    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestModelToTestEntity testModelToTestEntityConverter, TestEntityToTestModel testEntityToTestModel, TestRepository testRepository) {
        this.testModelToTestEntityConverter = testModelToTestEntityConverter;
        this.testEntityToTestModel = testEntityToTestModel;
        this.testRepository = testRepository;
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
}
