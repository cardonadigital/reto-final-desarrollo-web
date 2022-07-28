package org.sofka.mykrello.model.domain.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;
@Data
@Entity
public class ColumnDTO {
    @Id
    private Integer id;

    private String name;

    @Transient
    private List<TaskDTO> tasks;

    public ColumnDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ColumnDTO() {

    }
}
