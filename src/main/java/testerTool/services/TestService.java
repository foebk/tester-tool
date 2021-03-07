package testerTool.services;

import testerTool.models.QuestionResultModel;
import testerTool.models.ResultModel;
import testerTool.models.TestModel;
import org.springframework.http.ResponseEntity;
import testerTool.models.TestRequest;

import java.util.List;
import java.util.UUID;

public interface TestService {
    ResponseEntity<UUID> addTest(TestModel testModel);

    TestModel getTest(UUID uuid);

    void saveTestResult(TestRequest testRequest);

    ResultModel getTestResult(TestRequest testRequest);
}
