package TesterTool.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer  {
    private String text;
    private boolean isCorrect;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("isCorrect")
    public Boolean isCorrect() {
        return isCorrect;
    }

    @JsonProperty("isCorrect")
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "text='" + text + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
