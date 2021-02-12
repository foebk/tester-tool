package TesterTool.repos;

import TesterTool.entities.AnswerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepository extends CrudRepository<AnswerEntity, Integer>{
    List<AnswerEntity> findAll();
}
