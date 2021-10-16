package com.example.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/")
    public String route1() {
       try {
           LOG.info("Request receivedd");

           throw new RuntimeException("Custom Runtime Error");
       } catch(Exception e) {
            LOG.error("Error Message", e);
       } finally {
           return "Helloo Finally";
       }
    }
}
