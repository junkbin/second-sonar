package com.example.second;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/")
    public String route() {
        LOG.info("Request receivedd");
        return "Helloo Finally";
    }

    @GetMapping("/1")
    public String route1() {
       try {
           LOG.info("Request receivedd");

           throw new RuntimeException("Custom Runtime Error");
       } catch(Exception e) {
           Object[] objArgs = new Object[1];
           objArgs[0] = e;
            LOG.error("Error Message", objArgs, objArgs);
       } finally {
           return "Helloo Finally";
       }
    }
}
