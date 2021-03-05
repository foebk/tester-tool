package testerTool.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testerTool.entities.TestRequestEntity;

import java.util.UUID;

@Repository
public interface TestRequestRepository extends CrudRepository<TestRequestEntity, UUID> {
}
