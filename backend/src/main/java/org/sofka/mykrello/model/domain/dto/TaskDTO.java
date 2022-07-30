package org.sofka.mykrello.model.domain.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * DTO Object which shows tasks
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

@Data
@Entity
public class TaskDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public TaskDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TaskDTO() {

    }
}
