package testerTool.repos;

import testerTool.entities.AdditionalFieldsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalFieldsRepository extends CrudRepository<AdditionalFieldsEntity, Integer> {
    List<AdditionalFieldsEntity> findAll();
}
