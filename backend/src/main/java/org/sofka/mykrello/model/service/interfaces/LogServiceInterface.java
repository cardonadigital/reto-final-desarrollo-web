package org.sofka.mykrello.model.service.interfaces;

import java.util.List;

import org.sofka.mykrello.model.domain.LogDomain;

/**
 * Contains all methods to be implemented
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

public interface LogServiceInterface {

    /**
     * Find log by Id
     *
     * @param id log Id
     * @return the specific log
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public LogDomain findById(Integer id);

    /**
     * Create new log
     *
     * @param log LogDomain
     * @return created log
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public LogDomain create(LogDomain log);
}
