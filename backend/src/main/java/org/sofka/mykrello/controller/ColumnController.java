package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.domain.BoardDomain;
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
import org.springframework.web.bind.annotation.PutMapping;
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
        try {
            response.data = columnService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/api/v1/column/dto/{id}")
    public ResponseEntity<MyResponseUtility> getAllBoardById(@PathVariable(value = "id") Integer id) {
        try {
            response.data = columnService.getDto(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/api/v1/column/{id}")
    public ResponseEntity<MyResponseUtility> getColumn(@PathVariable(value = "id") Integer id) {
        try {
            response.data = columnService.findById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/api/v1/column/{id}")
    public ResponseEntity<MyResponseUtility> createColumnByBoard(@PathVariable("id") Integer id,
                                                                 @RequestBody ColumnDomain column) {
        try {
            response.data = columnService.create(id, column);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/api/v1/column/{id}")
    public ResponseEntity<MyResponseUtility> put(@PathVariable(value = "id") Integer id,
                                                 @RequestBody ColumnDomain column) {
        try {
            response.data = columnService.update(id, column);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}