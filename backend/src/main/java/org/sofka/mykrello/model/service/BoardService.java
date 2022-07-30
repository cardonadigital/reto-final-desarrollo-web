package org.sofka.mykrello.model.service;

import java.util.List;

import org.sofka.mykrello.model.domain.BoardDomain;
import org.sofka.mykrello.model.domain.ColumnForBoardDomain;
import org.sofka.mykrello.model.repository.BoardRepository;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.service.interfaces.BoardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Contains all methods to the Board
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

@Service
public class BoardService implements BoardServiceInterface {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private ColumnForBoardRepository columnForBoardRepository;

    /**
     * Get list of all boards in database
     *
     * @return boards in database
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional(readOnly = true)
    public List<BoardDomain> getAll() {
        return boardRepository.findAll();
    }

    /**
     * Get board by Id
     *
     * @param id Board Id
     * @return Specific board
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional(readOnly = true)
    public BoardDomain findById(Integer id) {
        var board = boardRepository.findById(id);
        return board.isPresent() ? board.get() : null;
    }

    /**
     * Creates new board
     *
     * @param board Object(BoardDomain)
     * @return created board
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional
    public BoardDomain create(BoardDomain board) {
        var newBoard = boardRepository.save(board);
        var columns = columnRepository.findAll();
        if (!columns.isEmpty()) {
            columns.forEach(column -> {
                var columnForBoard = new ColumnForBoardDomain();
                columnForBoard.setColumn(column);
                columnForBoard.setBoard(newBoard);
                columnForBoardRepository.save(columnForBoard);
            });
        }
        return newBoard;
    }

    /**
     * Update specific board
     *
     * @param id    Board Id
     * @param board Object(BoardDomain)
     * @return updated board
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional
    public BoardDomain update(Integer id, BoardDomain board) {
        var boardRequest = boardRepository.findById(id).orElse(null);
        if (boardRequest == null) {
            throw new RuntimeException("no se ha encontrado id en database");
        }
        board.setId(id);
        return boardRepository.save(board);
    }

    /**
     * Delete specific board
     *
     * @param id Board Id
     * @return deleted board
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional
    public BoardDomain delete(Integer id) {
        var optionalBoard = boardRepository.findById(id);
        if (optionalBoard.isPresent()) {
            var board = optionalBoard.get();
            var columnsForBoard = board.getColumnsForBoard();
            if (!columnsForBoard.isEmpty()) {
                columnsForBoard.forEach((column) -> {
                    columnForBoardRepository.delete(column);
                });
            }
            boardRepository.delete(optionalBoard.get());
            return optionalBoard.get();
        }
        return null;
    }

}
