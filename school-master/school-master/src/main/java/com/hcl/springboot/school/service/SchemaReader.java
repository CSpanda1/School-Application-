package com.hcl.springboot.school.service;

import java.util.Map;

public class SchemaReader
{
        public String schema(String queryType , String queryName, Map<String,String> queryPayload)
        {
                StringBuilder mapPayload = new StringBuilder();

                for(Map.Entry<String,String> payload: queryPayload.entrySet())
                {
                        String key= payload.getKey();
                        String value = payload.getValue();
                        mapPayload.append(key).append(": ").append(value).append(", ");
                        System.out.println(payload.getKey());
                }

                String graphqlQuery = String.format("{\"query\":\"%s{%s(%s){schoolID} }\" }",queryType,queryName,mapPayload);


                return graphqlQuery;
        }
}
