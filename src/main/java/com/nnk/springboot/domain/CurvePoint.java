package com.nnk.springboot.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.Instant;


@Entity
@Table(name = "curve_point")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@EntityListeners(AuditingEntityListener.class) // Enable auditing for fields annotated with (@CreatedDate, @CreateBy, @LastModifiedDate, @LastModifiedBy)
public class CurvePoint {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "curve_id")
    private Integer curveId;

    @Column(name = "as_of_date")
    private Instant asOfDate;

    @Column(name = "term")
    private Double term;

    @Column(name = "value")
    private Double value;

    @Column(name = "creation_date", nullable = false, updatable = false)
    @CreatedDate
    private Instant creationDate;

    /**
     * Constructor will all fields except Id.
     *
     * @param curveId
     * @param asOfDate
     * @param term
     * @param value
     * @param creationDate
     */
    public CurvePoint(
            Integer curveId,
            Instant asOfDate,
            Double term,
            Double value,
            Instant creationDate
    ) {
        this.curveId = curveId;
        this.asOfDate = asOfDate;
        this.term = term;
        this.value = value;
        this.creationDate = creationDate;
    }
}
