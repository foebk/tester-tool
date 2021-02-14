package testerTool.services;

import testerTool.converters.TestModelToTestEntity;
import testerTool.entities.TestEntity;
import testerTool.models.TestModel;
import testerTool.repos.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class TestServiceImpl implements TestService {
    private final TestModelToTestEntity testModelToTestEntityConverter;
    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestModelToTestEntity testModelToTestEntityConverter, TestRepository testRepository) {
        this.testModelToTestEntityConverter = testModelToTestEntityConverter;
        this.testRepository = testRepository;
    }

    @Override
    public ResponseEntity<UUID> addTest(TestModel testModel) {
        TestEntity savedTest = testRepository.save(Objects.requireNonNull(testModelToTestEntityConverter.convert(testModel)));
        return ResponseEntity.ok().body(savedTest.getId());
    }

    @Override
    public TestModel getTest() {
        return null;
    }
}
