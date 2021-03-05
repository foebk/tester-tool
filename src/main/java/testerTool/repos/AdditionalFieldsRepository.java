package testerTool.repos;

import testerTool.entities.AdditionalFieldEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AdditionalFieldsRepository extends CrudRepository<AdditionalFieldEntity, Integer> {
    List<AdditionalFieldEntity> findAll();

    AdditionalFieldEntity findById(UUID id);
}
