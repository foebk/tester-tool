package testerTool.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "additional_field_request")
public class AdditionalFieldRequestEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String value;

    @ManyToOne
    private AdditionalFieldEntity additionalField;

    @ManyToOne
    private TestRequestEntity testRequest;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AdditionalFieldEntity getAdditionalField() {
        return additionalField;
    }

    public void setAdditionalField(AdditionalFieldEntity additionalField) {
        this.additionalField = additionalField;
    }

    public TestRequestEntity getTestRequest() {
        return testRequest;
    }

    public void setTestRequest(TestRequestEntity testRequest) {
        this.testRequest = testRequest;
    }
}
