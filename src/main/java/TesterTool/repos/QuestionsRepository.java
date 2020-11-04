package TesterTool.repos;

import TesterTool.entities.QuestionsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends CrudRepository<QuestionsEntity, Integer> {
    List<QuestionsEntity> findAll();
}
