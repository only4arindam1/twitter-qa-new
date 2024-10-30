package com.camunda.training.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "messageName",
        "businessKey",
        "processVariables"
})

public class Message {

    @JsonProperty("messageName")
    private String messageName;
    @JsonProperty("businessKey")
    private String businessKey;
    @JsonProperty("processVariables")
    private ProcessVariables processVariables;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("messageName")
    public String getMessageName() {
        return messageName;
    }

    @JsonProperty("messageName")
    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    @JsonProperty("businessKey")
    public String getBusinessKey() {
        return businessKey;
    }

    @JsonProperty("businessKey")
    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    @JsonProperty("processVariables")
    public ProcessVariables getProcessVariables() {
        return processVariables;
    }

    @JsonProperty("processVariables")
    public void setProcessVariables(ProcessVariables processVariables) {
        this.processVariables = processVariables;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
