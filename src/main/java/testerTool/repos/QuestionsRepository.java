package testerTool.repos;

import testerTool.entities.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionsRepository extends CrudRepository<QuestionEntity, Integer> {
    List<QuestionEntity> findAll();

    QuestionEntity findById(UUID id);
}
