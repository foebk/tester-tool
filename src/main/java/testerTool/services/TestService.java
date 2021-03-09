package testerTool.services;

import testerTool.models.*;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface TestService {
    ResponseEntity<UUID> addTest(TestModel testModel);

    TestModel getTest(UUID uuid);

    void saveTestResult(TestRequest testRequest);

    ResultModel getTestResult(TestRequest testRequest);

    MainResultModel getAllResults(UUID uuid);
}
