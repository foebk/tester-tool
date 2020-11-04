package TesterTool.controllers;

import TesterTool.converter.TestModelToTestEntityConverter;
import TesterTool.entities.TestEntity;
import TesterTool.models.TestModel;
import TesterTool.repos.AdditionalFieldsRepository;
import TesterTool.repos.AnswersRepository;
import TesterTool.repos.QuestionsRepository;
import TesterTool.repos.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestMakerController {
    public final AdditionalFieldsRepository additionalFieldsRepository;
    public final AnswersRepository answersRepository;
    public final QuestionsRepository questionsRepository;
    public final TestRepository testRepository;

    @Autowired
    public TestMakerController(AdditionalFieldsRepository additionalFieldsRepository, AnswersRepository answersRepository, QuestionsRepository questionsRepository, TestRepository testRepository) {
        this.additionalFieldsRepository = additionalFieldsRepository;
        this.answersRepository = answersRepository;
        this.questionsRepository = questionsRepository;
        this.testRepository = testRepository;
    }

    @PostMapping("/addTest")
    public ResponseEntity<UUID> addTest(@RequestBody TestModel test) {
        TestModelToTestEntityConverter testModelToTestEntityConverter = new TestModelToTestEntityConverter();

        TestEntity entity = testRepository.save(Objects.requireNonNull(testModelToTestEntityConverter.convert(test)));
        return ResponseEntity.ok().body(entity.getId());
    }

    @GetMapping("/getTest")
    public TestEntity getTest(@RequestParam("uuid") UUID uuid) {
        return testRepository.findById(uuid).orElse(null);
    }
}
