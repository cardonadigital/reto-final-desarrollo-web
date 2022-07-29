package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.domain.LogDomain;
import org.sofka.mykrello.model.service.LogService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LogController {
    @Autowired
    private LogService logService;

    @Autowired
    private MyResponseUtility response;

    @GetMapping(path = "/api/v1/log/{id}")
    public ResponseEntity<MyResponseUtility> getLogById(@PathVariable("id") Integer id) {
        response.data = logService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/log")
    public ResponseEntity<MyResponseUtility> create(@RequestBody LogDomain logDomain) {
        response.data = logService.create(logDomain);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
