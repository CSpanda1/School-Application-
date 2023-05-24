package com.hcl.springboot.school.rest;

import com.hcl.springboot.school.entity.Wrapper;
import com.hcl.springboot.school.service.SchemaReader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/Wrapper")
public class WrapperController
{

    WebClient client = WebClient.create("http://localhost:8080");
    @PostMapping("/Wrapper")
    public Mono createWrapper(@Valid @RequestBody Wrapper wrapper) {


        // Creating object of schema reader
        SchemaReader schemaReader = new SchemaReader();

        // A String holding the graphql data
        String graphqlData = schemaReader.schema(wrapper.getType(),wrapper.getQueryName(), wrapper.getPayload());

        System.out.println(graphqlData + "In print line");

        // Returns the graphql data
        return client.post().uri("/graphql").body(Mono.just(graphqlData),String.class).retrieve().bodyToMono(String.class);

    }
}
