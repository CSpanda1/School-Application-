package com.hcl.springboot.school.entity;

import java.util.Map;

public class Wrapper
{
    private String type;
    private String queryName;
    private Map<String,String> payload;
    private String responseAttributes;

    public Wrapper()
    {

    }

    public Wrapper(String type, String queryName, Map<String, String> payload) {
        this.type = type;
        this.queryName = queryName;
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    public String getResponseAttributes() {
        return responseAttributes;
    }

    public void setResponseAttributes(String responseAttributes) {
        this.responseAttributes = responseAttributes;
    }


}
