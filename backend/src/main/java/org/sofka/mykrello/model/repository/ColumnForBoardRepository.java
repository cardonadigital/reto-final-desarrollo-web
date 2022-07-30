package org.sofka.mykrello.model.repository;

import org.sofka.mykrello.model.domain.ColumnForBoardDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ColumnForBoard Repository (get functions from JPA)
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */


public interface ColumnForBoardRepository extends JpaRepository<ColumnForBoardDomain, Integer> { }
