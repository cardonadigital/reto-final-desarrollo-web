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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller endpoints of the column
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

@RestController
@CrossOrigin(value = "*")
public class ColumnController {
    @Autowired
    private ColumnService columnService;

    @Autowired
    private MyResponseUtility response;


    /**
     * get all columns in database
     *
     * @return all columns objects(ColumnDomain)
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @GetMapping(path = "/api/v1/columns")
    public ResponseEntity<MyResponseUtility> getColumns() {
        try {
            response.data = columnService.getAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Get the columns and tasks of the specific board
     *
     * @param id Id of the board
     * @return columns and tasks of the board
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @GetMapping(path = "/api/v1/column/dto/{id}")
    public ResponseEntity<MyResponseUtility> getDTO(@PathVariable(value = "id") Integer id) {
        try {
            response.data = columnService.getDto(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Get specific column
     *
     * @param id Id of the column
     * @return object column(ColumnDomain)
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

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

    /**
     * creates new column in the specific board
     *
     * @param id     Board id
     * @param column object column (columnDomain)
     * @return the created column
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

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

    /**
     * Update the specific column
     *
     * @param id     column Id
     * @param column object column(ColumnDomain)
     * @return the updated column
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

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