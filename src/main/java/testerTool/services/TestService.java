package testerTool.services;

import testerTool.models.TestModel;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface TestService {
    ResponseEntity<UUID> addTest(TestModel testModel);

    TestModel getTest();
}
