package TesterTool.Controllers;

import TesterTool.Entities.AnswersEntity;
import TesterTool.Models.TestModel;
import TesterTool.Repos.AdditionalFieldsRepository;
import TesterTool.Repos.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestMakerController {
    public final AdditionalFieldsRepository additionalFieldsRepository;
    public final AnswersRepository answersRepository;

    @Autowired
    public TestMakerController(AdditionalFieldsRepository additionalFieldsRepository, AnswersRepository answersRepository) {
        this.additionalFieldsRepository = additionalFieldsRepository;
        this.answersRepository = answersRepository;
    }

    @GetMapping("/test")
    public String test() {
        List<AnswersEntity> additionalFieldsEntity = answersRepository.findAll();
        return "ok";
    }

    @PostMapping("/addTest")
    public ResponseEntity<String> addTest(@RequestBody TestModel test) {
        System.out.println(test);
        return ResponseEntity.ok().body(null);
    }
}
