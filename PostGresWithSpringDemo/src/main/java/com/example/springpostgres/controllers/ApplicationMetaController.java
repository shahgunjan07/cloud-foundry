package com.example.springpostgres.controllers;

import com.example.springpostgres.models.ApplicationMeta;
import com.example.springpostgres.repositories.ApplicationMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationMetaController {

    @Autowired
    ApplicationMetaRepository applicationMetaRepository;

    @GetMapping("/apps/{name}")
    public ResponseEntity<ApplicationMeta> applicationData(@PathVariable String name) {
        ApplicationMeta applicationMeta = applicationMetaRepository.findByName(name);
        return ResponseEntity.ok().body(applicationMeta);
    }
}
