package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.domain.ColumnDomain;
import org.sofka.mykrello.model.service.ColumnService;
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
@CrossOrigin(value = "*")
public class ColumnController {
    @Autowired
    private ColumnService columnService;

    @Autowired
    private MyResponseUtility response;


    @GetMapping(path = "/api/v1/columns")
    public ResponseEntity<MyResponseUtility> index() {
        response.data = null;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/column/dto/{id}")
    public ResponseEntity<MyResponseUtility> getAllByBoardId(@PathVariable(value = "id") Integer id) {
        response.data = null;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/column/{id}")
    public ResponseEntity<MyResponseUtility> getColumn(@PathVariable(value = "id") Integer id) {
        response.data = null;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/column/{id}")
    public ResponseEntity<MyResponseUtility> createColumnByBoard(@PathVariable("id") Integer id,@RequestBody ColumnDomain column) {
        response.data = null;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}