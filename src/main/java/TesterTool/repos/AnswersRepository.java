package TesterTool.repos;

import TesterTool.entities.AnswersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepository extends CrudRepository<AnswersEntity, Integer>{
    List<AnswersEntity> findAll();
}
