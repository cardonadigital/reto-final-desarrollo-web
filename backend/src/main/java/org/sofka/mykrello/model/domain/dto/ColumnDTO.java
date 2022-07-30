package org.sofka.mykrello.model.domain.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/**
 * DTO Object which shows columns and tasks
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */
@Data
@Entity
public class ColumnDTO {
    @Id
    private Integer id;

    private String name;

    @Transient
    private List<TaskDTO> tasks;

    public ColumnDTO(Integer id, String name, List<TaskDTO> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public ColumnDTO() {

    }
}
