package org.sofka.mykrello.model.service;

import org.sofka.mykrello.model.domain.ColumnDomain;
import org.sofka.mykrello.model.domain.ColumnForBoardDomain;
import org.sofka.mykrello.model.domain.dto.ColumnDTO;
import org.sofka.mykrello.model.domain.dto.TaskDTO;
import org.sofka.mykrello.model.repository.BoardRepository;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.service.interfaces.ColumnServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all methods to the Column
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

@Service
public class ColumnService implements ColumnServiceInterface {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ColumnForBoardRepository columnForBoardRepository;

    /**
     * Get all columns
     *
     * @return all columns in database
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional(readOnly = true)
    public List<ColumnDomain> getAll() {
        return columnRepository.findAll();
    }

    /**
     * Find column by Id
     *
     * @param id column Id
     * @return specific column
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional(readOnly = true)
    public ColumnDomain findById(Integer id) {
        var column = columnRepository.findById(id);
        return column.isPresent() ? column.get() : null;
    }

    /**
     * Creta new column
     *
     * @param id     Board Id
     * @param column object ColumnDomain
     * @return created column
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional
    public ColumnDomain create(Integer id, ColumnDomain column) {
        var columnDB = columnRepository.save(column);
        var board = boardRepository.findById(id).get();
        var columnForBoard = new ColumnForBoardDomain();
        columnForBoard.setColumn(columnDB);
        columnForBoard.setBoard(board);
        columnForBoardRepository.save(columnForBoard);
        return columnDB;
    }

    /**
     * Update specific column
     *
     * @param id     column Id
     * @param column ColumnDomain
     * @return updated column
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional
    public ColumnDomain update(Integer id, ColumnDomain column) {
        column.setId(id);
        return columnRepository.save(column);
    }

    /**
     * Delete specific column
     *
     * @param id Column Id
     * @return deleted column
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional
    public ColumnDomain delete(Integer id) {
        return null;
    }

    /**
     * get DTO(columns and tasks) by Board Id
     *
     * @param id Board Id
     * @return List of Columns with their respective tasks
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Transactional
    public List<ColumnDTO> getDto(Integer id) {
        var columns = columnRepository.findAll();
        List<ColumnDTO> columnDto = new ArrayList<>();
        columns.forEach(column -> {

            var boardId = id;
            var columnId = column.getId();
            var tasks = getTaskDto(boardId, columnId);

            var dto = new ColumnDTO(column.getId(), column.getName(), tasks);
            columnDto.add(dto);
        });
        return columnDto;
    }

    /**
     * Get all task by Board and column
     *
     * @param idBoard  Board Id
     * @param columnId Column Id
     * @return List of tasks
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    private List<TaskDTO> getTaskDto(Integer idBoard, Integer columnId) {
        var tasks = taskRepository.getTasksByColumn(idBoard, columnId);
        List<TaskDTO> tasksByColumn = new ArrayList<>();
        tasks.forEach(task -> {
            tasksByColumn.add(new TaskDTO(task.getId(), task.getName()));
        });
        return tasksByColumn;
    }
}
