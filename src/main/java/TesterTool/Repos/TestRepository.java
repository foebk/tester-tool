package TesterTool.Repos;

import TesterTool.Entities.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<TestEntity, Integer> {
    List<TestEntity> findAll();
}
