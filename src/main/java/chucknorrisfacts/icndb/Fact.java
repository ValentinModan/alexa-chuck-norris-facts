package chucknorrisfacts.icndb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Fact {

    private String type;
    private Integer factId;
    private String text;

    public Fact() {
    }

    @JsonProperty("value")
    private void unpackNested(Map<String, Object> fact) {
        this.factId = (Integer) fact.get("id");
        this.text = (String) fact.get("joke");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFactId() {
        return factId;
    }

    public void setFactId(Integer factId) {
        this.factId = factId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "type='" + type + '\'' +
                ", factId=" + factId +
                ", text='" + text + '\'' +
                '}';
    }
}
