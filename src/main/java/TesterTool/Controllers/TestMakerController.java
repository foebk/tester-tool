package TesterTool.Controllers;

import TesterTool.Converter.TestModelToTestEntityConverter;
import TesterTool.Entities.TestEntity;
import TesterTool.Models.TestModel;
import TesterTool.Repos.AdditionalFieldsRepository;
import TesterTool.Repos.AnswersRepository;
import TesterTool.Repos.QuestionsRepository;
import TesterTool.Repos.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/test")
    public String test() {
        List<TestEntity> questionsEntities = testRepository.findAll();
        return "ok";
    }

    @PostMapping("/addTest")
    public ResponseEntity<String> addTest(@RequestBody TestModel test) {
        TestModelToTestEntityConverter testModelToTestEntityConverter = new TestModelToTestEntityConverter();

        TestEntity testEntity = testModelToTestEntityConverter.convert(test);
        return ResponseEntity.ok().body(null);
    }
}
