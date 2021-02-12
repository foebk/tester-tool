package TesterTool.repos;

import TesterTool.entities.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TestRepository extends CrudRepository<TestEntity, UUID> {
    List<TestEntity> findAll();
}
