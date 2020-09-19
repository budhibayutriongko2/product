package com.hcid.partner.notification.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController{

    @Value("${project.version}")
    private String projectVersion;

    @GetMapping(value = "/version")
    public String test(){
        return projectVersion;
    }
}
