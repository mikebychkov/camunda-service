package com.example.camundaservice.test;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.impl.RuntimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {

//        runtimeService.restartProcessInstances()

        return ResponseEntity.ok("Hello");
    }
}
