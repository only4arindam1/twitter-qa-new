package com.camunda.training.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component

public class RequestContext implements Serializable {
    public String requestId;
    public String witnessId;
    public boolean isSpecificWitness;


    public RequestContext() {
    }


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getWitnessId() {
        return witnessId;
    }

    public void setWitnessId(String witnessId) {
        this.witnessId = witnessId;
    }

    public boolean isSpecificWitness() {
        return isSpecificWitness;
    }

    public void setSpecificWitness(boolean specificWitness) {
        isSpecificWitness = specificWitness;
    }

    @Override
    public String toString() {
        return "RequestContext{" +
                "requestId='" + requestId + '\'' +
                ", witnessId='" + witnessId + '\'' +
                ", isSpecificWitness=" + isSpecificWitness +
                '}';
    }
}
