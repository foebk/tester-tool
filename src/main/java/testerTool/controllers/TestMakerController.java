package testerTool.controllers;

import testerTool.models.QuestionResultModel;
import testerTool.models.ResultModel;
import testerTool.models.TestModel;
import testerTool.models.TestRequest;
import testerTool.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestMakerController {
    private final TestService testService;

    @Autowired
    public TestMakerController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/addTest")
    public ResponseEntity<UUID> addTest(@RequestBody TestModel test) {
        return testService.addTest(test);
    }

    @PostMapping("/getTest")
    public TestModel getTest(@RequestBody String uuid) {
        try{
            UUID id = UUID.fromString(uuid);
            return testService.getTest(id);
        } catch (IllegalArgumentException exception){
            return null;
        }
    }

    @PostMapping("/getResult")
    public ResultModel saveTestResult(@RequestBody TestRequest testRequest) {
        testService.saveTestResult(testRequest);
        return testService.getTestResult(testRequest);
    }
}
