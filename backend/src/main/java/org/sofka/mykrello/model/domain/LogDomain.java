package org.sofka.mykrello.model.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

/**
 * Log Object which is mapped into database
 *
 * @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */

@Data
@Entity
@Table(name = "krl_log")
public class LogDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "tsk_id_task")
    private Integer taskId;

    @Column(name = "clm_id_previous")
    private Integer previousId;

    @Column(name = "clm_id_current")
    private Integer currentId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TaskDomain.class, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "tsk_id_task", nullable = false, updatable = false, insertable = false)
    @JsonBackReference(value = "logs")
    private TaskDomain task;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ColumnDomain.class, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "clm_id_previous", nullable = false, updatable = false, insertable = false)
    @JsonBackReference(value = "logPrevious")
    private ColumnDomain previous;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ColumnDomain.class, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "clm_id_current", nullable = false, updatable = false, insertable = false)
    @JsonBackReference(value = "logCurrent")
    private ColumnDomain current;

    @Column(name = "log_created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

}
