package testerTool.repos;

import testerTool.entities.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends CrudRepository<QuestionEntity, Integer> {
    List<QuestionEntity> findAll();
}
