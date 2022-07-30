package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.domain.BoardDomain;
import org.sofka.mykrello.model.service.BoardService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Controller endpoints of the board
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

@RestController
@CrossOrigin(value = "*")
public class BoardController {

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private BoardService boardService;


    /**
     * Get all the boards(Object)
     *
     * @return list of object(BoardDomain)
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @GetMapping(path = "/api/v1/boards")
    public ResponseEntity<MyResponseUtility> index() {
        try {
            response.response(boardService.getAll());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Get board by it`s respective Id
     *
     * @param id Id of the board
     * @return object(BoardDomain)
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @GetMapping(path = "/api/v1/board/{id}")
    public ResponseEntity<MyResponseUtility> getBoardById(@PathVariable(value = "id") Integer id) {
        try {
            response.response(boardService.findById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * create board
     *
     * @param board object(BoardDomain)
     * @return the created object
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @PostMapping(path = "/api/v1/board")
    public ResponseEntity<MyResponseUtility> create(@RequestBody BoardDomain board) {
        try {
            response.response(boardService.create(board));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Update the specific board
     *
     * @param id    Id of the board
     * @param board object(BoardDomain)
     * @return the updated board
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @PutMapping(path = "/api/v1/board/{id}")
    public ResponseEntity<MyResponseUtility> put(@PathVariable(value = "id") Integer id,
                                                 @RequestBody BoardDomain board) {
        try {
            response.response(boardService.update(id, board));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * delete the specific board
     *
     * @param id Id of the board
     * @return the deleted board
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @DeleteMapping(path = "/api/v1/board/{id}")
    public ResponseEntity<MyResponseUtility> delete(@PathVariable(value = "id") Integer id) {
        try {
            response.response(boardService.delete(id));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.error(String.valueOf(e));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
