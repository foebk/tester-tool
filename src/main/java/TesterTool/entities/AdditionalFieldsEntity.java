package TesterTool.entities;

import javax.persistence.*;

@Entity(name = "additional_fields")
public class AdditionalFieldsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private TestEntity test;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
