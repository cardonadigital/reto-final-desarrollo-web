package org.sofka.mykrello.model.service.interfaces;

import org.sofka.mykrello.model.domain.ColumnDomain;

import java.util.List;

/**
 * Contains all methods to be implemented
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

public interface ColumnServiceInterface {

    /**
     * Get all columns
     *
     * @return all columns
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public List<ColumnDomain> getAll();

    /**
     * Find column by id
     *
     * @param id column Id
     * @return the specific column
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public ColumnDomain findById(Integer id);

    /**
     * Create new Column
     *
     * @param id     Board Id
     * @param column object ColumnDomain
     * @return created column
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public ColumnDomain create(Integer id, ColumnDomain column);

    /**
     * Update specific column
     *
     * @param id     column Id
     * @param column ColumnDomain
     * @return updated column
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public ColumnDomain update(Integer id, ColumnDomain column);

    /**
     * Delete specific column
     *
     * @param id Column Id
     * @return deleted column
     * @author Daniel David Cardona - Paola Valentina
     * @version 1.0.0     30/07/2022
     * @since 1.0.0
     */

    public ColumnDomain delete(Integer id);
}