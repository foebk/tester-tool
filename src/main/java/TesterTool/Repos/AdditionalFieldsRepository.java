package TesterTool.Repos;

import TesterTool.Entities.AdditionalFieldsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalFieldsRepository extends CrudRepository<AdditionalFieldsEntity, Integer> {
    List<AdditionalFieldsEntity> findAll();
}
