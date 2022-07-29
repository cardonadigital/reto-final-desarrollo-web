package org.sofka.mykrello.model.service;

import org.sofka.mykrello.model.domain.ColumnDomain;
import org.sofka.mykrello.model.domain.ColumnForBoardDomain;
import org.sofka.mykrello.model.domain.dto.ColumnDTO;
import org.sofka.mykrello.model.domain.dto.TaskDTO;
import org.sofka.mykrello.model.repository.BoardRepository;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.service.interfaces.ColumnServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColumnService implements ColumnServiceInterface {
    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ColumnForBoardRepository columnForBoardRepository;



    @Override
    public List<ColumnDomain> getAll() {
        return columnRepository.findAll();
    }

    @Override
    public ColumnDomain findById(Integer id) {
        var column = columnRepository.findById(id);
        return column.isPresent() ? column.get() : null;
    }

    @Override
    public ColumnDomain create(Integer id, ColumnDomain column) {
        var columnDB = columnRepository.save(column);
        var board = boardRepository.findById(id).get();
        var columnForBoard = new ColumnForBoardDomain();
        columnForBoard.setColumn(columnDB);
        columnForBoard.setBoard(board);
        columnForBoardRepository.save(columnForBoard);
        return columnDB;
    }

    @Override
    public ColumnDomain update(Integer id, ColumnDomain column) {
        column.setId(id);
        return columnRepository.save(column);
    }

    @Override
    public ColumnDomain delete(Integer id) {
        return null;
    }


    public List<ColumnDTO> getDto(Integer id){
        var columns = columnRepository.findAll();
        List<ColumnDTO> columnDto = new ArrayList<>();
        columns.forEach(column->{
            var dto = new ColumnDTO(column.getId(), column.getName());
            columnDto.add(dto);
        });
        return columnDto;
    }

    /*private List<TaskDTO> getTaskDto(Integer idBoard, Integer idColumn){
        ...cuando termine task volver
    }*/
}
