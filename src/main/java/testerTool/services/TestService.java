package testerTool.services;

import testerTool.models.TestModel;
import org.springframework.http.ResponseEntity;
import testerTool.models.TestRequest;

import java.util.UUID;

public interface TestService {
    ResponseEntity<UUID> addTest(TestModel testModel);

    TestModel getTest(UUID uuid);

    void getTestResult(TestRequest testRequest);
}
