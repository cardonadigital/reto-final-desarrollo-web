package org.sofka.mykrello.model.service;

import java.util.List;

import org.sofka.mykrello.model.domain.TaskDomain;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.service.interfaces.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements TaskServiceInterface {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private LogService logService;

    @Override
    public List<TaskDomain> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public TaskDomain findById(Integer id) {
        return taskRepository.findById(id).get();
    }

    /*create with */
    @Override
    public TaskDomain create(TaskDomain task) {
        return taskRepository.save(task);
    }

    @Override
    public TaskDomain update(Integer id, TaskDomain task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    @Override
    public TaskDomain delete(Integer id) {
        var task = taskRepository.findById(id).get();
        taskRepository.deleteById(id);
        return task;
    }


}