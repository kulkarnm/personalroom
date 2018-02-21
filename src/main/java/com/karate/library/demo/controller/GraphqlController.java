package com.karate.library.demo.controller;

import java.io.InputStream;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graphql")
public class GraphqlController {
    
    @PostMapping
    public String handle(@RequestBody Map<String, Object> request) throws Exception {
        Object variables = request.get("variables");
        String filename = variables == null ? "graphql-1.json" : "graphql-2.json";
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        return IOUtils.toString(is, "utf-8");
    }   
    
}
