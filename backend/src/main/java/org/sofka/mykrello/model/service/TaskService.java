package org.sofka.mykrello.model.service;

import java.util.List;

import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.service.interfaces.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Contains all methods to the Task
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

@Service
public class TaskService implements TaskServiceInterface {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private LogService logService;

    /**
     * Find all tasks in database
     *
     * @return list of tasks
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional(readOnly = true)
    public List<TaskDomain> findAll() {
        return taskRepository.findAll();
    }

    /**
     * Find Task By Id
     *
     * @param id task Id
     * @return Specific task
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */
    @Override
    @Transactional(readOnly = true)
    public TaskDomain findById(Integer id) {
        return taskRepository.findById(id).get();
    }

    /**
     * Creates new task
     *
     * @param task TaskDomain
     * @return created task
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */
    @Override
    @Transactional
    public TaskDomain create(TaskDomain task) {
        return taskRepository.save(task);
    }

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
    @Override
    @Transactional
    public TaskDomain update(Integer id, TaskDomain task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    /**
     * Deletes specific task
     *
     * @param id Task Id
     * @return deleted task
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */
    @Override
    @Transactional
    public TaskDomain delete(Integer id) {
        var task = taskRepository.findById(id).get();
        taskRepository.deleteById(id);
        return task;
    }


}