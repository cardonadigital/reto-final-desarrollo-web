package org.sofka.mykrello.model.service;

import java.util.List;

import org.sofka.mykrello.model.domain.LogDomain;
import org.sofka.mykrello.model.repository.LogRepository;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.service.interfaces.LogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService implements LogServiceInterface {
    @Autowired
    private LogRepository logRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public LogDomain findById(Integer id) {
        return logRepository.findById(id).get();
    }

    @Override
    public LogDomain create(LogDomain log) {
        var task = taskRepository.findById(log.getTaskId()).get();
        log.setTask(task);
        return logRepository.save(log);
    }
}
