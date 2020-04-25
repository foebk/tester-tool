package TesterTool.Repos;

import TesterTool.Entities.AnswersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepository extends CrudRepository<AnswersEntity, Integer>{
    List<AnswersEntity> findAll();
}
