<<<<<<< HEAD
package org.sofka.mykrello.model.service.interfaces;

import org.sofka.mykrello.model.domain.ColumnDomain;

import java.util.List;

public interface ColumnServiceInterface {

    public List<ColumnDomain> getAll();

    public ColumnDomain findById(Integer id);

    public ColumnDomain create(Integer id, ColumnDomain column);

    public ColumnDomain update(Integer id, ColumnDomain column);

    public ColumnDomain delete(Integer id);
}
=======
package org.sofka.mykrello.model.service.interfaces;

import org.sofka.mykrello.model.domain.ColumnDomain;

import java.util.List;

public interface ColumnServiceInterface {

    public List<ColumnDomain> getAll();

    public ColumnDomain findById(Integer id);

    public ColumnDomain create(Integer id, ColumnDomain column);

    public ColumnDomain update(Integer id, ColumnDomain column);

    public ColumnDomain delete(Integer id);
}
>>>>>>> 6e1b31969ffd0905d646daeffe851573779e6383
