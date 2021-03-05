package testerTool.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import testerTool.entities.AdditionalFieldRequestEntity;
import testerTool.models.AdditionalFieldRequest;
import testerTool.repos.AdditionalFieldsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdditionalFieldRequestToAdditionalFieldRequestEntity
        implements Converter<AdditionalFieldRequest, AdditionalFieldRequestEntity> {
    private final AdditionalFieldsRepository additionalFieldsRepository;

    public AdditionalFieldRequestToAdditionalFieldRequestEntity(AdditionalFieldsRepository additionalFieldsRepository) {
        this.additionalFieldsRepository = additionalFieldsRepository;
    }

    @Override
    public AdditionalFieldRequestEntity convert(AdditionalFieldRequest additionalFieldRequest) {
        AdditionalFieldRequestEntity additionalFieldRequestEntity = new AdditionalFieldRequestEntity();

        additionalFieldRequestEntity.setValue(additionalFieldRequest.getValue());
        additionalFieldRequestEntity.setAdditionalField(additionalFieldsRepository.findById(
                additionalFieldRequest.getId()));

        return additionalFieldRequestEntity;
    }

    public List<AdditionalFieldRequestEntity> convertList(List<AdditionalFieldRequest> additionalFieldRequests) {
        return additionalFieldRequests.stream().map(this::convert).collect(Collectors.toList());
    }
}
