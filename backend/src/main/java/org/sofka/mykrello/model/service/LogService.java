package org.sofka.mykrello.model.service;

import java.util.List;

import org.sofka.mykrello.model.domain.LogDomain;
import org.sofka.mykrello.model.repository.LogRepository;
import org.sofka.mykrello.model.repository.TaskRepository;
import org.sofka.mykrello.model.service.interfaces.LogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Contains all methods to the Log
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

@Service
public class LogService implements LogServiceInterface {
    @Autowired
    private LogRepository logRepository;

    @Autowired
    private TaskRepository taskRepository;

    /**
     * Find Log by Id
     *
     * @param id log Id
     * @return specific log
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    @Override
    @Transactional(readOnly = true)
    public LogDomain findById(Integer id) {
        return logRepository.findById(id).get();
    }

    /**
     * Cretaes new log
     *
     * @param log LogDomain
     * @return created log
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */
    @Override
    @Transactional
    public LogDomain create(LogDomain log) {
        var task = taskRepository.findById(log.getTaskId()).get();
        log.setTask(task);
        return logRepository.save(log);
    }
}
