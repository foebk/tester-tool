package testerTool.repos;

import testerTool.entities.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TestRepository extends CrudRepository<TestEntity, UUID> {
    List<TestEntity> findAll();
}
