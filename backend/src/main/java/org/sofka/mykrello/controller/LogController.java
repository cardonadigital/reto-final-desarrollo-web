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

/**
 * Controller endpoints of the log
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

@RestController
@CrossOrigin("*")
public class LogController {
    @Autowired
    private LogService logService;

    @Autowired
    private MyResponseUtility response;


    /**
     * Get the specific log
     *
     * @param id Log Id
     * @return the specific log object(LogDomain)
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @GetMapping(path = "/api/v1/log/{id}")
    public ResponseEntity<MyResponseUtility> getLogById(@PathVariable("id") Integer id) {
        try {
            response.data = logService.findById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Create a new log
     *
     * @param log log object(LogDomain)
     * @return the created log
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */
    @PostMapping(path = "/api/v1/log")
    public ResponseEntity<MyResponseUtility> create(@RequestBody LogDomain log) {
        try {
            response.data = logService.create(log);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
