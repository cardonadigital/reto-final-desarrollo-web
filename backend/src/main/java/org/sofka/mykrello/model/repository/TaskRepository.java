package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.TaskDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Task Repository (get functions from JPA)
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */


/**
 * Get List of tasks by it`s respective board and column
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */
public interface TaskRepository extends JpaRepository<TaskDomain, Integer> {
    @Query(value = "select * from krl_task\n" +
            "         join krl_board kb on krl_task.brd_id_board = kb.brd_id\n" +
            "where brd_id= ?1 and clm_id_column = ?2",
            nativeQuery = true)
    List<TaskDomain> getTasksByColumn(Integer idBoard, Integer idColumn);
}