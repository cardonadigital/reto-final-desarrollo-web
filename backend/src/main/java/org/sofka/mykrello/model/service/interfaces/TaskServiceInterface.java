package org.sofka.mykrello.model.service.interfaces;

import java.util.List;

import org.sofka.mykrello.model.domain.TaskDomain;

/**
 * Contains all methods to be implemented
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

public interface TaskServiceInterface {

    /**
     * Find all tasks in database
     *
     * @return tasks in database
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public List<TaskDomain> findAll();

    /**
     * Find task by id
     *
     * @param id task Id
     * @return specific task
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public TaskDomain findById(Integer id);

    /**
     * Creates new task
     *
     * @param task TaskDomain
     * @return created task
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public TaskDomain create(TaskDomain task);

    /**
     * Update specific task
     *
     * @param id   Task Id
     * @param task TaskDomain
     * @return updated task
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public TaskDomain update(Integer id, TaskDomain task);

    /**
     * Delete specific task
     *
     * @param id Task Id
     * @return deleted task
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public TaskDomain delete(Integer id);

}
